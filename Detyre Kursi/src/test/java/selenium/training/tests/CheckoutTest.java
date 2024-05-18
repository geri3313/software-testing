package selenium.training.tests;

import org.testng.annotations.Test;
import org.testng.Assert;

import selenium.training.pages.CheckoutPage;

public class CheckoutTest {
    private CheckoutPage checkout;

    public CheckoutTest(){
        checkout = new CheckoutPage();
    }

    @Test
    public void checkoutTest(){
        Assert.assertEquals(checkout.getFirstName(), "Detyre");
        Assert.assertEquals(checkout.getLastName(), "Kursi");
        Assert.assertEquals(checkout.getEmailString(), "test111.test@test.com");
        Assert.assertEquals(checkout.getCompanyString(), "Company");
        
        checkout.fillForm(3, "Tirana", "Address 1", "Address 2", "1001", "01010101");
        checkout.clickContinueButton();
    }
}
