package com.learn.bdd.books.it;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/java/com/learn/bdd",
        glue={"com.learn.bdd.books.it"},
        monochrome = true,
        plugin = {"pretty", "html:target/reportIT", "json:target/report/reportIT.json", "junit:target/report/report_junit_IT.xml"}
)
public class AppIT {
}