package stepdefinitions;

import io.cucumber.java.en.*;
import utilities.DatabaseUtility;

import java.util.List;



public class DBTesting9 {
    List<Object> customerSSNIDs;

    @Given("user creates a connection with db using {string} , {string} and {string}")
    public void userCreatesAConnectionWithDbUsingAnd(String url, String username, String password) {
        DatabaseUtility.createConnection(url,username,password);
    }

    @Given("user sends their query to db and gets related data {string} and {string}")
    public void userSendsTheirQueryToDbAndGetsRelatedDataAnd(String query, String column) {
        customerSSNIDs = DatabaseUtility.getColumnData(query,column);
        System.out.println(customerSSNIDs);
    }

    @And("user sets DB data into correspondent files")
    public void userSetsDBDataIntoCorrespondentFiles() {
    }

    @Then("user validates db data using records")
    public void userValidatesDbDataUsingRecords() {
    }
}
