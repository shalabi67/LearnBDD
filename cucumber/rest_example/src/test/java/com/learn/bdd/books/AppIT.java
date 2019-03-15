package com.learn.bdd.books;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/java/com/learn/bdd",
        glue={"com.learn.bdd"},
        monochrome = true,
        plugin = {"pretty", "html:target/report", "json:target/report/report.json", "junit:target/report/report_junit.xml"}
)
public class AppIT {
}
