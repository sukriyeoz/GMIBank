package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SigninPage {
    public SigninPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@id='username']")
    public WebElement userName;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']//span[contains(text(),'Sign in')]")
    public WebElement signIn;

    @FindBy(xpath = "//div[@class='alert alert-danger fade show']")
    public WebElement failMessage;

    @FindBy(xpath = "//span[text()='Did you forget your password?']")
    public WebElement forgetPassword;

    @FindBy(xpath = "//span[text()='Register a new account']")
    public WebElement registerNewAccount;

}
