package br.com.kabum.msshipping.domain;

import br.com.kabum.msshipping.domain.validation.Validator;

public abstract class Entity<ID extends Identifier> {
    
    protected final ID id;

    protected Validator validator;

    protected Entity(final ID id) {
        this.id = id;
    }

    public abstract void validate();

    public void setValidator(Validator aValidator) {
        this.validator = aValidator;        
    }

    public ID id() {
        return this.id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        Entity<?> other = (Entity<?>) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    
}
