package org.dsmith.es.sample;


import org.dsmith.es.Aggregate;
import org.dsmith.es.Event;

public class User extends Aggregate {
    private String firstName;
    private String lastName;
    private String eMail;

    private User(String first, String last, String email) {
        super();
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

    public static User NewUser(String first, String last, String email) {
        User user = new User(first,last,email);

        user.apply(new UserCreated(user));

        return user;
    }

    @Override
    public void route(Event e) {
        
    }
}
