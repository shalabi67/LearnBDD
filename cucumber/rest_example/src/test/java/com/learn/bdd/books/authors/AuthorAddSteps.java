package com.learn.bdd.books.authors;

import com.learn.bdd.books.models.Author;
import com.learn.bdd.books.repositories.AuthorsRepository;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import com.learn.bdd.books.facade.AuthorsSystem;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class AuthorAddSteps {
    private  AuthorsRepository authorsRepository;
    private AuthorsSystem  authorsSystem;
    private Author author;
    @Given("authors system is started")
    public void authorsSystemIsStarted() {
        System.out.println("System is started.");
        authorsRepository = Mockito.mock(AuthorsRepository.class);
        authorsSystem = AuthorsSystem.create(authorsRepository);
    }

    @When("^user provides author information (.+), (.+) and (.+)$")
    public void user_provides_author_information_and(String firstname, String lastname, String email) throws Throwable {
        author = new Author(-1, firstname, lastname, email);
    }

    @Then("^system validate author email$")
    public void system_validate_author_email() throws Throwable {
    }

    @And("^system validate author first name$")
    public void system_validate_author_first_name() throws Throwable {

    }

    @And("^system validate author last name$")
    public void system_validate_author_last_name() throws Throwable {
    }

    @And("^system add user$")
    public void system_add_user() throws Throwable {
        ResponseEntity<Author> response = authorsSystem.addAuthor(author, 1);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.CREATED);
        Author newAuthor = response.getBody();
        Assert.assertEquals("Error in first name", author.getFirstName(), newAuthor.getFirstName());
        Assert.assertEquals("Error in last name", author.getLastName(), newAuthor.getLastName());
        Assert.assertEquals("Error in email", author.getEmail(), newAuthor.getEmail());
        Assert.assertEquals("Error in id", 1, newAuthor.getAuthorId());
    }

    @When("^user provides missing author information (.+) and (.+)$")
    public void userProvidedAuthorInformation(String firstname, String lastname) {
        author = new Author(-1, firstname, lastname, null);
    }

    @Then("^System returns Invalid or missing email$")
    public void system_returns_invalid_or_missing_email() throws Throwable {
        ResponseEntity<Author> response = authorsSystem.addAuthor(author, 1);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.EXPECTATION_FAILED);
    }

    @When("^user provides author information (.+) and (.+) with missing first name$")
    public void userProvidedAuthorInformationWithMissingFirstName(String email, String lastname) {
        author = new Author(-1, null, lastname, email);
    }
    @Then("System returns Invalid or missing first name")
    public void system_returns_Invalid_or_missing_first_name() {
        ResponseEntity<Author> response = authorsSystem.addAuthor(author, 1);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.EXPECTATION_FAILED);
    }


    @When("^user provides invalid email (.+), (.+) and (.+)$")
    public void userProvidesInvalidEmail(String firstname, String lastname, String email) {
        author = new Author(-1, firstname, lastname, email);
    }
}
