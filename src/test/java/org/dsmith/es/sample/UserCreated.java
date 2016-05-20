package org.dsmith.es.sample;


import org.dsmith.es.Event;

public class UserCreated extends Event {
    private String firstName;
    private String lastName;
    private String eMail;

    public UserCreated(String id, String first, String last, String email) {
        this.source = id;
        this.firstName = first;
        this.lastName = last;
        this.eMail = email;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
}
