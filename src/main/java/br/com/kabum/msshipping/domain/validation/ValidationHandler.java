package br.com.kabum.msshipping.domain.validation;

import java.util.List;

public interface ValidationHandler {
    ValidationHandler append(Error anError);

    ValidationHandler append(ValidationHandler anHandler);

    ValidationHandler validate(Validation aValidation);

    List<Error> errors();

    default boolean hasErrors() {
        return errors() != null && !errors().isEmpty();
    }

    public interface Validation {
        void validate();
    }
}
