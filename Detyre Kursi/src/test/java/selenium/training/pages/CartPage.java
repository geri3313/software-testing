package selenium.training.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;

public class CartPage extends BasePage {
    @FindBy(css = "button.button-2.continue-shopping-button")
    private WebElement continueShoppingButton;

    @FindBy(id = "open-estimate-shipping-popup")
    private WebElement estimateShipping;

    @FindBy(css = "td.subtotal span.product-subtotal")
    private List<WebElement> priceElements;

    @FindBy(css = "tr.order-total span.value-summary strong")
    private WebElement totalElement;

    @FindBy(xpath = "//label[contains(., 'I agree with the terms of service')]/preceding-sibling::input[@type='checkbox']")
    WebElement termsOfServiceCheckbox;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    public boolean isContinueShoppingButtonDisplayed() {
        return continueShoppingButton.isDisplayed();
    }

    public boolean isEstimateShippingDisplayed(){
        return estimateShipping.isDisplayed();
    }

    public double calculateSumOfPrices() throws ParseException {
        double sum = 0.0;
        for (WebElement priceElement : priceElements) {
            String priceText = priceElement.getText().replaceAll("[^0-9.]", "");
            double price = NumberFormat.getNumberInstance(Locale.US).parse(priceText).doubleValue();
            sum += price;
        }
        return sum;
    }

    public double getTotalValue() throws ParseException {
        String totalText = totalElement.getText().replaceAll("[^0-9.]", "");
        return NumberFormat.getNumberInstance(Locale.US).parse(totalText).doubleValue();
    }

    public boolean verifyTotalValue() throws ParseException {
        double sum = calculateSumOfPrices();
        double total = getTotalValue();
        return Math.abs(sum - total) < 0.01;
    }

    public void checkTermsOfServiceCheckbox() {
        if (!termsOfServiceCheckbox.isSelected()) {
            termsOfServiceCheckbox.click();
        }
    }

    public void clickCheckoutButton(){
        checkoutButton.click();
    }
}