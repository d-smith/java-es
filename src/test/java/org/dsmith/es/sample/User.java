package org.dsmith.es.sample;


import org.dsmith.es.Aggregate;
import org.dsmith.es.Event;

import java.util.List;
import java.util.UUID;

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

        user.apply(new UserCreated(UUID.randomUUID().toString(), first,last,email));

        return user;
    }

    public static User NewUserFromHistory(List<Event> history) {
        User user = new User();
        for(Event e: history) {
            user.route(e);
        }
        return user;
    }



    @Override
    public void route(Event e) {
        if(e instanceof UserCreated) {
            handle((UserCreated)e);
        } else if (e instanceof UserLastNameChanged) {
            handle((UserLastNameChanged)e);
        }
    }

    private void handle(UserCreated userCreated) {
        this.aggregateID = userCreated.getSource();
        this.firstName = userCreated.getFirstName();
        this.lastName = userCreated.getLastName();
        this.eMail = userCreated.geteMail();
    }

    private void handle(UserLastNameChanged lastNameChanged) {
        this.lastName = lastNameChanged.getLastName();
    }
}
