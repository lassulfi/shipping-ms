package br.com.kabum.msshipping.infrastructure.api.shippingcompany.presenters;

import br.com.kabum.msshipping.application.shippingcompany.retrieve.list.ShippingCompanyListOutput;
import br.com.kabum.msshipping.infrastructure.api.shippingcompany.models.ShippingCompanyListResponse;

public class ShippingCompanyApiPresenter {
    
    public static ShippingCompanyListResponse present(final ShippingCompanyListOutput output) {
        return new ShippingCompanyListResponse(output.name(), output.value(), output.deadline());
    }
}
