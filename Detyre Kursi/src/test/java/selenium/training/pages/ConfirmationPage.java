package selenium.training.pages;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfirmationPage extends BasePage{

    @FindBy(className = "payment-info-next-step-button")
    private WebElement continueButton;

    @FindBy(css = "div.totals div.total-info span.value-summary strong")
    private WebElement confirmTotal;

    @FindBy(className = "title")
    private WebElement orderConfirmationMessage;

    @FindBy(css = "div.order-number strong")
    private WebElement orderNumberElement;

    @FindBy(className = "confirm-order-next-step-button")
    private WebElement confirmButton;

    public String getOrderNumber() {
        return orderNumberElement.getText();
    }

    public String getOrderConfirmationMessage() {
        return orderConfirmationMessage.getText();
    }

    public double getConfirmTotalValue() throws ParseException {
        // Assuming confirmTotal is initialized appropriately
        String totalText = confirmTotal.getText().replaceAll("[^0-9.]", "");
        return NumberFormat.getNumberInstance(Locale.US).parse(totalText).doubleValue();
    }

    public void clickConfirmButton(){
        confirmButton.click();
    }
    
}
