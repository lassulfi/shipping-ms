package br.com.kabum.msshipping.infrastructure.api.shippingcompany.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ListShippingCompaniesRequest(
	@JsonProperty("dimensao") Dimension dimension,
	@JsonProperty("peso") Integer weight
) {
	public static ListShippingCompaniesRequest with(final Integer aWidth, final Integer aHeight, final Integer aWeight) {
		final var aDimension = new Dimension(aHeight, aWidth);
		return new ListShippingCompaniesRequest(aDimension, aWeight);
	}
}
