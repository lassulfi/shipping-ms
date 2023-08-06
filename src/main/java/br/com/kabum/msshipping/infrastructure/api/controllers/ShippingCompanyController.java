package br.com.kabum.msshipping.infrastructure.api.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.RestController;

import br.com.kabum.msshipping.application.shippingcompany.retrieve.list.ListShippingCompanyCommand;
import br.com.kabum.msshipping.application.shippingcompany.retrieve.list.ListShippingCompanyUseCase;
import br.com.kabum.msshipping.infrastructure.api.ShippingCompanyAPI;
import br.com.kabum.msshipping.infrastructure.api.shippingcompany.models.ListShippingCompaniesRequest;
import br.com.kabum.msshipping.infrastructure.api.shippingcompany.models.ShippingCompanyListResponse;
import br.com.kabum.msshipping.infrastructure.api.shippingcompany.presenters.ShippingCompanyApiPresenter;

@RestController
public class ShippingCompanyController implements ShippingCompanyAPI {

    private final ListShippingCompanyUseCase listShippingCompanyUseCase;

    public ShippingCompanyController(ListShippingCompanyUseCase listShippingCompanyUseCase) {
        this.listShippingCompanyUseCase = listShippingCompanyUseCase;
    }

    @Override
    public List<ShippingCompanyListResponse> list(ListShippingCompaniesRequest input) {
        final var aCommand = ListShippingCompanyCommand.with(input.dimension().width(), input.dimension().height(),
                input.weight());

        return this.listShippingCompanyUseCase.execute(aCommand).stream().map(ShippingCompanyApiPresenter::present)
                .collect(Collectors.toList());
    }

}
