package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

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












}
