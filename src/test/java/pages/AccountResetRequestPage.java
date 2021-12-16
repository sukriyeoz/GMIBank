package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.nio.file.WatchEvent;

public class AccountResetRequestPage {

    public AccountResetRequestPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//input[@name='email']")
    public WebElement enterEmail;
    @FindBy(xpath = "//span[text()='Reset password']")
    public WebElement resetPassword;
    @FindBy(xpath = "//div[normalize-space()='Check your emails for details on how to reset your password.']")
    public WebElement resetMessage;

}