package selenium.training.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShippingPage extends BasePage{

    @FindBy(id = "shippingoption_1")
    private WebElement nextDayShippingOption; 

    @FindBy(className = "shipping-method-next-step-button")
    private WebElement continueButton;

    public void selectShippingOption(){
        if(!nextDayShippingOption.isSelected()){
            nextDayShippingOption.click();
        }
    }

    public void clickContinueButton(){
        continueButton.click();
    }
    
}
