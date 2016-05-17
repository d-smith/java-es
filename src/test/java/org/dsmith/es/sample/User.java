package org.dsmith.es.sample;


import org.dsmith.es.Aggregate;
import org.dsmith.es.Event;

public class User extends Aggregate {
    private String firstName;
    private String lastName;
    private String eMail;

    private User() {
        super();
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
        User user = new User();

        user.apply(new UserCreated(user.aggregateID, first,last,email));

        return user;
    }

    @Override
    public void route(Event e) {
        if(e instanceof UserCreated) {
            handle((UserCreated)e);
        }
    }

    private void handle(UserCreated userCreated) {
        this.firstName = userCreated.getFirstName();
        this.lastName = userCreated.getLastName();
        this.eMail = userCreated.geteMail();
    }
}
