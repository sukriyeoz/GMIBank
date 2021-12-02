package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import pages.*;
import pojos.*;
import utilities.*;
import org.junit.Assert;

public class RegistrantUISteps {

    MainPage mainPage = new MainPage();
    RegisterPage registerPage = new RegisterPage();
    Faker faker = new Faker();
    RegistrantPojo registrant = new RegistrantPojo();
    //    CustomerPojo customer = new CustomerPojo();
//    UserPojo user = new UserPojo();
    String fileNameOfRegistrant = ConfigReader.getProperty("fileNameOfRegistrant");
    String firstname;
    String lastname;
    String firstpassword;
    String username;

    @Given("user is on the registration page")
    public void userIsOnTheRegistrationPage() {
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        mainPage.humanIcon.click();
        mainPage.register.click();
    }

    @And("user enters ssn number as {string}")
    public void userEntersSsnNumberAs(String ssn) {
        ssn = faker.idNumber().ssnValid();
        ReusableMethods.waitAndSendText(registerPage.ssnTextbox,ssn, 10);
        registrant.setSsn(ssn);
    }

    @Then("user enters firstname as {string}")
    public void userEntersFirstnameAs(String firstname) {
        firstname=faker.name().firstName();
        this.firstname=firstname;
        ReusableMethods.waitAndSendText(registerPage.firstnameTextbox,firstname,10);
        registrant.setFirstname(firstname);
    }

    @Then("user enters lastname  as {string}")
    public void userEntersLastnameAs(String lastname) {
        lastname=faker.name().lastName();
        this.lastname=lastname;
        ReusableMethods.waitAndSendText(registerPage.lastnameTextbox,lastname,10);
        registrant.setLastname(lastname);
    }

    @When("user provides address {string}")
    public void userProvidesAddress(String address) {
        address=faker.address().streetAddress();
        ReusableMethods.waitAndSendText(registerPage.addressTextbox,address,8);
        registrant.setAddress(address);
    }

    @Then("user provides phoneNumber as {string}")
    public void userProvidesPhoneNumberAs(String phonenumber) {
        phonenumber=faker.phoneNumber().cellPhone();

        if(phonenumber.contains("(") || phonenumber.contains(")")){
            phonenumber = phonenumber.replace("(","").replace(")","");
        }else {
            phonenumber = phonenumber.replace(".","");
        }
        ReusableMethods.waitAndSendText(registerPage.phonenumberTextbox,phonenumber,10);
        registrant.setPhonenumber(phonenumber);
    }

    @And("user provides a username {string}")
    public void userProvidesAUsername(String username) {
        username=faker.name().username();
        this.username=username;
        ReusableMethods.waitAndSendText(registerPage.usernameTextbox,username,10);
        registrant.setUsername(username);
        System.out.println("username: " + username);
    }

    @Then("user provides email id as {string}")
    public void userProvidesEmailIdAs(String email) {
        email=firstname + lastname + "@gmail.com";
        ReusableMethods.waitAndSendText(registerPage.emailTextbox,email,8);
        registrant.setEmail(email);
    }

    @When("user enters the password as {string}")
    public void userEntersThePasswordAs(String firstpassword) {
        firstpassword=faker.internet().password(10,15,true,true, true);
        this.firstpassword=firstpassword;
        ReusableMethods.waitAndSendText(registerPage.firstPasswordTextbox,firstpassword,8);
        registrant.setPassword(firstpassword);
        System.out.println("password: " + firstpassword);
    }

    @And("user confirms the new password {string}")
    public void userConfirmsTheNewPassword(String secondpassword) {
        secondpassword=firstpassword;
        ReusableMethods.waitAndSendText(registerPage.secondPasswordTextbox,secondpassword,5);

    }

    @Then("user clicks on register button and sees the success message as {string}")
    public void userClicksOnRegisterButtonAndSeesTheSuccessMessageAs(String message) {
        ReusableMethods.waitAndClick(registerPage.registerButton,10);
        ReusableMethods.waitFor(2);
        Assert.assertTrue("Registration saved!",registerPage.successMessageToastContainer.isDisplayed());
//        System.out.println(registerPage.successMessageToastContainer.getText());
        WriteToTxt.saveRegistrantData(fileNameOfRegistrant,registrant);
    }

    @Then("user reads all registrant data")
    public void userReadsAllRegistrantData() {
    }

}
