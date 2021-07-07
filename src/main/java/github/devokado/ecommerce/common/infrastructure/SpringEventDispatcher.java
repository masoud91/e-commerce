package github.devokado.ecommerce.common.infrastructure;

import github.devokado.ecommerce.common.domain.BaseAggregateRoot;
import github.devokado.ecommerce.common.domain.DomainEventDispatcher;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class SpringEventDispatcher implements DomainEventDispatcher {

    private final ApplicationEventPublisher applicationEventPublisher;

    public SpringEventDispatcher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void dispatch(final BaseAggregateRoot aggregateRoot) {
        System.out.println("Publishing DomainEvent event. ");
        aggregateRoot.events().forEach(applicationEventPublisher::publishEvent);
        aggregateRoot.clearEvents();
    }

}
