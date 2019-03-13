package com.bdd.example;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * This example shows how to run tests based on tags.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/com/bdd",
        glue={"com.bdd"},
        tags = {"@user"}
)
public class UserIT {
}
