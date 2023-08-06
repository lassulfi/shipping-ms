package br.com.kabum.msshipping.domain.validation.handler;

import java.util.ArrayList;
import java.util.List;

import br.com.kabum.msshipping.domain.exceptions.DomainException;
import br.com.kabum.msshipping.domain.validation.Error;
import br.com.kabum.msshipping.domain.validation.ValidationHandler;

public class Notification implements ValidationHandler {

    private final List<Error> errors;


    private Notification(final List<Error> errors) {
        this.errors = errors;
    }

    public static Notification create() {
        return new Notification(new ArrayList<>());
    }

    public static Notification create(final Error anError) {
        return new Notification(new ArrayList<>()).append(anError);
    }

    @Override
    public Notification append(Error anError) {
        this.errors.add(anError);

        return this;
    }

    @Override
    public Notification append(ValidationHandler anHandler) {
        this.errors.addAll(anHandler.errors());
        return this;
    }

    @Override
    public Notification validate(Validation aValidation) {
        try {
            aValidation.validate();
        } catch (final DomainException ex) {
            this.errors.addAll(ex.errors());
        } catch (final Throwable t) {
            this.errors.add(new Error(t.getMessage()));
        }
        return this;
    }

    @Override
    public List<Error> errors() {
        return this.errors;
    }
}
