package com.bdd.example;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class SumTestHoks {
    @Before("@sum")
    public void beforeAnyScenario() {
        System.out.println("//////////////////BEFOR SUM Scenario////////////////////////////////");
        System.out.println("I will run before Sum test");
        System.out.println("/////////////////////////////////////////////////////////////////////");
    }

    @After("@sum")
    public void afterAnyScenario() {
        System.out.println("///////////////////AFTER SUM TEST///////////////////////////////////////");
        System.out.println("I will run after any test");
        System.out.println("/////////////////////////////////////////////////////////");
    }
}
