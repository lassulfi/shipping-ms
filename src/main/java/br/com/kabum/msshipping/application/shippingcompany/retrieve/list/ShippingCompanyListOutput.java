package br.com.kabum.msshipping.application.shippingcompany.retrieve.list;

import br.com.kabum.msshipping.domain.shippingcompany.entity.ShippingCompany;

public record ShippingCompanyListOutput(
	String name,
	Double value,
	Integer deadline) {
    public static ShippingCompanyListOutput from(final ShippingCompany aShippingCompany) {
        return new ShippingCompanyListOutput(aShippingCompany.name(), aShippingCompany.value(),
                aShippingCompany.deadline());
    }

    public static ShippingCompanyListOutput width(final String aName, final Double aValue, final Integer aDeadline) {
        return new ShippingCompanyListOutput(aName, aValue, aDeadline);
    }
}
