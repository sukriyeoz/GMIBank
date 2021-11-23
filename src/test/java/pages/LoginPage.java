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
    public WebElement userName;

    @FindBy(xpath="//input[@id='password']")
    public WebElement password;

    @FindBy(xpath="//button[@type='submit']//span[text()='Sign in']")
    public WebElement signIn;







}
