package com.bdd;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class TestHooks {
    @Before
    public void beforeAnyScenario() {
        System.out.println("");
        System.out.println("");
        System.out.println("+++++++++++++++++++++++BEFOR+++++++++++++++++++++++++++++++++");
        System.out.println("I will run before any test");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }

    @After
    public void afterAnyScenario() {
        System.out.println("-----------------------AFTER---------------------------------");
        System.out.println("I will run after any test");
        System.out.println("--------------------------------------------------------");
    }
}
