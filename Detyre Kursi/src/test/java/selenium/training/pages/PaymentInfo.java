package selenium.training.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentInfo extends BasePage{

    @FindBy(className = "payment-info-next-step-button")
    private WebElement continueButton;

    public void clickContinueButton(){
        continueButton.click();
    }
    
}
