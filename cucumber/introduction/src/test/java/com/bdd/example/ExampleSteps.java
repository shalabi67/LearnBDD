package com.bdd.example;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ExampleSteps {
    @Given("The example system is started")
    public void theExampleSystemIsStarted() {
        System.out.println("#################################################################");
        System.out.println("GIVEN: The example system is started");
        System.out.println("#################################################################");
    }

    @When("user do an action")
    public void userDoAnAction() {
        System.out.println("WHEN: System do something");
    }

    @Then("System do something")
    public void systemDoSomething() {
        System.out.println("THEN: System do something");
    }
}
