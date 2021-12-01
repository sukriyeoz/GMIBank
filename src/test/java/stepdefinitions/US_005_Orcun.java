package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.AccountResetRequestPage;
import pages.MainPage;
import pages.SigninPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class US_005_Orcun {

    MainPage mainPage = new MainPage();
    SigninPage singInPage = new SigninPage();
    AccountResetRequestPage accountResetRequestPage = new AccountResetRequestPage();

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
        ReusableMethods.waitFor(3);
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


    @And("enter a invalid username and invalid password")
    public void enterAInvalidUsernameAndInvalidPassword(DataTable invalidUser) {
        List<String> testData = invalidUser.row(1);
        singInPage.userName.sendKeys(testData.get(0));
        singInPage.password.sendKeys(testData.get(1));
    }

    @And("click to Did you forget your password button")
    public void clickToDidYouForgetYourPasswordButton() {
        singInPage.forgetPassword.click();
    }

    @And("enter email address")
    public void enterEmailAddress(DataTable email) {
        List<String> enemail = email.row(1);
        accountResetRequestPage.enterEmail.sendKeys(enemail.get(0));
    }

    @And("Click to reset password")
    public void clickToResetPassword() {
        accountResetRequestPage.resetPassword.click();
    }

    @Then("Verify that a new password has been sent to your e-mail to reset the password.")
    public void verifyThatANewPasswordHasBeenSentToYourEMailToResetThePassword() {
        String expectData = "Check your emails for details on how to reset your password.";
        ReusableMethods.waitFor(5);
        String acpectedData = accountResetRequestPage.resetMessage.getText();
        Assert.assertEquals(acpectedData, expectData);
    }


    @Then("The user is unable to log in, and it is verified that she cannot log in.")
    public void theUserIsUnableToLogInAndItIsVerifiedThatSheCannotLogIn() {
        String ectualresult = "Failed to sign in! Please check your credentials and try again.";
        String actualresult = singInPage.failMessage.getText();
        Assert.assertEquals(actualresult, ectualresult);
    }

    @And("click to register a new account button")
    public void clickToRegisterANewAccountButton() {
        singInPage.registerNewAccount.click();
    }
}
