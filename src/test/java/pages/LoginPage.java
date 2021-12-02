package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath="//input[@id='username']")
    public WebElement usernameTextbox;

    @FindBy(xpath="//input[@id='password']")
    public WebElement password;

    @FindBy(xpath="//button[@type='submit']//span[text()='Sign in']")
    public WebElement signIn;

    @FindBy( id = "password")
    public WebElement passwordTextbox;

    @FindBy(xpath = "//*[@class='btn btn-primary']")
    public WebElement signInButton;

    @FindBy (xpath = "//*[@class='btn btn-secondary']")
    public WebElement cancelbutton;

    @FindBy(xpath="//*[@id=\"username\"]")
    public WebElement userName;

    @FindBy(xpath = "//*[@id=\"settings-form\"]/button/span")
    public WebElement saveButton;

    @FindBy(xpath = "//span[normalize-space()='xuser xuser']")
    public WebElement dropDown;

    @FindBy(xpath = "//span[normalize-space()='User Info']")
    public WebElement userInfo;

    @FindBy(id="email")
    public WebElement emailTextBox;

    @FindBy(xpath = "//div[@class='invalid-feedback']")
    public WebElement errorMessage;

    @FindBy(xpath = "//select[@id='langKey']")
    public WebElement languageDropDown;

    @FindBy(xpath = "//div[@class='alert alert-danger fade show']")
    public WebElement failMessage;

    @FindBy(xpath = "//span[text()='Did you forget your password?']")
    public WebElement forgetPassword;

    @FindBy(xpath = "//span[text()='Register a new account']")
    public WebElement registerNewAccount;

    @FindBy(xpath = "//*[@id=\"email\"]")
    public WebElement email;


}
