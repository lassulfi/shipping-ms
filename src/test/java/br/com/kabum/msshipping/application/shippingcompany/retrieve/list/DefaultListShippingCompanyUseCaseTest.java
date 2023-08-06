package br.com.kabum.msshipping.application.shippingcompany.retrieve.list;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class DefaultListShippingCompanyUseCaseTest {
    
    @Test
    void givenAValidProduct_WhenCallExecute_ThenShouldCalculateAllShippingValues() {
        final var expectedNinjaName = "Entrega Ninja";
        final var expectedNinjaValue = 12.0;
        final var expectedNinjaDeadline = 6;
        final var expectedKabumName = "Entrega KaBuM";
        final var expectedKabumValue = 8.0;
        final var expectedKabumDeadline = 4;
        final var expectedShippingValues = 2;

        final var actualCommand = ListShippingCompanyCommand.with(40, 102, 400);

        final var useCase = new DefaultListShippingCompanyUseCase();

        final var actualOutput = useCase.execute(actualCommand);

        assertNotNull(actualOutput);
        assertEquals(expectedShippingValues, actualOutput.size());
    }

    @Test
    void givenAnInvalidKabumProduct_whenCallExecute_thenShouldCalculateNinjaShipping() {
        final var expectedNinjaName = "Entrega Ninja";
        final var expectedNinjaValue = 25.5;
        final var expectedNinjaDeadline = 6;
        final var expectedShippingValues = 1;

        final var actualCommand = ListShippingCompanyCommand.with(50, 152, 850);

        final var useCase = new DefaultListShippingCompanyUseCase();

        final var actualOutput = useCase.execute(actualCommand);

        assertNotNull(actualOutput);
        assertEquals(expectedShippingValues, actualOutput.size());
        assertEquals(expectedNinjaName, actualOutput.get(0).name());
        assertEquals(expectedNinjaValue, actualOutput.get(0).value());
        assertEquals(expectedNinjaDeadline, actualOutput.get(0).deadline());
    }

    @Test
    void givenAnInvalidNinjaProduct_whenCallExecute_thenShouldCalculateKabumShipping() {
        final var expectedKabumName = "Entrega KaBuM";
        final var expectedKabumValue = 17.0;
        final var expectedKabumDeadline = 4;
        final var expectedShippingValues = 1;

        final var actualCommand = ListShippingCompanyCommand.with(50, 7, 850);

        final var useCase = new DefaultListShippingCompanyUseCase();

        final var actualOutput = useCase.execute(actualCommand);

        assertNotNull(actualOutput);
        assertEquals(expectedShippingValues, actualOutput.size());
        assertEquals(expectedKabumName, actualOutput.get(0).name());
        assertEquals(expectedKabumValue, actualOutput.get(0).value());
        assertEquals(expectedKabumDeadline, actualOutput.get(0).deadline());
    }

    @Test
    void givenAnInvalidProduct_whenCallExecute_thenShouldReturnAnEmptyList() {
        final var actualCommand = ListShippingCompanyCommand.with(162, 230, 5600);

        final var useCase = new DefaultListShippingCompanyUseCase();

        final var actualOutput = useCase.execute(actualCommand);

        assertNotNull(actualOutput);
        assertTrue(actualOutput.isEmpty());
    }
}
