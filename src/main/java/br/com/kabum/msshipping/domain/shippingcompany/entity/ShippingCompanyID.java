package br.com.kabum.msshipping.domain.shippingcompany.entity;

import java.util.Objects;
import java.util.UUID;

import br.com.kabum.msshipping.domain.Identifier;

public class ShippingCompanyID extends Identifier {
    
    private final String value;

    private ShippingCompanyID(final String anId) {
        Objects.requireNonNull(anId);
        this.value = anId;
    }

    public static ShippingCompanyID unique() {
        return ShippingCompanyID.from(UUID.randomUUID());
    }

    public static ShippingCompanyID from(String anId) {
        return new ShippingCompanyID(anId);
    }

    public static ShippingCompanyID from(UUID anId) {
        return new ShippingCompanyID(anId.toString().toLowerCase());
    }

    @Override
    public String value() {
        return this.value;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ShippingCompanyID other = (ShippingCompanyID) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }
}
