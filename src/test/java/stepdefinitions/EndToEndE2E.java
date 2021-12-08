package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.*;
import pojos.RegistrantPojo;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class EndToEndE2E {

    MainPage mainPage = new MainPage();
    RegisterPage registerPage = new RegisterPage();
    LoginPage loginPage = new LoginPage();
    CommonElementsPage commonPageElements = new CommonElementsPage();
    CreateEditAccountPage createEditAccountPage = new CreateEditAccountPage();
    CustomerPage customerPage = new CustomerPage();
    MoneyTransferPage moneyTransferPage = new MoneyTransferPage();
    Actions action = new Actions(Driver.getDriver());
    RegistrantPojo registrant = new RegistrantPojo();
    String accountName1;
    String accountName2;

    @Given("_user is on the registration page")
    public void _userIsOnTheRegistrationPage() {
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        mainPage.humanIcon.click();
        mainPage.register.click();
    }

    @And("_user enters ssn number as {string}")
    public void _userEntersSsnNumberAs(String newcustomer_ssn) {
        newcustomer_ssn=ConfigReader.getProperty("newcustomer_ssn");
        ReusableMethods.waitAndSendText(registerPage.ssnTextbox, newcustomer_ssn, 10);
    }

    @Then("_user enters firstname as {string}")
    public void _userEntersFirstnameAs(String newcustomer_firstname) {
        newcustomer_firstname=ConfigReader.getProperty("newcustomer_firstname");
        ReusableMethods.waitAndSendText(registerPage.firstnameTextbox, newcustomer_firstname, 10);
    }

    @Then("_user enters lastname  as {string}")
    public void _userEntersLastnameAs(String newcustomer_lastname) {
        newcustomer_lastname=ConfigReader.getProperty("newcustomer_lastname");
        ReusableMethods.waitAndSendText(registerPage.lastnameTextbox, newcustomer_lastname, 10);
    }

    @When("_user provides address {string}")
    public void _userProvidesAddress(String newcustomer_address) {
        newcustomer_address=ConfigReader.getProperty("newcustomer_address");
        ReusableMethods.waitAndSendText(registerPage.addressTextbox, newcustomer_address, 8);
    }

    @Then("_user provides phoneNumber as {string}")
    public void _userProvidesPhoneNumberAs(String newcustomer_phone) {
        newcustomer_phone=ConfigReader.getProperty("newcustomer_phone");
        ReusableMethods.waitAndSendText(registerPage.phonenumberTextbox, newcustomer_phone, 10);
    }

    @And("_user provides a username {string}")
    public void _userProvidesAUsername(String newcustomer_username) {
        newcustomer_username=ConfigReader.getProperty("newcustomer_username");
        ReusableMethods.waitAndSendText(registerPage.usernameTextbox, newcustomer_username, 10);
        registrant.setUsername(newcustomer_username);
    }

    @Then("_user provides email id as {string}")
    public void _userProvidesEmailIdAs(String newcustomer_email) {
        newcustomer_email=ConfigReader.getProperty("newcustomer_email");
        ReusableMethods.waitAndSendText(registerPage.emailTextbox, newcustomer_email, 8);
    }

    @When("_user enters the password as {string}")
    public void _userEntersThePasswordAs(String newcustomer_fpassword) {
        newcustomer_fpassword=ConfigReader.getProperty("newcustomer_fpassword");
        ReusableMethods.waitAndSendText(registerPage.firstPasswordTextbox, newcustomer_fpassword, 8);
    }

    @And("_user confirms the new password {string}")
    public void _userConfirmsTheNewPassword(String newcustomer_spassword) {
        newcustomer_spassword=ConfigReader.getProperty("newcustomer_spassword");
        ReusableMethods.waitAndSendText(registerPage.secondPasswordTextbox, newcustomer_spassword, 5);
    }

    @Then("_user clicks on register button and sees the success message as {string}")
    public void _userClicksOnRegisterButtonAndSeesTheSuccessMessageAs(String newcustomer_successfulmessage) {
        ReusableMethods.waitAndClick(registerPage.registerButton, 10);
        ReusableMethods.waitFor(3);
        Assert.assertTrue("Registration saved!", registerPage.successMessageToastContainer.isDisplayed());
    }


    @Given("admin goes to login page")
    public void adminGoesToLoginPage() {
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        mainPage.humanIcon.click();
        mainPage.singIn.click();
    }

    @And("admin enter {string} and {string}")
    public void adminEnterAnd(String admin_usernamee, String admin_passwordd) {
        loginPage.usernameTextbox.sendKeys(ConfigReader.getProperty("admin_usernamee"));
        loginPage.passwordTextbox.sendKeys(ConfigReader.getProperty("admin_passwordd"));
        ReusableMethods.wait(2);
    }

    @And("admin clicks sig in button_")
    public void adminClicksSigInButton_() {
        loginPage.signInButton.click();
    }

    @And("admin clicks on the administration button")
    public void adminClicksOnTheAdministrationButton() {
        ReusableMethods.wait(2);
        commonPageElements.administrationDropdown.click();
    }

    @And("admin clicks on the user management button")
    public void adminClicksOnTheUserManagementButton() {
        commonPageElements.userManagementButton.click();
    }

    @Then("admin finds customer {string} and activates user")
    public void adminFindsCustomerAndActivatesUser(String newcustomer_username) {
        ReusableMethods.wait(2);
        commonPageElements.createDateSortButton.click();
        if (commonPageElements.activatedUser(ConfigReader.getProperty("newcustomer_username")).getText().equals("Deactivated")) {
            commonPageElements.activatedUser(ConfigReader.getProperty("newcustomer_username")).click();
        }
        ReusableMethods.wait(4);
      }

    @And("admin signs out")
    public void adminSignsOut() {
        commonPageElements.accountMenu.click();
        commonPageElements.signOutButton.click();
    }

    @Given("employee login page with username {string} and password {string}")
    public void employeeLoginPageWithUsernameAndPassword(String employee_usernamee, String employee_passwordd) {
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        mainPage.humanIcon.click();
        mainPage.singIn.click();
        loginPage.usernameTextbox.sendKeys(ConfigReader.getProperty("employee_usernamee"));
        loginPage.passwordTextbox.sendKeys(ConfigReader.getProperty("employee_passwordd"));
        ReusableMethods.wait(1);
        loginPage.signInButton.click();
    }

    @And("click My Operations and clicks manage accounts")
    public void clickMyOperationsAndClicksManageAccounts() {
        ReusableMethods.wait(1);
        commonPageElements.myOperations.click();
        commonPageElements.manageAccount.click();
    }

    @And("click to create a new account")
    public void clickToCreateANewAccount() {
        ReusableMethods.wait(2);
        commonPageElements.createANewAccount.click();
    }

    @And("enter a description {string}")
    public void enterADescription(String description) {
        ReusableMethods.wait(2);
        createEditAccountPage.description.sendKeys(description);
        accountName1 = description;

        if (accountName1 != description) {
            accountName2 = description;
        }
    }

    @And("enter a balance {string}")
    public void enterABalance(String balance) {
        createEditAccountPage.balance.sendKeys(balance);
    }

    @And("choose an account type {string}")
    public void chooseAnAccountType(String type) {
        Select select = new Select(createEditAccountPage.accountType);
        select.selectByVisibleText(type);
    }

    @And("chose an account status {string}")
    public void choseAnAccountStatus(String account_status) {
        Select select1 = new Select(createEditAccountPage.accountStatus);
        select1.selectByVisibleText(account_status);
    }

    @Then("click save button")
    public void clickSaveButton() {
        ReusableMethods.wait(2);
        createEditAccountPage.saveButton.click();
    }

    @And("employee signs out")
    public void employeeSignsOut() {
        commonPageElements.accountMenu.click();
        commonPageElements.signOutButton.click();
        ReusableMethods.wait(1);
    }

    @And("click My Operations and clicks manage customers")
    public void clickMyOperationsAndClicksManageCustomers() {
        ReusableMethods.wait(2);
        commonPageElements.myOperations.click();
        commonPageElements.manageCustomer.click();
    }

    @And("click to create a new customer")
    public void clickToCreateANewCustomer() {
        ReusableMethods.wait(2);
        commonPageElements.createANewCustomer.click();
    }

    @And("employee types the SSN as {string}")
    public void employeeTypesTheSSNAs(String newcustomer_ssn) {
        customerPage.ssnTextbox.sendKeys(ConfigReader.getProperty("newcustomer_ssn"));
    }

    @And("click on the search button")
    public void clickOnTheSearchButton() {
        ReusableMethods.wait(2);
        customerPage.searchButton.click();
    }

    @Then("enter the middle name initial as {string}")
    public void enterTheMiddleNameInitialAs(String newcustomer_middlename) {
        customerPage.middleInitialTextbox.sendKeys(ConfigReader.getProperty("newcustomer_middlename"));
    }

    @And("enter phone number as {string}")
    public void enterPhoneNumberAs(String newcustomer_phone) {
        customerPage.phoneNumberTextbox.sendKeys(ConfigReader.getProperty("newcustomer_phone"));
    }

    @And("enter zip code as {string}")
    public void enterZipCodeAs(String newcustomer_zipcode) {
        customerPage.zipCodeTextbox.sendKeys(ConfigReader.getProperty("newcustomer_zipcode"));
    }

    @And("enter city as {string}")
    public void enterCityAs(String newcustomer_city) {
        customerPage.cityTextbox.sendKeys(ConfigReader.getProperty("newcustomer_city"));
    }

    @And("choose a country as {string}")
    public void chooseACountryAs(String newcustomer_country) {
        Select select2 = new Select(customerPage.countryDropdown);
        select2.selectByVisibleText(ConfigReader.getProperty("newcustomer_country"));
    }

    @And("enter a State as {string}")
    public void enterAStateAs(String newcustomer_state) {
        customerPage.stateTextbox.sendKeys(ConfigReader.getProperty("newcustomer_state"));
    }

    @And("choose two accounts")
    public void chooseTwoAccounts() {
        ReusableMethods.wait(2);
        action.click(customerPage.account1("oooChecking Account")).
                keyDown(Keys.CONTROL).click(customerPage.account1("oooSaving Account")).perform();
        action.keyUp(Keys.CONTROL).perform();
        ReusableMethods.wait(3);
    }

    @Then("click on the Save button")
    public void clickOnTheSaveButton() {
        ReusableMethods.wait(2);
        customerPage.saveButton.click();
    }

    @Given("customer goes to login page")
    public void customerGoesToLoginPage() {
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
        mainPage.humanIcon.click();
        mainPage.singIn.click();
    }

    @And("customer provides username {string} and password {string}")
    public void customerProvidesUsernameAndPassword(String newcustomer_username, String newcustomer_fpassword) {
        loginPage.usernameTextbox.sendKeys(ConfigReader.getProperty("newcustomer_username"));
        loginPage.passwordTextbox.sendKeys(ConfigReader.getProperty("newcustomer_fpassword"));
    }

    @And("click on the sign in")
    public void clickOnTheSignIn() {
        loginPage.signInButton.click();
    }

    @And("click on My Operations button")
    public void clickOnMyOperationsButton() {
        ReusableMethods.wait(2);
        commonPageElements.myOperations.click();
    }

    @And("click on Transfer Monet button")
    public void clickOnTransferMonetButton() {
        commonPageElements.transferMoney.click();
    }

    @When("customer selects current account to withdraw money from")
    public void customerSelectsCurrentAccountToWithdrawMoneyFrom() {
        Select select1 = new Select(moneyTransferPage.fromDropdown);
        select1.selectByIndex(2);
        ReusableMethods.wait(2);
    }

    @And("customer selects other account to send monet to")
    public void customerSelectsOtherAccountToSendMonetTo() {
        Select select2 = new Select(moneyTransferPage.toDropdown);
        select2.selectByIndex(1);
    }

    @And("customer provides the balance {string}")
    public void customerProvidesTheBalance(String newcustomer_transferBalance) {
        moneyTransferPage.balanceTextbox.sendKeys(ConfigReader.getProperty("newcustomer_transferBalance"));
    }

    @And("customer types the description")
    public void customerTypesTheDescription() {
        moneyTransferPage.descriptionTextbox.sendKeys("I just send money..:(");
    }

    @Then("customer click on make transfer button")
    public void customerClickOnMakeTransferButton() {
        ReusableMethods.wait(3);
        moneyTransferPage.submitTransactionButton.click();
    }

    @And("customer sees the successful message as {string}")
    public void customerSeesTheSuccessfulMessageAs(String newcustomer_transfersuccessfulmessage) {
        Assert.assertTrue(moneyTransferPage.verifyText("succesfullMessage", ConfigReader.getProperty("newcustomer_transfersuccessfulmessage")));
    }

    @And("close the browser")
    public void closeTheBrowser() {
        Driver.closeDriver();
    }
}


