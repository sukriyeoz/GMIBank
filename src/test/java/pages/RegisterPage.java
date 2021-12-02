package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class RegisterPage {
    public RegisterPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(id = "ssn")
    public WebElement getSSN;

    @FindBy (id = "firstname")
    public WebElement fName;

    @FindBy (id = "lastname")
    public WebElement lName;

    @FindBy (id = "address")
    public WebElement address1;

    @FindBy (id = "mobilephone")
    public WebElement phoneNumber;

    @FindBy (id = "username")
    public WebElement userName;

    @FindBy (id = "email")
    public WebElement emailAddress;

    @FindBy(id= "firstPassword")
    public WebElement getPassWord1;

    @FindBy(id= "secondPassword")
    public WebElement getPassWord2;

    @FindBy(id = "register-submit")
    public WebElement registerButton;

    @FindBy(id = "ssn")
    public WebElement ssnTextbox;

    @FindBy(id = "firstname")
    public WebElement firstnameTextbox;

    @FindBy(id = "lastname")
    public WebElement lastnameTextbox;

    @FindBy(id = "address")
    public WebElement addressTextbox;

    @FindBy(id = "mobilephone")
    public WebElement phonenumberTextbox;

    @FindBy(id = "username")
    public WebElement usernameTextbox;

    @FindBy(id = "email")
    public WebElement emailTextbox;

    @FindBy(id = "firstPassword")
    public WebElement firstPasswordTextbox;

    @FindBy(id = "secondPassword")
    public WebElement secondPasswordTextbox;

    @FindBy(xpath = "//*[text()='Registration saved!']")
    public WebElement successMessageToastContainer;

    @FindBy(css = "div.invalid-feedback")
    public List<WebElement> errorMessages;

    @FindBy(xpath= "(//div[@class='invalid-feedback'])[1]")
    public WebElement ssnErrorMessage;

    @FindBy(css= "div.invalid-feedback")
    public WebElement phonenumberErrorMessage;

    @FindBy(css = "div.invalid-feedback")
    public WebElement emailErrorMessage;




}
