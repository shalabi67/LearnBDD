package com.bdd;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/com/bdd",
        glue={"com.bdd"},
        monochrome = true,
        plugin = {"pretty", "html:target/report", "json:target/report/report.json", "junit:target/report/report_junit.xml"}
)
public class AppIT {
}
