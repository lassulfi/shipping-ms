package br.com.kabum.msshipping.domain.exceptions;

import java.util.List;

import br.com.kabum.msshipping.domain.validation.Error;

public class DomainException extends NoStackTraceException {

    protected final List<Error> errors;

    protected DomainException(final String aMessage, final List<Error> someErrors) {
        super(aMessage);
        this.errors = someErrors;
    }

    public static DomainException with(final Error anError) {
        return new DomainException(anError.message(), List.of(anError));
    }

    public static DomainException with(final List<Error> someErrors) {
        return new DomainException("", someErrors);
    }

    public List<Error> errors() {
        return this.errors;
    }
}
