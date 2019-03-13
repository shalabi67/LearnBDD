package com.bdd.example;

import cucumber.api.java.en.When;

public class SumSteps {
    @When("{int} + {int} the result is {int}")
    public void the_result_is(Integer value1, Integer value2, Integer expectedResult) {
        // Write code here that turns the phrase above into concrete actions
        //throw new cucumber.api.PendingException();
        System.out.println("When: the sum of " + value1 + " and " + value2 + " is expected to be " + expectedResult );
    }
}
