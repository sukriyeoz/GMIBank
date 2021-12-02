package stepdefinitions;

import pages.CommonPageElements;
import pages.LoginPage;
import pages.MainPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class US004_OlcaySteps {
    MainPage mainPage = new MainPage();
    LoginPage loginPage = new LoginPage();
    CommonPageElements commonPageElements = new CommonPageElements();

    @Given("user go to GMI webpage")
    public void userGoToGMIWebpage() {
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
    }

    @And("user click on the account menu")
    public void userClickOnTheAccountMenu() {
        mainPage.humanIcon.click();
    }

    @And("user click on sign in")
    public void userClickOnSignIn() {
        mainPage.singIn.click();
    }

    @And("user enter a valid {string} to usernameTextbox")
    public void userEnterAValidToUsernameTextbox(String username) {
        loginPage.usernameTextbox.sendKeys(username);
    }

    @And("user enter a valid {string} to passwordTextbox")
    public void userEnterAValidToPasswordTextbox(String password) {
        loginPage.passwordTextbox.sendKeys(password);
    }

    @And("user click on {string} button")
    public void userClickOnButton(String signIn) {
        loginPage.signInButton.click();
    }

    @Then("user verify success message for login with valid credentials")
    public void userVerifySuccessMessageForLoginWithValidCredentials() {
        ReusableMethods.waitFor(3);
        Assert.assertTrue(commonPageElements.headerTabs.size() > 8);
    }

    @And("user closes web page")
    public void userClosesWebPage() {
        Driver.closeDriver();
    }

    @And("user click on Cancel button")
    public void userClickOnCancelButton() {
        loginPage.cancelbutton.click();
    }

    @Then("user verifies to cancel login")
    public void userVerifiesToCancelLogin() {
        ReusableMethods.waitFor(3);
        Assert.assertTrue(commonPageElements.headerTabs.size() == 8);
    }
}
