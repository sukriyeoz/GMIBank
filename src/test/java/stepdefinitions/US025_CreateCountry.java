package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class US025_CreateCountry {
    @And("read all country from endpoint {string}")
    public void readAllCountryFromEndpoint(String arg0) {
    }

    @Given("User use {string} endpoint to create new country")
    public void userUseEndpointToCreateNewCountry(String arg0) {
    }

    @Then("verify the new country")
    public void verifyTheNewCountry() {
    }
}
