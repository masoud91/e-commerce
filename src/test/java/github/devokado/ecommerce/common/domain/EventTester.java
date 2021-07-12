package github.devokado.ecommerce.common.domain;

import java.util.Collection;

import static java.util.stream.Collectors.toList;

public class EventTester {

    public static int expectedEvents(Collection<Object> registeredEvents,
                                   Class<? extends DomainEvent> aDomainEventType) {

        var registeredEventsTypes =
                registeredEvents.stream()
                        .map(Object::getClass)
                        .map(x -> (Class<? extends DomainEvent>) x)
                        .collect(toList());

        int count = 0;

        for (Class<? extends DomainEvent> type : registeredEventsTypes) {
            if (type == aDomainEventType) {
                ++count;
            }
        }

        return count;
    }

}
