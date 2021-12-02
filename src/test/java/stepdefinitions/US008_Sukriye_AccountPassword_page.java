package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.CommonPageElements;
import pages.LoginPage;
import pages.MainPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US008_Sukriye_AccountPassword_page {

    MainPage mainPage=new MainPage();
    LoginPage loginPage=new LoginPage();
    CommonPageElements commonPageElements=new CommonPageElements();


    @Given("user goes to {string} loginpage")
    public void user_goes_to_loginpage(String string) {
        Driver.getDriver().get(string);
    }

//    @And("user clicks humanIcon")
//    public void userClicksHumanIcon() {
//        mainPage.humanIcon.click();
//    }
//    @And("user clicks sign in button in mainPage")
//    public void userClicksSignInButtonInMainPage() {
//        mainPage.singIn.click();
//    }

    @Given("user provides valid username")
    public void user_provides_valid_username() {
        loginPage.usernameTextbox.sendKeys(ConfigReader.getProperty("user_name"));

    }

    @Given("user provides valid password")
    public void user_provides_valid_password() {
        loginPage.password.sendKeys(ConfigReader.getProperty("user_password"));
    }

    @Given("user clicks sign in button")
    public void user_clicks_sign_in_button() {
       loginPage.signIn.click();
        ReusableMethods.waitFor(3);
    }

    @Given("user clicks to account menu")
    public void user_clicks_to_account_menu() {
        mainPage.humanIcon.click();
    }
    @Given("user clicks to password button to edit")
    public void user_clicks_to_password_button_to_edit() {
        mainPage.password.click();
    }
    @Then("verifies that old password not confirmed")
    public void verifies_that_old_password_not_confirmed() {
       commonPageElements.currentPassword.sendKeys(ConfigReader.getProperty("user_password"));
       commonPageElements.newPassword.click();
       commonPageElements.newPassword.sendKeys(ConfigReader.getProperty("user_password"));
       commonPageElements.confirmPassword.click();
       commonPageElements.confirmPassword.sendKeys(ConfigReader.getProperty("user_password"));
       Assert.assertTrue(commonPageElements.invalidFeedback.isDisplayed());
       ReusableMethods.waitFor(3);
//        String pageText= Driver.getDriver().getPageSource();
//        System.out.println(pageText);
//        Assert.assertTrue(pageText.contains("New password should be different from the current one."));

    }

    @Then("enter new seven chars {string} and verifies that  should be at least one {string} at new password and level chart changes accordingly")
    public void enter_new_seven_chars_and_verifies_that_should_be_at_least_one_at_new_password_and_level_chart_changes_accordingly(String string, String string2) {
       commonPageElements.currentPassword.sendKeys(ConfigReader.getProperty("user_password"));
        commonPageElements.newPassword.sendKeys(string);
        ReusableMethods.waitFor(3);
        String color = commonPageElements.line1.getCssValue("background-color");
        System.out.println(color);
        Assert.assertTrue(color.contains(ConfigReader.getProperty("orange")));
        System.out.println("When I enter 1 "+string2+" at the last character of 7 character password, line1 color of level chart changes");
    }


    @Then("verifies that new valid password must be confirmed")
    public void verifies_that_new_valid_password_must_be_confirmed() {
        commonPageElements.currentPassword.sendKeys(ConfigReader.getProperty("user_password"));
        commonPageElements.newPassword.sendKeys("Bmi12345.");
        commonPageElements.confirmPassword.sendKeys("Bmi12345.");
        commonPageElements.saveButton.click();
        ReusableMethods.waitFor(3);
        String pageText= Driver.getDriver().getPageSource();
        Assert.assertTrue(pageText.contains("Password changed"));
        ReusableMethods.waitFor(3);
        System.out.println("'Password change' is confirmed");


        commonPageElements.currentPassword.clear();
        commonPageElements.newPassword.clear();
        commonPageElements.confirmPassword.clear();
        commonPageElements.currentPassword.sendKeys("Bmi12345.");
        commonPageElements.newPassword.sendKeys(ConfigReader.getProperty("user_password"));
        commonPageElements.confirmPassword.sendKeys(ConfigReader.getProperty("user_password"));
        commonPageElements.saveButton.click();
        ReusableMethods.waitFor(3);


}}
