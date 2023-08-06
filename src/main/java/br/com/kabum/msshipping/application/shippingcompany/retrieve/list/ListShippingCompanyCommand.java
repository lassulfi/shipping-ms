package br.com.kabum.msshipping.application.shippingcompany.retrieve.list;

public record ListShippingCompanyCommand(
    Integer width,
    Integer height,
    Integer weight
) {
    public static ListShippingCompanyCommand with(final Integer aWidth, final Integer aHeight, final Integer aWeight) {
        return new ListShippingCompanyCommand(aWidth, aHeight, aWeight);
    }
}
