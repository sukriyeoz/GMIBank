package pages;

import utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class UserManagementPage {

    public UserManagementPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


}
