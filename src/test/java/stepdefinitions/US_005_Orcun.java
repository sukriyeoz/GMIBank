package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.LoginPage;
import pages.MainPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US_005_Orcun {

    MainPage mainPage = new MainPage();
    LoginPage loginPage = new LoginPage();

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
    public void enterAInvalidInTheUsernameBox(String arg0) {
        loginPage.usernameTextbox.sendKeys(ConfigReader.getProperty("invalid_username"));
    }
}
