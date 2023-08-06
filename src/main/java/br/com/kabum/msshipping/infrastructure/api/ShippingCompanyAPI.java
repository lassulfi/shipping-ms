package br.com.kabum.msshipping.infrastructure.api;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.kabum.msshipping.infrastructure.api.shippingcompany.models.ListShippingCompaniesRequest;
import br.com.kabum.msshipping.infrastructure.api.shippingcompany.models.ShippingCompanyListResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RequestMapping(value = "shipping-companies")
@Tag(name = "Shipping Companies")
public interface ShippingCompanyAPI {
    
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "List all shipping companies", description = "List all shipping companies and the current shipping value")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Shipping companies retrieved"),
        @ApiResponse(responseCode = "400", description = "An internal server error was thrown")
    })
    List<ShippingCompanyListResponse> list(final @RequestBody ListShippingCompaniesRequest input);
}
