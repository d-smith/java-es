package org.dsmith.es;

import java.util.UUID;

public abstract class Aggregate {
    protected String aggregateID;

    public Aggregate() {
        aggregateID = UUID.randomUUID().toString();
    }
}
