package com.learn.bdd.books.authors;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/java/com/learn/bdd/books/features/authorsAdd.feature",
        glue={"com.learn.bdd.books.authors"},
        monochrome = true,
        plugin = {"pretty", "html:target/report", "json:target/report/report.json", "junit:target/report/report_junit.xml"}
)
/**
 * This represents a unit test
 */
public class AuthorAddTest {
}
