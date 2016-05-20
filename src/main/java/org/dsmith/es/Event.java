package org.dsmith.es;


public abstract class Event {
    protected String source;
    protected int version;

    public String getSource() {
        return source;
    }

    public int getVersion() {
        return version;
    }
}
