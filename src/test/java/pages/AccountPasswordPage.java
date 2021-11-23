package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AccountPasswordPage {
     public void AccountPassword(){
         PageFactory.initElements(Driver.getDriver(),this);
     }

     @FindBy(xpath="//input[@name='currentPassword']")
    public WebElement currentPassword;
     @FindBy(xpath="//input[@name='newPassword']")
    public WebElement newPassword;
     @FindBy(xpath= "//li[@class='point'][1]")
    public WebElement  line1;
    @FindBy(xpath="//input[@name='confirmPassword']")
    public WebElement confirmPassword;
    @FindBy(xpath="//button[@type='submit']//span[text()='Save']")
    public WebElement saveButton;


}
