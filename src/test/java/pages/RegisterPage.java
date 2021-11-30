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

    @FindBy(xpath = "//li[@class='point'][3]")
    public WebElement yellowPasswordStrengthBar;

    @FindBy(xpath = "//li[@class='point'][4]")
    public WebElement greenPasswordStrength;

    @FindBy(xpath = "//li[@class='point'][5]")
    public WebElement greenStrongestPassword;


//    @FindBy(id = "strengthBar")
//    public WebElement passwordStrengthBar;

   // @FindBy (class="invalid-feedback")
    //public WebElement passwordMessage;



 //   @FindBy(id = "register-submit")
 //   public WebElement registerButton;












}
