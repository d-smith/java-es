package org.dsmith.es.sample;


import org.dsmith.es.Event;

public class UserLastNameChanged extends Event {
    private String lastName;

    public UserLastNameChanged(String lastName) {
        super();
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }
}
