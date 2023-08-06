package br.com.kabum.msshipping.insfrastructure.api.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.Objects;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.kabum.msshipping.application.shippingcompany.retrieve.list.ListShippingCompanyUseCase;
import br.com.kabum.msshipping.application.shippingcompany.retrieve.list.ShippingCompanyListOutput;
import br.com.kabum.msshipping.infrastructure.api.controllers.ShippingCompanyController;
import br.com.kabum.msshipping.infrastructure.api.shippingcompany.models.ListShippingCompaniesRequest;

@WebMvcTest(ShippingCompanyController.class)
public class ShippingCompanyControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private ListShippingCompanyUseCase listShippingCompanyUseCase;

    @Test
    void givenAValidCommand_whenCallsListShippingCompanies_ShouldReturnAValidList() throws Exception {
        final var expectedHeight = 102;
        final var expectedWidth = 40;
        final var expectedWeight = 400;

        final var expectedItems =  List.of(
            ShippingCompanyListOutput.width("Entrega Ninja", 12.0, 6),
            ShippingCompanyListOutput.width("Entrega KaBuM", 8.0, 4)
        );

        final var expectedItemCount = 2;

        final var anInput = ListShippingCompaniesRequest.with(expectedWidth, expectedHeight, expectedWeight);

        when(listShippingCompanyUseCase.execute(any())).thenReturn(expectedItems);
        
        final var request = post("/shipping-companies")
            .contentType(MediaType.APPLICATION_JSON)
            .content(this.mapper.writeValueAsString(anInput));

        final var response = this.mvc.perform(request)
            .andDo(print());
        
        response.andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(expectedItemCount));
        
        verify(listShippingCompanyUseCase, times(1)).execute(argThat(input -> 
            Objects.equals(expectedHeight, input.height())
            && Objects.equals(expectedWidth, input.width())
            && Objects.equals(expectedWeight, input.weight())
        ));
    }
}
