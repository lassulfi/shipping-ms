package br.com.kabum.msshipping.domain.validation;

public abstract class Validator {
    
    private final ValidationHandler handler;

    protected Validator(ValidationHandler aHandler) {
        this.handler = aHandler;
    }

    public abstract void validate();

    protected ValidationHandler validationHandler() {
        return this.handler;
    }
}
