package pages;

import utilities.Driver;
import utilities.ReusableMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MoneyTransferPage {

    public MoneyTransferPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@name='fromAccountId']")
    public WebElement fromDropdown;

    @FindBy(xpath = "//*[@name='toAccountId']")
    public WebElement toDropdown;

    @FindBy(xpath ="//*[@name='balance']")
    public WebElement balanceTextbox;

    @FindBy(xpath = "(//*[@name='description'])[2]")
    public WebElement descriptionTextbox;

    @FindBy(xpath = "//*[@id='make-transfer']")
    public WebElement submitTransactionButton;

    @FindBy(xpath = "//*[text()='Transfer is succesfull']")
    public WebElement successMessageToastContainer;

    @FindBy(xpath = "//div[@role='alert']")
    private WebElement succesfullMessage;

    public boolean verifyText(String element, String message) {
        ReusableMethods.waitForVisibility(succesfullMessage, 2);

        System.out.println(succesfullMessage.getText() + ":" + message);

        if (succesfullMessage.getText().contains(message)) return true;

        else return false;
    }

}
