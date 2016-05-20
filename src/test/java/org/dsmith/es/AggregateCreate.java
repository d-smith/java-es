package org.dsmith.es;

import cucumber.api.java.en.*;
import cucumber.api.PendingException;
import org.dsmith.es.sample.*;
import org.junit.Assert;

import static org.dsmith.es.sample.User.NewUser;

public class AggregateCreate {
    private User user;
    @Given("^an event sourced aggregate$")
    public void an_event_sourced_aggregate() throws Throwable {
        user = NewUser("first","last","email");
    }

    @When("^I create a new instance$")
    public void i_create_a_new_instance() throws Throwable {

    }

    @Then("^the instance id is set$")
    public void the_instance_id_is_set() throws Throwable {
        Assert.assertNotEquals("", user.aggregateID);
    }

    @Then("^there's an uncommitted event$")
    public void there_s_an_uncommitted_event() throws Throwable {
        Assert.assertEquals(1,user.uncommentEventCount());
    }

    @Then("^the uncommited event's source ID is the aggregate ID$")
    public void the_uncommited_event_s_source_ID_is_the_aggregate_ID() throws Throwable {
        Event theEvent = user.events.get(0);
        Assert.assertTrue(theEvent instanceof UserCreated);
        Assert.assertEquals(user.aggregateID, theEvent.getSource());
    }

}
