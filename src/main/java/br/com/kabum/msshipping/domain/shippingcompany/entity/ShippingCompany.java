package br.com.kabum.msshipping.domain.shippingcompany.entity;

import br.com.kabum.msshipping.domain.AggregateRoot;
import br.com.kabum.msshipping.domain.shippingcompany.valueobject.Product;
import br.com.kabum.msshipping.domain.validation.ValidationHandler;
import br.com.kabum.msshipping.domain.validation.handler.Notification;

public class ShippingCompany extends AggregateRoot<ShippingCompanyID> {

    private String name;
    private Double value;
    private Integer deadline;
    private Double calculationConstant;
    private Product product;

    private ValidationHandler notification;

    protected ShippingCompany(final ShippingCompanyID id, final String aName, final Double aValue, final Integer aDeadline, final Double aCalculationConstant) {
        super(id);
        this.name = aName;
        this.value = aValue;
        this.deadline = aDeadline;
        this.calculationConstant = aCalculationConstant;

        this.notification = Notification.create();
    }
    
    public static ShippingCompany newShippingCompany(final String aName, final Integer aDeadline, final Double aCalculationConstant) {
        final var anId = ShippingCompanyID.unique();
        return new ShippingCompany(anId, aName, null, aDeadline, aCalculationConstant);
    }

    public static ShippingCompany with(final ShippingCompanyID anId, final String aName, final Double aValue, final Integer aDeadline, final Double aCalculationConstant) {
        return new ShippingCompany(anId, aName, aValue, aDeadline, aCalculationConstant);
    }

    public ShippingCompany changeProduct(final Product aProduct) {
        this.product = aProduct;
        this.validate();

        return this;
    }

    public ShippingCompany calculateValue() {
        if(this.notification.hasErrors()) {
            return null;
        }

        applyShippingCalculationFormula();

        return this;
    }

    private void applyShippingCalculationFormula() {
        this.value = this.calculationConstant * this.product.weight() / 10.0;
    }

    public String name() {
        return this.name;
    }

    public Double value() {
        return this.value;
    }

    public Integer deadline() {
        return this.deadline;
    }

    public Double calculationConstant() {
        return this.calculationConstant;
    }

    public Product product() {
        return this.product;
    }

    public ValidationHandler notification() {
        return this.notification;
    }

    @Override
    public void validate() {
        this.validator.validate();
    }
}
