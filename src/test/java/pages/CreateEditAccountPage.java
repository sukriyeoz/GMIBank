package pages;

import utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateEditAccountPage {

    public CreateEditAccountPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "tp-account-description")
    public WebElement description;

    @FindBy(id = "tp-account-balance")
    public WebElement balance;

    @FindBy(id = "tp-account-accountType")
    public WebElement accountType;

    @FindBy(id = "tp-account-accountStatusType")
    public WebElement accountStatus;

    @FindBy(id = "save-entity")
    public WebElement saveButton;


}
