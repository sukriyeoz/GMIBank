package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class MainPage {

    public MainPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy (xpath = "//li[@id='account-menu']//a[@class='dropdown-toggle nav-link']")
    public WebElement humanIcon;

    @FindBy (xpath = "//span[normalize-space()='Sign in']")
    public WebElement singIn;

    @FindBy (xpath = "//span[normalize-space()='Register']")
    public WebElement register;

    @FindBy(xpath="//a[@href='/account/password']")
    public WebElement password;

    @FindBy(xpath="//*[@id=\"account-menu\"]/div/a[1]/span")
    public WebElement userInfo;

    @FindBy (xpath = "//*[@id=\"login-item\"]")
    public WebElement signInall;


}