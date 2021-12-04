package pages;

import utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CommonPageElements {

    public CommonPageElements() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[contains(text(),'Transfer Money')]")
    public WebElement transferMoney;

    @FindBy(css = "#header-tabs li")
    public List<WebElement> headerTabs;

    @FindBy(id = "account-menu")
    public WebElement accountMenu;

    @FindBy(linkText = "User Info")
    public WebElement userInfo;

    @FindBy(xpath = "//*[text()='My Operations']")
    public WebElement myOperations;

    @FindBy(xpath = "//*[text()='Manage Customers']")
    public WebElement manageCustomer;

    @FindBy(xpath = "//*[text()='Create a new Customer']")
    public WebElement createANewCustomer;

    @FindBy(xpath = "//*[text()='Create Date']/following::input")
    public WebElement dateTextbox;

    @FindBy(xpath = "(//*[@class='d-flex align-items-center dropdown-toggle nav-link'])[2]")
    public WebElement currentUserDropdown;

    @FindBy(xpath = "//*[text()='Manage Accounts']")
    public WebElement manageAccount;

    @FindBy(xpath = "//*[text()='Create a new Account']")
    public WebElement createANewAccount;

    @FindBy(xpath = "//*[text()='Sign out']")
    public WebElement signOutButton;

    @FindBy(xpath = "//*[text()='Administration']")
    public WebElement administrationDropdown;

    @FindBy(xpath = "//*[text()='User management']")
    public WebElement userManagementButton;

   @FindBy(xpath = "//table/tbody/tr")
    public List<WebElement> allUsers;

    @FindBy(xpath = "//thead//tr//th[7]")
    public WebElement createDateSortButton;

    public WebElement activatedUser(String user) {
        WebElement element = Driver.getDriver().findElement(By.xpath("//tbody//tr[@id='" + user + "']//button[@type='button']"));
        return element;
    }

    @FindBy(id = "currentPassword")
    public WebElement currentPassword;

    @FindBy(id = "newPassword")
    public WebElement newPassword;
    @FindBy(xpath = "//li[@class='point'][2]")
    public WebElement line1;
    @FindBy(xpath = "//input[@placeholder='Please confirm your password']")
    public WebElement confirmPassword;
    @FindBy(xpath = "//button[@type='submit']//span[text()='Save']")
    public WebElement saveButton;
    @FindBy(xpath = "//div[text()='New password should be different from the current one.']")
    public WebElement invalidFeedback;


}