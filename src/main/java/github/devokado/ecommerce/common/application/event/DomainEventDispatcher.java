package github.devokado.ecommerce.common.application.event;

import github.devokado.ecommerce.common.domain.BaseAggregateRoot;

public interface DomainEventDispatcher {
    void dispatch(BaseAggregateRoot aggregateRoot);
}
