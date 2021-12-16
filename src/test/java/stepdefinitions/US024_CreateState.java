package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import io.restassured.response.Response;


public class US024_CreateState {
    Response response;

    @Given("user use endpoint {string} and create new states")
    public void useEndpointAndCreateNewStates(String url) {

    }

    @Then("read all states from end point {string}")
    public void readAllStatesFromEndPoint(String string) {
    }

    @And("verify new states")
    public void verifyNewStates() {
    }
}
