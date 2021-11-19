package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.RegisterPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

public class US003_Registration_page_password {

    RegisterPage registerPage = new RegisterPage();


    @Given("user is on the application page")
    public void user_is_on_the_application_page() {
        Driver.getDriver().get(ConfigReader.getProperty("app_url_registration"));

    }
    @Given("user enters all required fields")
    public void user_enters_all_required_fields(DataTable registerData) {

        List<String> testData = registerData.row(1);
        System.out.println(testData);
        registerPage.getSSN.sendKeys(testData.get(0));
        registerPage.fName.sendKeys(testData.get(1));
        registerPage.lName.sendKeys(testData.get(2));
        registerPage.address1.sendKeys(testData.get(3));
        registerPage.phoneNumber.sendKeys(testData.get(4));
        registerPage.userName.sendKeys(testData.get(5));
        registerPage.emailAddress.sendKeys(testData.get(6));

    }
    @Given("user enters a password which not include lowercase char")
    public void user_enters_a_password_which_not_include_lowercase_char() {
        registerPage.getPassWord1.sendKeys("NOLOW1=");
    }
    @Given("user enter the same password again")
    public void user_enter_the_same_password_again() {
        registerPage.getPassWord2.sendKeys("NOLOW1=");
    }
    @Given("user clicks on the register_botton")
    public void user_clicks_on_the_register_botton() {
        registerPage.registerButton.click();
    }
    @Then("user verifies the success_message")
    public void user_verifies_the_success_message() {

    }
}
