package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.LoginPage;
import pages.MainPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;


public class US007_Tugce_VerifyWithInvalidDatas {

    LoginPage loginPage = new LoginPage();

    MainPage mainPage = new MainPage();

    @Given("user goes to bank main page")
    public void userGoesToBankMainPage() {
        Driver.getDriver().get(ConfigReader.getProperty("bank_url"));
    }

    @Given("user clicks human button")
    public void userClicksHumanButton() {
        mainPage.humanIcon.click();
    }

    @Given("user clickss sign_in button")
    public void userClickssSign_inButton() {
        mainPage.signInall.click();
    }

    @And("user providess valid username")
    public void userProvidessValidUsername() {
        loginPage.userName.sendKeys("xuser");
    }

    @And("user providess valid password")
    public void userProvidessValidPassword() {
        loginPage.password.sendKeys("Gmi12345.");
    }

    @And("user clickss sign in button")
    public void userClickssSignInButton() {
        loginPage.signInButton.click();
    }

    @And("clicks on dropdown button right topside")
    public void clicksOnDropdownButtonRightTopside() {
        loginPage.dropDown.click();
    }

    @Given("user clicks to userInfoo")
    public void userClicksToUserInfoo() {
        loginPage.userInfo.click();
        ReusableMethods.waitFor(2);
    }

    @And("Clear the email boxx")
    public void clearTheEmailBoxx() {
        ReusableMethods.waitFor(2);
        loginPage.emailTextBox.clear();
    }
    @Given("enter as a new email")
    public void enterAsANewEmail() {
        loginPage.emailTextBox.sendKeys("xuser@gmailcom");
        ReusableMethods.waitFor(2);
    }
    @Given("enter as a new second email")
    public void enterAsANewSecondEmail() {
        loginPage.emailTextBox.sendKeys("xusergmail.com");
    }

    @Then("user should see the error message")
    public void userShouldSeeTheErrorMessage() {
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
        ReusableMethods.waitFor(2);
    }

    @Then("user closes the browser")
    public void userClosesTheBrowser() {
        Driver.closeDriver();
    }

    @Then("verifies that language button does not have any other option except English or Turkish")
    public void verifiesThatLanguageButtonDoesNotHaveAnyOtherOptionExceptEnglishOrTurkish() {
        Select select = new Select(loginPage.languageDropDown);
        List<WebElement> allOptions =select.getOptions();
        for (WebElement element: allOptions){
            System.out.println("All languages displayed: "+ element.getText());
        }
    }

    @Then("user clicks to language button")
    public void userClicksToLanguageButton() {
        loginPage.languageDropDown.click();
        ReusableMethods.waitFor(2);
    }
}