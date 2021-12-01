//package stepdefinitions;
//
//import com.github.javafaker.Faker;
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import org.junit.Assert;
//import org.openqa.selenium.By;
//import pages.MainPage;
//import pages.RegisterPage;
//import utilities.ConfigReader;
//import utilities.Driver;
//import utilities.ReusableMethods;
//
//public class US001_US002_Emrah {
//
//    MainPage mainPage = new MainPage();
//    RegisterPage registerPage = new RegisterPage();
//    Faker faker = new Faker();
//
//    @Given("user enter the GMIBank Webpage")
//    public void userEnterTheGMIBankWebpage() {
//        Driver.getDriver().get(ConfigReader.getProperty("bank_url"));
//    }
//
//    @And("click human button right topside")
//    public void clickHumanButtonRightTopside() {
//        mainPage.humanIcon.click();
//    }
//
//    @And("click Register in button")
//    public void clickRegisterInButton() {
//        mainPage.register.click();
//    }
//
//    @Given("user enters fields with valid data")
//    public void userEntersFieldsWithValidData() {
//        ReusableMethods.waitFor(2);
//        registerPage.getSSN.sendKeys(faker.number().digits(9));
//        registerPage.fName.sendKeys(faker.name().firstName());
//        registerPage.lName.sendKeys(faker.name().lastName());
//        registerPage.address1.sendKeys(faker.address().fullAddress());
//        registerPage.phoneNumber.sendKeys(faker.phoneNumber().cellPhone());
//        registerPage.userName.sendKeys(faker.name().username());
//        registerPage.emailAddress.sendKeys(faker.internet().emailAddress());
//        registerPage.getPassWord1.sendKeys("Gmibank12345.");
//        registerPage.getPassWord2.sendKeys("Gmibank12345.");
//        ReusableMethods.waitFor(2);
//    }
//
//    @And("user clicks on the register button")
//    public void userClicksOnTheRegisterButton() {
//        registerPage.registerButton.click();
//    }
//
//    @Then("verify success message")
//    public void verifySuccessMessage() {
//        ReusableMethods.waitFor(5);
//        Assert.assertTrue(registerPage.successMessage.isDisplayed());
//        System.out.println(registerPage.successMessage.getText());
//
////        Driver.getDriver().findElement(By.xpath("//div[@class='Toastify__toast-body']"));
////        String alertText = Driver.getDriver().switchTo().alert().getText();
////        System.out.println(alertText);
//    }
//
////    @Then("close the page")
////    public void closeThePage() {
////        Driver.closeDriver();
////    }
//}
//
//
