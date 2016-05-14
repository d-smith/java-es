package org.dsmith.es;

import cucumber.api.java.en.*;
import cucumber.api.PendingException;
import org.junit.Assert;

public class BasicStepdefs {
    private TestAggregate aggregate;
    @Given("^an event sourced aggregate$")
    public void an_event_sourced_aggregate() throws Throwable {
        aggregate = new TestAggregate();
    }

    @When("^I create a new instance$")
    public void i_create_a_new_instance() throws Throwable {

    }

    @Then("^the instance id is set$")
    public void the_instance_id_is_set() throws Throwable {
        Assert.assertNotEquals("",aggregate.aggregateID);
    }

    @Then("^there's an uncommitted event$")
    public void there_s_an_uncommitted_event() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^the uncommited event's source ID is the aggregate ID$")
    public void the_uncommited_event_s_source_ID_is_the_aggregate_ID() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
