package org.dsmith.es;


import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.dsmith.es.sample.User;
import org.dsmith.es.sample.UserCreated;
import org.dsmith.es.sample.UserLastNameChanged;

import java.util.ArrayList;
import java.util.List;

import static org.dsmith.es.sample.User.NewUserFromHistory;
import static org.junit.Assert.*;

public class AggregateFromEventHistory {
    List<Event> eventHistory = new ArrayList<>();
    User user = null;

    @Given("^an event sourced aggregate's event history$")
    public void an_event_sourced_aggregate_s_event_history() throws Throwable {
        eventHistory.add(new UserCreated("123", "history first", "history last", "history email"));
        eventHistory.add(new UserLastNameChanged("123", "updated last"));
    }

    @When("^I instantiate the aggregate from its history$")
    public void i_instantiate_the_aggregate_from_its_history() throws Throwable {
        user = NewUserFromHistory(eventHistory);
    }

    @Then("^the instance state is correct$")
    public void the_instance_state_is_correct() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertEquals("123", user.aggregateID);
        assertEquals("history first", user.getFirstName());
        assertEquals("updated last", user.getLastName());
        assertEquals("history email", user.geteMail());
    }

    @Then("^there are no uncommitted events$")
    public void there_are_no_uncommitted_events() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^the aggregate version is correct$")
    public void the_aggregate_version_is_correct() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
