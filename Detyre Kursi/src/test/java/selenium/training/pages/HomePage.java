package selenium.training.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import selenium.training.utils.Driver;
import selenium.training.utils.GlobalConfigs;

public class HomePage extends BasePage {

    @FindBy(className = "ico-register")
    private WebElement registerMenu;

    @FindBy(className = "ico-login")
    private WebElement loginMenu;

    public void homeRegister() {
        navigateToHomePage();
        registerMenu.click();
    }

    public void homeLogin() {
        navigateToHomePage();
        loginMenu.click();
    }
    
    public void navigateToHomePage(){
        Driver.getDriver().get(GlobalConfigs.URL);
    }

}
