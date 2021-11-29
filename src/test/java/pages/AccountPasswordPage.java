package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AccountPasswordPage {
     public void AccountPassword(){
         PageFactory.initElements(Driver.getDriver(),this);
     }

     @FindBy(xpath="//input[@placeholder='Please enter current password']")
    public WebElement currentPassword;
     @FindBy(xpath="//input[@placeholder='Please enter new password']")
    public WebElement newPassword;
     @FindBy(xpath= "//li[@class='point'][2]")
    public WebElement  line1;
    @FindBy(xpath="//input[@placeholder='Please confirm your password']")
    public WebElement confirmPassword;
    @FindBy(xpath="//button[@type='submit']//span[text()='Save']")
    public WebElement saveButton;
    @FindBy(xpath="//div[text()='New password should be different from the current one.']")
    public WebElement invalidFeedback;


}
