package selenium.training.tests;

import java.text.ParseException;

import org.junit.jupiter.api.Assertions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import selenium.training.pages.CartPage;
import selenium.training.pages.ConfirmationPage;
import selenium.training.pages.DashboardPage;
import selenium.training.pages.PaymentInfo;
import selenium.training.utils.Driver;

public class ConfirmationTest {

    private DashboardPage dashboard;
    private CartPage cart;
    private PaymentInfo paymentInfo;
    private ConfirmationPage confirmation;

    public ConfirmationTest(){
        dashboard = new DashboardPage();
        cart = new CartPage();
        paymentInfo = new PaymentInfo();
        confirmation = new ConfirmationPage();
    }

    @AfterMethod
    public void tearDown(){
        Driver.getDriver().quit();
    }

    @Test
    public void confirmationTest(){

        paymentInfo.clickContinueButton();

        try {
            Assertions.assertEquals(cart.getTotalValue(), confirmation.getConfirmTotalValue());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        dashboard.wait(2000);

        confirmation.clickConfirmButton();

        dashboard.wait(5000);


        Assertions.assertEquals(confirmation.getOrderConfirmationMessage(), "Your order has been successfully processed!");
        Assert.assertNotNull(confirmation.getOrderNumber(), "Order number is not displayed");
        Assert.assertNotEquals(confirmation.getOrderNumber().trim(), "", "Order number is empty");
        Assert.assertNotEquals(confirmation.getOrderNumber().trim(), "0", "Order number is 0");
    }
    
}
