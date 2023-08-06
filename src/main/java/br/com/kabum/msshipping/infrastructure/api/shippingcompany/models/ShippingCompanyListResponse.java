package br.com.kabum.msshipping.infrastructure.api.shippingcompany.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ShippingCompanyListResponse(
    @JsonProperty("nome") String name,
	@JsonProperty("valor_frete") Double value,
	@JsonProperty("prazo_dias") Integer deadline
) {
    public static ShippingCompanyListResponse width(final String aName, final Double aValue, final Integer aDeadline) {
		return new ShippingCompanyListResponse(aName, aValue, aDeadline);
	}
}
