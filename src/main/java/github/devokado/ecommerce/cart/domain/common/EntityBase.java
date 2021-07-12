package github.devokado.ecommerce.cart.domain.common;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public abstract class EntityBase extends AssertionConcern implements Serializable {

    private static final long serialVersionUID = 1L;

    private int concurrencyVersion;

    @Id
    private long id;

    private boolean deleted;

    public EntityBase() {
        super();

        this.setId(-1);
    }

    public int concurrencyVersion() {
        return this.concurrencyVersion;
    }

    public void setConcurrencyVersion(int aVersion) {
        this.failWhenConcurrencyViolation(aVersion);
        this.concurrencyVersion = aVersion;
    }

    public void failWhenConcurrencyViolation(int aVersion) {
        if (aVersion != this.concurrencyVersion()) {
            throw new IllegalStateException(
                    "Concurrency Violation: Stale data detected. EntityBase was already modified.");
        }
    }

    protected long id() {
        return this.id;
    }

    private void setId(long anId) {
        this.id = anId;
    }

    private boolean isDeleted() {
        return deleted;
    }

    private void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}