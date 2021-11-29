package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.AccountPasswordPage;
import pages.LoginPage;
import pages.MainPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US008_Sukriye_AccountPassword_page {

    MainPage mainPage=new MainPage();
    LoginPage loginPage=new LoginPage();
    AccountPasswordPage accountPasswordPage=new AccountPasswordPage();

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
        loginPage.userName.sendKeys(ConfigReader.getProperty("user_name"));
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
        accountPasswordPage.currentPassword.sendKeys(ConfigReader.getProperty("user_password"));
        accountPasswordPage.newPassword.sendKeys(ConfigReader.getProperty("user_password"));
        accountPasswordPage.confirmPassword.sendKeys(ConfigReader.getProperty("user_password"));
       // Assert.assertTrue(accountPasswordPage.invalidFeedback.isDisplayed());

        ReusableMethods.waitFor(2);
        String pageText= Driver.getDriver().getPageSource();
        System.out.println(pageText);
        Assert.assertTrue(pageText.contains("New password should be different from the current one."));

    }

    @Then("enter new seven chars {string} and verifies that  should be at least one {string} at new password and level chart changes accordingly")
    public void enter_new_seven_chars_and_verifies_that_should_be_at_least_one_at_new_password_and_level_chart_changes_accordingly(String string, String string2) {
       accountPasswordPage.currentPassword.sendKeys(ConfigReader.getProperty("user_password"));
        accountPasswordPage.newPassword.sendKeys(string);
        ReusableMethods.waitFor(3);
        String color = accountPasswordPage.line1.getCssValue("background-color");
        System.out.println(color);
        Assert.assertTrue(color.contains(ConfigReader.getProperty("orange")));
        System.out.println("When I enter 1 "+string2+" at the last character of 7 character password, line1 color of level chart changes");
    }

//    @Then("verifies there is one bug that new password accepts at least four char")
//    public void verifies_there_is_one_bug_that_new_password_accepts_at_least_four_char() {
//        accountPasswordPage.currentPassword.sendKeys(ConfigReader.getProperty("user_password"));
//        accountPasswordPage.newPassword.sendKeys("1111");
//        accountPasswordPage.confirmPassword.sendKeys("1111");
//        accountPasswordPage.saveButton.click();
//        ReusableMethods.waitFor(3);
//        String pageText= Driver.getDriver().getPageSource();
//        Assert.assertTrue(pageText.contains("Password changed"));
//        System.out.println("'Password can change' with 4 character, There is bug");
//        ReusableMethods.waitFor(3);
//        accountPasswordPage.currentPassword.clear();
//        accountPasswordPage.newPassword.clear();
//       accountPasswordPage.confirmPassword.clear();
//       accountPasswordPage.currentPassword.sendKeys("1111");
//        accountPasswordPage.newPassword.sendKeys(ConfigReader.getProperty("semra_password"));
//       accountPasswordPage.confirmPassword.sendKeys(ConfigReader.getProperty("semra_password"));
//        accountPasswordPage.saveButton.click();
//       ReusableMethods.waitFor(5);
//    }

    @Then("verifies that new valid password must be confirmed")
    public void verifies_that_new_valid_password_must_be_confirmed() {
        accountPasswordPage.currentPassword.sendKeys(ConfigReader.getProperty("user_password"));
        accountPasswordPage.newPassword.sendKeys("Bmi12345.");
        accountPasswordPage.confirmPassword.sendKeys("Bmi12345.");
        accountPasswordPage.saveButton.click();
        ReusableMethods.waitFor(3);
        String pageText= Driver.getDriver().getPageSource();
        Assert.assertTrue(pageText.contains("Password changed"));
        ReusableMethods.waitFor(3);
        System.out.println("'Password change' is confirmed");


        accountPasswordPage.currentPassword.clear();
        accountPasswordPage.newPassword.clear();
        accountPasswordPage.confirmPassword.clear();
        accountPasswordPage.currentPassword.sendKeys("Bmi12345.");
        accountPasswordPage.newPassword.sendKeys(ConfigReader.getProperty("user_password"));
        accountPasswordPage.confirmPassword.sendKeys(ConfigReader.getProperty("user_password"));
        accountPasswordPage.saveButton.click();
        ReusableMethods.waitFor(3);


}}
