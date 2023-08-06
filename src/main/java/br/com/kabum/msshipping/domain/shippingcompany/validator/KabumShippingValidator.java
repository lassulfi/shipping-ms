package br.com.kabum.msshipping.domain.shippingcompany.validator;

import br.com.kabum.msshipping.domain.shippingcompany.entity.ShippingCompany;
import br.com.kabum.msshipping.domain.validation.Error;
import br.com.kabum.msshipping.domain.validation.ValidationHandler;
import br.com.kabum.msshipping.domain.validation.Validator;

public class KabumShippingValidator extends Validator {

    private static final int MIN_HEIGHT = 5;
    private static final int MAX_HEIGHT = 140;
    private static final int MIN_WIDTH = 13;
    private static final int MAX_WIDTH = 125;
    private static final int MIN_WEIGHT = 0;

    private final ShippingCompany shippingCompany;

    public KabumShippingValidator(final ValidationHandler aHandler, final ShippingCompany aShippingCompany) {
        super(aHandler);
        this.shippingCompany = aShippingCompany;
    }

    @Override
    public void validate() {
        checkHeightConstraints();
        checkWithConstraints();
        checkWeightConstraint();
    }

    private void checkHeightConstraints() {
        final var height = this.shippingCompany.product().height();

        if (height < MIN_HEIGHT || height > MAX_HEIGHT) {
            this.validationHandler().append(new Error(String.format("'height' must be between %d and %d", MIN_HEIGHT, MAX_HEIGHT)));
        }
    }

    private void checkWithConstraints() {
        final var width = this.shippingCompany.product().width();

        if (width < MIN_WIDTH || width > MAX_WIDTH) {
            this.validationHandler().append(new Error(String.format("'width' must be between %d and %d", MIN_WIDTH, MAX_WIDTH)));
        }
    }

    private void checkWeightConstraint() {
        final var weight = this.shippingCompany.product().weight();

        if (weight < MIN_WEIGHT) {
            this.validationHandler().append(new Error(String.format("'weight' must be greater then %d", MIN_WEIGHT)));
        } 
    }
}
