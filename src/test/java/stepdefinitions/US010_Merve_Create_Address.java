package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import pages.CommonElementsPage;
import pages.CustomerPage;
import pages.LoginPage;
import pages.MainPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US010_Merve_Create_Address {
    MainPage mainPage = new MainPage();
    LoginPage loginPage = new LoginPage();
    CommonElementsPage commonPageElements = new CommonElementsPage();
    CustomerPage customerPage = new CustomerPage();
    Faker faker = new Faker();

    @Given("user enter the GMIBank Webpage")
    public void user_enter_the_gmi_bank_webpage() {
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
    }

    @Given("click human button right topside")
    public void click_human_button_right_topside() {
        mainPage.humanIcon.click();
    }

    @Given("user click sign in button")
    public void user_click_sign_in_button() {
        mainPage.singIn.click();
    }
    @Given("sign in with employee credentials")
    public void sign_in_with_employee_credentials() {
        loginPage.usernameTextbox.sendKeys(ConfigReader.getProperty("employeeRole"));
        loginPage.passwordTextbox.sendKeys(ConfigReader.getProperty("employeePassword"));
        loginPage.signIn.click();
    }
    @Given("click the Manage Customers option from the My Operations dropdown")
    public void click_the_manage_customers_option_from_the_my_operations_dropdown() {
        commonPageElements.myOperations.click();
        commonPageElements.manageCustomer.click();
    }
    @Given("click create a new customer button")
    public void click_create_a_new_customer_button() {
        commonPageElements.createANewCustomer.click();
    }
    @Given("user enter all required fields")
    public void user_enter_all_required_fields() {
        String ssn = faker.numerify("###-##-####");
        customerPage.ssnTextbox.sendKeys(ssn);
        customerPage.firstNameTextbox.sendKeys(faker.name().firstName());
        customerPage.lastNameTextbox.sendKeys(faker.name().lastName());
        customerPage.middleInitialTextbox.sendKeys(faker.letterify("?",true));
        customerPage.emailTextbox.sendKeys(faker.internet().emailAddress());
        String phone = faker.numerify("###-###-####");
        customerPage.mobilePhoneNumberTextbox.sendKeys(phone);
        customerPage.phoneNumberTextbox.sendKeys(phone);
        customerPage.zipCodeTextbox.sendKeys(faker.address().zipCode());
        customerPage.addressTextbox.sendKeys(faker.address().streetAddress());
        customerPage.cityTextbox.sendKeys(faker.address().city());
        customerPage.ssnTextbox2.sendKeys(ssn);
        Select select = new Select(customerPage.countryDropdown);
        select.selectByVisibleText("USA");
        customerPage.stateTextbox.sendKeys(faker.address().state());
        Select select1 = new Select(customerPage.userDropdown);
        select1.getFirstSelectedOption();
        Select select2 = new Select(customerPage.accountsDropdown);
        select2.selectByIndex(4);
        customerPage.zelloEnrolledCheckmark.click();


    }
    @Given("the address box should be left blank")
    public void the_address_box_should_be_left_blank() {
        customerPage.addressTextbox.clear();
    }
    @Then("verify {string} text message at the bottom of the address box")
    public void verify_text_message_at_the_bottom_of_the_address_box(String string) {
        customerPage.saveButton.click();
        ReusableMethods.wait(5);
        Assert.assertTrue("This field is required.",customerPage.error.isDisplayed());
        System.out.println(customerPage.error.getText());

    }
    @Given("city box should be left blank")
    public void city_box_should_be_left_blank() {
        customerPage.cityTextbox.clear();
    }
    @Then("verify {string} text message at the bottom of the city box")
    public void verify_text_message_at_the_bottom_of_the_city_box(String string) {
        customerPage.saveButton.click();
        ReusableMethods.wait(5);
        Assert.assertTrue("This field is required.",customerPage.error.isDisplayed());
        System.out.println(customerPage.error.getText());

    }
    @Given("country box should be left blank")
    public void country_box_should_be_left_blank() {
        Select select = new Select(customerPage.countryDropdown);
        select.selectByIndex(0);
    }
    @Then("verify {string} text message at the bottom of the country box")
    public void verify_text_message_at_the_bottom_of_the_country_box(String string) {
        customerPage.saveButton.click();
        ReusableMethods.wait(5);
        Assert.assertTrue("This field is required.",customerPage.error.isDisplayed());
        System.out.println(customerPage.error.getText());

    }
    @Given("state box should be left blank")
    public void state_box_should_be_left_blank() {
        customerPage.stateTextbox.clear();
    }
    @Then("verify {string} text message at the bottom of the state box")
    public void verify_text_message_at_the_bottom_of_the_state_box(String string) {
        customerPage.saveButton.click();
        ReusableMethods.wait(5);
        Assert.assertTrue("This field is required.",customerPage.error.isDisplayed());
        System.out.println(customerPage.error.getText());

    }
    @Then("closes the application")
    public void closes_the_application() {
        Driver.closeDriver();
    }

}