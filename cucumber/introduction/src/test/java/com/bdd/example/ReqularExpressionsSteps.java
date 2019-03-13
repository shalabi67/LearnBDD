package com.bdd.example;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ReqularExpressionsSteps {
    @When("user do provide {string}")
    public void userDoProvide(String name) {
        System.out.println("When: the name is " + name);
    }

    @Then("System shows {string}")
    public void systemShows(String message) {
        System.out.println("Then: the message is " + message);
    }
}
