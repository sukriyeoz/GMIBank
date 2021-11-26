package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.MainPage;
import pages.SigninPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Map;

public class US_005_Orcun {

    MainPage mainPage = new MainPage();
    SigninPage singInPage = new SigninPage();

    @Given("user enter the GMIBank website")
    public void userEnterTheGMIBankWebsite() {
        Driver.getDriver().get(ConfigReader.getProperty("bank_url"));
    }

    @And("click human dropdown button right topside")
    public void clickHumanDropdownButtonRightTopside() {
        mainPage.humanIcon.click();
    }

    @And("click sign in button")
    public void clickSignInButton() {
        mainPage.singIn.click();
    }

    @And("enter a invalid {string} in the username box")
    public void enterAInvalidInTheUsernameBox(String inValidUsername) {
         singInPage.userName.sendKeys(inValidUsername);
    }

    @And("enter a valid {string} in the password box")
    public void enterAValidInThePasswordBox(String validpassword) {
        singInPage.password.sendKeys(validpassword);

    }

    @And("click to sing in button")
    public void clickToSingInButton() {
        ReusableMethods.waitFor(3);
        singInPage.signIn.click();
    }

    @Then("User is not be able to login with invalid username validating the error message")
    public void userIsNotBeAbleToLoginWithInvalidUsernameValidatingTheErrorMessage() {
        String actualError = singInPage.failMessage.getText();
        String expectedError = "Failed to sign in! Please check your credentials and try again.";
        ReusableMethods.waitFor(5);
        Assert.assertEquals(actualError,expectedError);

    }


    @And("enter a valid {string} in the username box")
    public void enterAValidInTheUsernameBox(String validUsername) {
        singInPage.userName.sendKeys(validUsername);
    }

    @And("enter a invalid {string} in the password box")
    public void enterAInvalidInThePasswordBox(String invalidPassword) {
        singInPage.password.sendKeys(invalidPassword);
    }
}
