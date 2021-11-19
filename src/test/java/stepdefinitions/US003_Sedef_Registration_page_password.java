package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.RegisterPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

public class US003_Sedef_Registration_page_password {

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

//    @Given("user clicks on the register_botton")
//    public void user_clicks_on_the_register_botton() {
//        registerPage.registerButton.click();
//
//    }

    @Given("user enters a password which not include uppercase char")
    public void user_enters_a_password_which_not_include_uppercase_char() {
        registerPage.getPassWord1.sendKeys("noupper1=");

    }

    @Given("user enter the same upperpassword again")
    public void user_enter_the_same_upperpassword_again() {
        registerPage.getPassWord2.sendKeys("noupper1=");

    }

    @Given("user enters a password which not include number")
    public void user_enters_a_password_which_not_include_number() {
        registerPage.getPassWord1.sendKeys("noNumber=");

    }
    @Given("user enter the same numberpassword again")
    public void user_enter_the_same_numberpassword_again() {
        registerPage.getPassWord2.sendKeys("noNumber=");

    }



    @Then("close the application")
    public void close_the_application() {
        Driver.closeDriver();

    }
    @Given("user enters a password which not include special_char")
    public void user_enters_a_password_which_not_include_special_char() {
        registerPage.getPassWord1.sendKeys("NoSpecial1");

    }
    @Given("user enter the same special_char_password again")
    public void user_enter_the_same_special_char_password_again() {

        registerPage.getPassWord2.sendKeys("NoSpecial1");
    }

    @Given("user enters a password which is less than seven char")
    public void user_enters_a_password_which_is_less_than_seven_char() {

        registerPage.getPassWord1.sendKeys("Less7-");
    }
    @Given("user enter the same seven_char_password again")
    public void user_enter_the_same_seven_char_password_again() {
        registerPage.getPassWord2.sendKeys("Less7-");
    }


    @Given("user enters a password which is include all required field")
    public void user_enters_a_password_which_is_include_all_required_field() {
        registerPage.getPassWord1.sendKeys("Strong7=");
    }
    @Given("user enter the same strong_password again")
    public void user_enter_the_same_strong_password_again() {
        registerPage.getPassWord2.sendKeys("Strong7=");

    }
//
//    @Then("user get password_strength message")
//    public void user_get_password_strength_message() throws InterruptedException {
//
//        Thread.sleep(1000);
//        String passwordStrengthBar = registerPage.passwordStrengthBar.getText();
//        String expectedSuccessMessage="Your password should contain at least one uppercase,one digit, one lowercase and one special character";
//        Assert.assertEquals(expectedSuccessMessage,passwordStrengthBar);
//      //  registerPage.passwordStrengthBar.getText("Your password should contain at least one uppercase,one digit, one lowercase and one special character")
//    }

}
