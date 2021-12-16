package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;

import io.restassured.response.Response;
import jsonModels.StateJson;
import org.junit.Assert;
import utilities.ConfigReader;

import java.util.List;

import static io.restassured.RestAssured.given;

public class US027_Merve_StepDefinitions {

    Response response;
    int randomStateId;

    @When("user deletes a state by using api end point {string}")
    public void user_deletes_a_state_by_using_api_end_point(String url) {

        response = given().headers(
                        "Authorization",
                        "Bearer" + ConfigReader.getProperty("api_bearer_token1"),
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON)
                .when().get(url);

        List<Integer> statesIdList = response.jsonPath().getList("id");

        randomStateId = statesIdList.get((int)(Math.random()*statesIdList.size()));

        given().headers(
                        "Authorization",
                        "Bearer" + ConfigReader.getProperty("api_bearer_token1"),
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON)
                .when().delete(url+"/"+randomStateId)
                .then()
                .log() //extract()
                .body() //response()
                .statusCode(204);
    }

    @Then("validates if the state has been deleted")
    public void validates_if_the_state_has_been_deleted() {

        response = given().headers(
                        "Authorization",
                        "Bearer" + ConfigReader.getProperty("api_bearer_token1"),
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON)
                .when().get("https://www.gmibank.com/api/tp-states/"+randomStateId);

        Assert.assertTrue(response.jsonPath().getString("detail").equals("404NOT_FOUND"));

    }

    @Given("user provides api end point to delete states using {string} and its extension {string}")
    public void user_provides_api_end_point_to_delete_states_using_and_its_extension(String endPoint, String id) {
        response = given().headers(
                        "Authorization",
                        "Bearer " + ConfigReader.getProperty("api_bearer_token"),
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON)
                .when().body(StateJson.CREATE_STATE4)
                .delete(endPoint+id)
                .then()
                .extract()
                .response();
    }
}
