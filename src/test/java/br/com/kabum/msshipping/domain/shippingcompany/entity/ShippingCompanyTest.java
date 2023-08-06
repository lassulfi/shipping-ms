package br.com.kabum.msshipping.domain.shippingcompany.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import br.com.kabum.msshipping.domain.shippingcompany.validator.KabumShippingValidator;
import br.com.kabum.msshipping.domain.shippingcompany.validator.NinjaShippingValidator;
import br.com.kabum.msshipping.domain.shippingcompany.valueobject.Product;

public class ShippingCompanyTest {
    
    @Test
    void givenValidParams_whenCallNewShippingCompany_shouldInstantiateShippingCompany() {
        final var expectedName = "Entrega Kabum";
        final var expectedDeadline = 5;
        final var expectedCalculationConstant = 0.2;
    
        final var actualShippingCompany = ShippingCompany.newShippingCompany(expectedName, expectedDeadline, expectedCalculationConstant);

        assertNotNull(actualShippingCompany);
        assertNotNull(actualShippingCompany.id());
        assertEquals(expectedName, actualShippingCompany.name());
        assertEquals(expectedDeadline, actualShippingCompany.deadline());
        assertEquals(expectedCalculationConstant, actualShippingCompany.calculationConstant());
        assertNull(actualShippingCompany.value());
        assertNull(actualShippingCompany.product());
    }

    @Test
    void givenAValidProduct_whenCallChangeProduct_shouldChangeProduct() {
        final var actualCompanyName = "Entrega Kabum";
        final var actualDeadline = 5;
        final var actualCalculationConstant = 0.2; 

        final var actualShippingCompany = ShippingCompany.newShippingCompany(actualCompanyName, actualDeadline, actualCalculationConstant);

        assertNotNull(actualShippingCompany);
        assertNull(actualShippingCompany.product());

        final var expectedWith = 100;
        final var expectedHeight = 100;
        final var expectedWeight = 100;

        actualShippingCompany.setValidator(new KabumShippingValidator(actualShippingCompany.notification(), actualShippingCompany));
        actualShippingCompany.changeProduct(Product.with(expectedWith, expectedHeight, expectedWeight));

        assertNotNull(actualShippingCompany.product());
        assertEquals(expectedWith, actualShippingCompany.product().width());
        assertEquals(expectedHeight, actualShippingCompany.product().height());
        assertEquals(expectedWeight, actualShippingCompany.product().weight());
    }

    @Test
    void givenAValidProduct_whenCallCalculateValue_shouldCalculateProduct() {
        final var actualCompanyName = "Entrega Kabum";
        final var actualDeadline = 5;
        final var actualCalculationConstant = 0.2; 

        final var actualShippingCompany = ShippingCompany.newShippingCompany(actualCompanyName, actualDeadline, actualCalculationConstant);

        assertNotNull(actualShippingCompany);
        assertNull(actualShippingCompany.product());

        final var expectedWith = 100;
        final var expectedHeight = 100;
        final var expectedWeight = 100;

        actualShippingCompany.setValidator(new KabumShippingValidator(actualShippingCompany.notification(), actualShippingCompany));

        actualShippingCompany.changeProduct(Product.with(expectedWith, expectedHeight, expectedWeight));
        
        assertNotNull(actualShippingCompany.product());
        
        actualShippingCompany.calculateValue();
        assertNotNull(actualShippingCompany.value());
    }

    @Test
    void givenAnInvalidProduct_whenCallCalculateValue_shouldNotCalculateValue() {
        final var actualCompanyName = "Entrega Kabum";
        final var actualDeadline = 5;
        final var actualCalculationConstant = 0.2; 

        final var actualShippingCompany = ShippingCompany.newShippingCompany(actualCompanyName, actualDeadline, actualCalculationConstant);

        assertNotNull(actualShippingCompany);
        assertNull(actualShippingCompany.product());

        final var invalidWidth = 0;
        final var invalidHeight = 0;
        final var invalidWeight = -1;

        actualShippingCompany.setValidator(new KabumShippingValidator(actualShippingCompany.notification(), actualShippingCompany));

        actualShippingCompany.changeProduct(Product.with(invalidWidth, invalidHeight, invalidWeight));
        
        assertNotNull(actualShippingCompany.product());

        final var expectedErrorCount = 3;

        actualShippingCompany.calculateValue();

        assertNull(actualShippingCompany.value());
        assertTrue(actualShippingCompany.notification().hasErrors());
        assertEquals(expectedErrorCount, actualShippingCompany.notification().errors().size());
    }

    @Test
    void givenAnInvalidProduct_whenCallValidate_thenShouldGetErrors() {
        final var actualCompanyName = "Entrega Kabum";
        final var actualDeadline = 5;
        final var actualCalculationConstant = 0.2; 

        final var kabumShippingCompany = ShippingCompany.newShippingCompany(actualCompanyName, actualDeadline, actualCalculationConstant);

        assertNotNull(kabumShippingCompany);
        assertNull(kabumShippingCompany.product());

        final var invalidWidth = 0;
        final var invalidHeight = 0;
        final var invalidWeight = -1;

        final var expectedErrorCount = 3;

        kabumShippingCompany.setValidator(new KabumShippingValidator(kabumShippingCompany.notification(), kabumShippingCompany));
        kabumShippingCompany.changeProduct(Product.with(invalidWidth, invalidHeight, invalidWeight));

        assertTrue(kabumShippingCompany.notification().hasErrors());
        assertEquals(expectedErrorCount, kabumShippingCompany.notification().errors().size());

        final var ninjaShippingCompany = ShippingCompany.newShippingCompany(actualCompanyName, actualDeadline, actualCalculationConstant);

        assertNotNull(ninjaShippingCompany);
        assertNull(ninjaShippingCompany.product());

        ninjaShippingCompany.setValidator(new NinjaShippingValidator(ninjaShippingCompany.notification(), ninjaShippingCompany));
        ninjaShippingCompany.changeProduct(Product.with(invalidWidth, invalidHeight, invalidWeight));

        assertTrue(ninjaShippingCompany.notification().hasErrors());
        assertEquals(expectedErrorCount, ninjaShippingCompany.notification().errors().size());
    }
}
