//package stepdefinitions;
//
//import com.github.javafaker.Faker;
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import pages.LoginPage;
//import pages.MainPage;
//import utilities.ConfigReader;
//import utilities.Driver;
//
//public class US007_Tugce_Not_Updating_with_invalid_credentials {
//
//    MainPage mainPage=new MainPage();
//    LoginPage loginPage=new LoginPage();
//    Faker faker = new Faker();
//
//    @Given("user goes to {string} loginpage")
//    public void user_goes_to_loginpage(String string) {
//        Driver.getDriver().get(ConfigReader.getProperty("bank_url"));
//    }
//
//    @And("click human button right topside")
//    public void clickHumanButtonRightTopside() {
//        mainPage.humanIcon.click();
//    }
//
//    @And("click Signin button")
//    public void clickSignInButton() {
//        mainPage.singIn.click();
//    }
//    @Given("user provides valid username")
//    public void user_provides_valid_username() {
//        loginPage.fName.sendKeys(faker.name().firstName());
//    }
//
//    @Given("user provides valid password")
//    public void user_provides_valid_password() {
//        loginPage.getPassWord1.sendKeys("^320*E7jJ$7@2");
//    }
//
//    @Given("user clicks sign in button")
//    public void user_clicks_sign_in_buttonn() {
//        loginPage.signIn.click();
//    }
//
//    @Given("click human button right topside")
//    public void clickHumanButtonRightTopsidee() {
//        mainPage.humanIcon.click();
//    }
//
//    @Given("user clicks user info button")
//    public void clickUserInfo() {
//        mainPage.userInfo.click();
//    }
//
//    @Given("user clicks to email button to edit")
//    public void user_clicks_to_email_button_to_edit() {
//
//    }
//
//    @Given("user clicks to language button to check it")
//    public void user_clicks_to_language_button_to_check_it() {
//
//    }
//
//    @Then("verifies that Email id cannot contain just digits or chars without '@' sign or '.' extension")
//    public void verifiesThatEmailIdCannotBeUpdatedWithInvalidChars() {
//    }
//
//    @Then("Check the language options if there is English and Turkish or not")
//    public void  check_the_language_options_if_there_is_English_and_Turkish_or_not() {
//    }
//
//}