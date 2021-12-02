package pages;

import utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserInfoSettingPage{

    public UserInfoSettingPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "email")
    public WebElement emailTextbox;

    @FindBy(xpath = "//div[@class='invalid-feedback']")
    public WebElement emailErrorMessage;

    @FindBy(xpath = "//select[@name='langKey']")
    public WebElement languageDropDown;


}
