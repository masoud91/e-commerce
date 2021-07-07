package github.devokado.ecommerce.common.domain;

public interface DomainEventListener<E extends DomainEvent> {
    void handle(E event);
}
