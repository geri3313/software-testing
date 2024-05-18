package selenium.training.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends BasePage {

    @FindBy(id = "paymentmethod_0")
    private WebElement paymentWithCheck;

    @FindBy(className = "payment-method-next-step-button")
    private WebElement continueButton;

    public void checkAndContinue(){
        if(paymentWithCheck.isSelected()){
            continueButton.click();
        } else {
            paymentWithCheck.click();
            continueButton.click();
        }
    }
    
}
