package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.AccountPasswordPage;
import pages.LoginPage;
import pages.MainPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US008_Sukriye_AccountPassword_page {

    MainPage mainPage=new MainPage();
    LoginPage loginPage=new LoginPage();
    AccountPasswordPage accountPasswordPage=new AccountPasswordPage();

    @Given("user goes to {string} loginpage")
    public void user_goes_to_loginpage(String string) {
        Driver.getDriver().get(ConfigReader.getProperty("bank_url"));
    }
    @Given("user provides valid username")
    public void user_provides_valid_username() {

    }
    @Given("user provides valid password")
    public void user_provides_valid_password() {

    }
    @Given("user clicks sign in button")
    public void user_clicks_sign_in_button() {

    }
    @Given("user clicks to account menu")
    public void user_clicks_to_account_menu() {

    }
    @Given("user clicks to password button to edit")
    public void user_clicks_to_password_button_to_edit() {

    }
    @Then("verifies that old password not confirmed")
    public void verifies_that_old_password_not_confirmed() {

    }

    @Then("enter new seven chars {string} and verifies that  should be at least one {string} at new password and level chart changes accordingly")
    public void enterNewSevenCharsAndVerifiesThatShouldBeAtLeastOneAtNewPasswordAndLevelChartChangesAccordingly(String arg0, String arg1) {
    }

    @Then("verifies that new password is not accepted which is less than seven char")
    public void verifiesThatNewPasswordIsNotAcceptedWhichIsLessThanSevenChar() {
    }

    @Then("verifies that new valid password must be confirmed")
    public void verifiesThatNewValidPasswordMustBeConfirmed() {
    }
}
