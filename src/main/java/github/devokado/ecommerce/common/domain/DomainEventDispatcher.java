package github.devokado.ecommerce.common.domain;

public interface DomainEventDispatcher {
    void dispatch(BaseAggregateRoot aggregateRoot);
}
