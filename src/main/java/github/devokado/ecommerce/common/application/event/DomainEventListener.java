package github.devokado.ecommerce.common.application.event;

import github.devokado.ecommerce.common.domain.DomainEvent;
import org.springframework.context.event.EventListener;

public interface DomainEventListener<E extends DomainEvent> {
    @EventListener
    void handle(E event);
}
