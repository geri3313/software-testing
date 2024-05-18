package selenium.training.tests;

import org.testng.annotations.Test;

import selenium.training.pages.ShippingPage;

public class ShippingTest {
    
    private ShippingPage shipping;

    public ShippingTest(){
        shipping = new ShippingPage();
    }


    @Test
    public void shippingTest(){
        shipping.selectShippingOption();
        shipping.clickContinueButton();
    }
}
