Feature: Event Sourced Aggregate

  Scenario: Aggregate created
    Given an event sourced aggregate
    When I create a new instance
    Then the instance id is set