package br.com.kabum.msshipping.domain.shippingcompany.valueobject;

public record Product(
    Integer width,
    Integer height,
    Integer weight
) {
    public static Product with(final Integer aWidth, final Integer aHeight, final Integer aWeight) {
        return new Product(aWidth, aHeight, aWeight);
    }
}
