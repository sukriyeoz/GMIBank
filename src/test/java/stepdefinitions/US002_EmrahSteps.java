package stepdefinitions;

import pages.MainPage;
import pages.RegisterPage;
import utilities.ConfigReader;
import utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class US002_EmrahSteps {
    MainPage mainPage = new MainPage();
    RegisterPage registerPage = new RegisterPage();

    @Given("user enters the GMIBank web page")
    public void userEntersTheGMIBankWebPage() {
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
    }

    @And("User clicks on man icon.")
    public void userClicksOnManIcon() {
        mainPage.humanIcon.click();
    }

    @And("User clicks on the register button")
    public void userClicksOnTheRegisterButton() {
        mainPage.register.click();
    }

    @When("user clicks on register button without filling mandatory areas")
    public void userClicksOnRegisterButtonWithoutFillingMandatoryAreas() {
        registerPage.registerButton.click();
    }

    @Then("user verify error messages for all fields on the registration page")
    public void userVerifyErrorMessagesForAllFieldsOnTheRegistrationPage() {
        for (WebElement w: registerPage.errorMessages) {
            System.out.println(w.getText());
            Assert.assertTrue("Error message is not displayed",w.isDisplayed());
        }
    }

    @When("user types  {string} number to SSN box")
    public void userTypesNumberToSSNBox(String ssnNumber) {
        registerPage.ssnTextbox.sendKeys(ssnNumber, Keys.TAB);
    }

    @Then("user verify that invalid format of SSN number leads to error message")
    public void userVerifyThatInvalidFormatOfSSNNumberLeadsToErrorMessage() {
        Assert.assertTrue(registerPage.ssnErrorMessage.getText().contains("Ssn is invalid."));
    }

    @When("user enter {string} number to phonenumber box")
    public void userEnterNumberToPhonenumberBox(String phoneNumber) {
        registerPage.phonenumberTextbox.sendKeys(phoneNumber, Keys.TAB);
    }

    @Then("user verifies that invalid format of phone number to error message")
    public void userVerifiesThatInvalidFormatOfPhoneNumberToErrorMessage() {
        Assert.assertTrue(registerPage.phonenumberErrorMessage.getText().contains("Your mobile phone number is invalid."));
    }

    @When("user enter {string} data to email box")
    public void userEnterDataToEmailBox(String email) {
        registerPage.emailTextbox.sendKeys(email, Keys.TAB);
    }

    @Then("user verifies that invalid format of email leads to error message")
    public void userVerifiesThatInvalidFormatOfEmailLeadsToErrorMessage() {
        Assert.assertTrue(registerPage.emailErrorMessage.getText().contains("Your email is invalid."));
    }
}
