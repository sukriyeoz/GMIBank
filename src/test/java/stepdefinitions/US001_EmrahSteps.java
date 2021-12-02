package stepdefinitions;

import pages.MainPage;
import pages.RegisterPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class US001_EmrahSteps {
    MainPage mainPage = new MainPage();
    RegisterPage registerPage = new RegisterPage();
    Faker faker = new Faker();

    @Given("User enter to webPage")
    public void userEnterToWebPage() {
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
    }

    @And("User clicks on human icon")
    public void userClicksOnHumanIcon() {
        mainPage.humanIcon.click();
    }

    @And("User clicks on register Button")
    public void userClicksOnRegisterButton() {
        mainPage.register.click();
    }

    @And("User Enter the {string} number")
    public void userEnterTheNumber(String ssn) {
        registerPage.ssnTextbox.sendKeys(ConfigReader.getProperty("_SSN"));
        registerPage.registerButton.click();
    }

    @Then("ssn number should be valid")
    public void ssnNumberShouldBeValid() {
        String actuelSSN=registerPage.ssnTextbox.getAttribute("value");
        String expectedSSN=ConfigReader.getProperty("_SSN");
        Assert.assertEquals(expectedSSN,actuelSSN);
        System.out.println("actuelSSN : "+ actuelSSN);
        System.out.println("expectedSSN : "+expectedSSN);
    }

    @And("User Enter the {string}")
    public void userEnterThe(String firstname) {
        registerPage.firstnameTextbox.sendKeys(ConfigReader.getProperty("_firstname"));
        registerPage.registerButton.click();
    }

    @Then("Firstname should be valid")
    public void firstnameShouldBeValid() {
        String actuelFirstname=registerPage.firstnameTextbox.getAttribute("value");
        String expectedFirstname=ConfigReader.getProperty("_firstname");
        Assert.assertEquals(expectedFirstname,actuelFirstname);
    }

    @And("User Enter {string}")
    public void userEnter(String lastname) {
        registerPage.lastnameTextbox.sendKeys(ConfigReader.getProperty("_lastname"));
        registerPage.registerButton.click();
    }

    @Then("Lastname should be valid")
    public void lastnameShouldBeValid() {
        String actuelLastname=registerPage.lastnameTextbox.getAttribute("value");
        String expectedLastname=ConfigReader.getProperty("_lastname");
        Assert.assertEquals(expectedLastname,actuelLastname);
    }

    @And("User Enter the address")
    public void userEnterTheAddress() {
        registerPage.addressTextbox.sendKeys(ConfigReader.getProperty("_address"));
        registerPage.registerButton.click();
    }

    @Then("address should be valid")
    public void addressShouldBeValid() {
        String actuelAddress=registerPage.addressTextbox.getAttribute("value");
        String expectedAddress=ConfigReader.getProperty("_address");
        Assert.assertEquals(expectedAddress,actuelAddress);
    }

    @And("User Enter the phonenumber")
    public void userEnterThePhonenumber() {
        registerPage.phonenumberTextbox.sendKeys(ConfigReader.getProperty("_phonenumber"));
        registerPage.registerButton.click();
    }

    @Then("PhoneNumber should be valid")
    public void phonenumberShouldBeValid() {
        String actuelPhonenumber=registerPage.phonenumberTextbox.getAttribute("value");
        String expectedPhonenumber=ConfigReader.getProperty("_phonenumber");
        Assert.assertEquals(expectedPhonenumber,actuelPhonenumber);
    }

    @And("User Enter the username")
    public void userEnterTheUsername() {
        registerPage.usernameTextbox.sendKeys(ConfigReader.getProperty("_username"));
        registerPage.registerButton.click();
    }

    @Then("username should be valid")
    public void usernameShouldBeValid() {
        String actuelUsername=registerPage.usernameTextbox.getAttribute("value");
        String expectedUsername=ConfigReader.getProperty("_username");
        Assert.assertEquals(expectedUsername,actuelUsername);
    }

    @And("User Enter the email")
    public void userEnterTheEmail() {
        registerPage.emailTextbox.sendKeys(ConfigReader.getProperty("_email"));
        registerPage.registerButton.click();
    }

    @Then("email should be valid")
    public void emailShouldBeValid() {
        String actuelEmail=registerPage.emailTextbox.getAttribute("value");
        String expectedEmail=ConfigReader.getProperty("_email");
        Assert.assertEquals(expectedEmail,actuelEmail);
    }

    @And("User Enter the password")
    public void userEnterThePassword() {
        registerPage.firstPasswordTextbox.sendKeys(ConfigReader.getProperty("_password"));
        registerPage.secondPasswordTextbox.sendKeys(ConfigReader.getProperty("_password"));
        registerPage.registerButton.click();
    }

    @Then("Password should be valid")
    public void passwordShouldBeValid() {
        String actuelPassword=registerPage.firstPasswordTextbox.getAttribute("value");
        String expectedPassword=ConfigReader.getProperty("_password");
        Assert.assertEquals(expectedPassword,actuelPassword);

    }

    @And("user enters fields with valid data")
    public void userEntersFieldsWithValidData() {
        ReusableMethods.waitFor(2);
        registerPage.ssnTextbox.sendKeys(faker.number().digits(9));
        registerPage.firstnameTextbox.sendKeys(faker.name().firstName());
        registerPage.lastnameTextbox.sendKeys(faker.name().lastName());
        registerPage.addressTextbox.sendKeys(faker.address().fullAddress());
        registerPage.phonenumberTextbox.sendKeys(faker.phoneNumber().cellPhone());
        registerPage.usernameTextbox.sendKeys(faker.name().username());
        registerPage.emailTextbox.sendKeys(faker.internet().emailAddress());
        String password_=faker.internet().password(10,15,true,true, true);
        registerPage.firstPasswordTextbox.sendKeys(password_);
        registerPage.secondPasswordTextbox.sendKeys(password_);
        ReusableMethods.waitFor(2);
    }

    @Then("user clicks on register button and sees the success message as_ {string}.")
    public void userClicksOnRegisterButtonAndSeesTheSuccessMessageAs_(String successMessage) {
        ReusableMethods.waitAndClick(registerPage.registerButton,10);
        ReusableMethods.waitFor(2);
        Assert.assertTrue("Registration saved!",registerPage.successMessageToastContainer.isDisplayed());
        System.out.println(registerPage.successMessageToastContainer.getText());
    }

    @Then("close the page")
    public void closeThePage() {
        Driver.closeDriver();
    }


}
