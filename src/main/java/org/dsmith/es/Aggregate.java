package org.dsmith.es;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class Aggregate {
    protected String aggregateID;
    protected int version;
    protected List<Event> events;

    public Aggregate() {
        version = 0;
        events = new ArrayList<>();
    }

    public void addEvent(Event e) {
        events.add(e);
    }

    public abstract void route(Event e);

    public void apply(Event e) {
        route(e);
        addEvent(e);
    }

    public int uncommentEventCount() {
        return events.size();
    }

}
