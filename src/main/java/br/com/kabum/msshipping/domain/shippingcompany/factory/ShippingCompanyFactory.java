package br.com.kabum.msshipping.domain.shippingcompany.factory;

import br.com.kabum.msshipping.domain.shippingcompany.entity.ShippingCompany;
import br.com.kabum.msshipping.domain.shippingcompany.validator.KabumShippingValidator;
import br.com.kabum.msshipping.domain.shippingcompany.validator.NinjaShippingValidator;

public class ShippingCompanyFactory {
    
    public static ShippingCompany createKabum() {
        final var shippingCompany = ShippingCompany.newShippingCompany("Entrega KaBuM", 4, 0.2);
        final var shippingValidator = new KabumShippingValidator(shippingCompany.notification(), shippingCompany);

        shippingCompany.setValidator(shippingValidator);

        return shippingCompany;
    }

    public static ShippingCompany createNinja() {
        final var shippingCompany = ShippingCompany.newShippingCompany("Entrega Ninja", 6, 0.3);
        final var shippingValidator = new NinjaShippingValidator(shippingCompany.notification(), shippingCompany);

        shippingCompany.setValidator(shippingValidator);

        return shippingCompany;
    }
}
