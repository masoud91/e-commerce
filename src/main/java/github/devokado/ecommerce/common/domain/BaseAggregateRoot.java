package github.devokado.ecommerce.common.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class BaseAggregateRoot {
    private final List<Object> events = new ArrayList<>();

    protected <T> T registerEvent(T event) {
        events.add(event);
        return event;
    }

    public void clearEvents(){
        events.clear();
    }

    public Collection<Object> events() {
        return Collections.unmodifiableList(events);
    }
}
