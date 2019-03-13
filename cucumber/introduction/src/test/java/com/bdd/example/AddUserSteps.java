package com.bdd.example;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

import java.util.List;

public class AddUserSteps {
    @Given("user add page is called")
    public void userAddPageIsCalled() {
    }

    @When("user provide user details")
    public void userProvideUserDetails(DataTable dataTable) {
        for(int rowNumber=0; rowNumber<dataTable.height(); rowNumber++) {
            List<String> row = dataTable.row(rowNumber);
            User user = new User(row.get(0), row.get(1), row.get(2), row.get(3), row.get(4));
            System.out.println(user);
        }


    }

    @Then("system log user in")
    public void systemLogUserIn() {
    }
}
