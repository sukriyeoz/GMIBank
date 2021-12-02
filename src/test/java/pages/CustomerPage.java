package pages;

import utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerPage {

    public CustomerPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@class='Toastify__toast-body']")
    public WebElement succesmessage;

    @FindBy(name = "search-ssn")
    public WebElement ssnTextbox;

    @FindBy(xpath = "//*[text()='Search']")
    public WebElement searchButton;

    @FindBy(name = "firstName")
    public WebElement firstNameTextbox;

    @FindBy(name = "lastName")
    public WebElement lastNameTextbox;

    @FindBy(name = "middleInitial")
    public WebElement middleInitialTextbox;

    @FindBy(name = "email")
    public WebElement emailTextbox;

    @FindBy(name = "address")
    public WebElement addressTextbox;

    @FindBy(name = "mobilePhoneNumber")
    public WebElement mobilePhoneNumberTextbox;

    @FindBy(name = "phoneNumber")
    public WebElement phoneNumberTextbox;

    @FindBy(name = "zipCode")
    public WebElement zipCodeTextbox;

    @FindBy(name = "username")
    public WebElement usernameTextbox;

    @FindBy(name = "city")
    public WebElement cityTextbox;

    @FindBy(name = "ssn")
    public WebElement ssnTextbox2;

    @FindBy(name = "country.id")
    public WebElement countryDropdown;

    @FindBy(name = "state")
    public WebElement stateTextbox;

    @FindBy(name = "country.id")
    public WebElement userDropdown;

    @FindBy(name = "accounts")
    public WebElement accountsDropdown;

    @FindBy(name = "zelleEnrolled")
    public WebElement zelloEnrolledCheckmark;

    @FindBy(id = "save-entity")
    public WebElement saveButton;

    @FindBy(xpath = "//*[text()='Create Date']/following::input")
    public WebElement createDateTextbox;

    public WebElement account1(String account){
        return Driver.getDriver().findElement(By.xpath("//option[text()='" + account + "']"));
    }

}
