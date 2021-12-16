package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import utilities.ConfigReader;

import java.lang.module.Configuration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class US026_Merve_StepDefinitions {
   Response response;
   String updateName;

//    @When("user updates a country by using api end point {string}")
//    public void user_updates_a_country_by_using_api_end_point(String url) {
//
//        response = given().headers(
//                "Authorization",
//                "Bearer " +ConfigReader.getProperty("api_bearer_token"),
//                "Content-Type",
//                ContentType.JSON,
//                "Accept",
//                ContentType.JSON)
//                .when().get(url);
//
//        List<Integer> countryIdList = response.jsonPath().getList("id");
//        int countryId = countryIdList.get((int)(Math.random()*countryIdList.size()));
//                response.jsonPath().getString("");
//
//                updateName = "Ruwanda";
//                Map<String,Object> bodyMap = new HashMap<>();
//                bodyMap.put("id",countryId);
//                bodyMap.put("name",updateName);
//
//                response=given().headers(
//                                "Authorization",
//                                "Bearer" +ConfigReader.getProperty("api_bearer_token"),
//                                "Content-Type",
//                                ContentType.JSON,
//                                "Accept",
//                                ContentType.JSON)
//                        .when().body(bodyMap)
//                        .put(url)
//                        .then()
//                        .contentType(ContentType.JSON)
//                        .statusCode(200).body("name",equalTo(updateName)).extract().response();
//                response.prettyPrint();
//    }
//    @Then("validates if the country has been updated")
//    public void validates_if_the_country_has_been_updated() {
//        Assert.assertTrue("Country name is not updated.",
//                response.jsonPath().get("name").equals(updateName));
//
//    }
    @Given("user sets the response using api end point {string} and updates country using {string} and {string}")
    public void user_sets_the_response_using_api_end_point_and_updates_country_using_and(String endPoint, String id, String name) {
        response = given().headers(
                        "Authorization",
                        "Bearer " + ConfigReader.getProperty("api_bearer_token"),
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON)
                .when().body("{\"id\": "+id+",\"name\": \""+name+"\"}")
                .put(endPoint)
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();
    }
}
