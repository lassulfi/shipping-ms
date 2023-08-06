package br.com.kabum.msshipping.domain.shippingcompany.factory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class ShippingCompanyFactoryTest {
    
    @Test
    void givenValidParams_WhenCallCreateKabum_thenShouldCreateKabumShippingCompany() {
        final var expectedName = "Entrega KaBuM";
        final var expectedDeadline = 4;
        final var expectedCalculationConstant = 0.2;

        final var actualShippingCompany = ShippingCompanyFactory.createKabum();

        assertNotNull(actualShippingCompany);
        assertEquals(expectedName, actualShippingCompany.name());
        assertEquals(expectedDeadline, actualShippingCompany.deadline());
        assertEquals(expectedCalculationConstant, actualShippingCompany.calculationConstant());
        assertNull(actualShippingCompany.product());
        assertNull(actualShippingCompany.value());
    }

    @Test
    void givenValidParams_whenCallCreateNinja_thenShouldCreateNinjaShippingCompany() {
        final var expectedName = "Entrega Ninja";
        final var expectedDeadline = 6;
        final var expectedCalculationConstant = 0.3;

        final var actualShippingCompany = ShippingCompanyFactory.createNinja();

        assertNotNull(actualShippingCompany);
        assertEquals(expectedName, actualShippingCompany.name());
        assertEquals(expectedDeadline, actualShippingCompany.deadline());
        assertEquals(expectedCalculationConstant, actualShippingCompany.calculationConstant());
        assertNull(actualShippingCompany.product());
        assertNull(actualShippingCompany.value());
    }
}
