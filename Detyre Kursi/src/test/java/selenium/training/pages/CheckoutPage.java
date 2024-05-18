package selenium.training.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {
    
    @FindBy(id = "BillingNewAddress_FirstName")
    private WebElement firstNameInput;

    @FindBy(id = "BillingNewAddress_LastName")
    private WebElement lastNameInput;

    @FindBy(id = "BillingNewAddress_Email")
    private WebElement emailInput;

    @FindBy(id = "BillingNewAddress_Company")
    private WebElement companyInput;

    @FindBy(id = "BillingNewAddress_CountryId")
    private WebElement countryId;

    @FindBy(id = "BillingNewAddress_City")
    private WebElement city;

    @FindBy(id = "BillingNewAddress_Address1")
    private WebElement address1;

    @FindBy(id = "BillingNewAddress_Address2")
    private WebElement address2;

    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    private WebElement zipPostalCode;

    @FindBy(id = "BillingNewAddress_PhoneNumber")
    private WebElement phoneNumber;

    @FindBy(className = "new-address-next-step-button")
    private WebElement continueButton;

    public String getFirstName() {
        return firstNameInput.getAttribute("value");
    }
    public String getLastName() {
        return lastNameInput.getAttribute("value");
    }
    public String getEmailString() {
        return emailInput.getAttribute("value");
    }
    public String getCompanyString() {
        return companyInput.getAttribute("value");
    }

    public void fillForm(int id, String cityString, String address1String, String address2String, String zipString, String phoneString ){
        countryId.click();
        for (int i = 0; i < id; i++) {
            countryId.sendKeys(Keys.ARROW_DOWN);
        }
        countryId.sendKeys(Keys.ENTER);
        city.sendKeys(cityString);
        address1.sendKeys(address1String);
        address2.sendKeys(address2String);
        zipPostalCode.sendKeys(zipString);
        phoneNumber.sendKeys(phoneString);
    }

    public void clickContinueButton(){
        continueButton.click();
    }

}
