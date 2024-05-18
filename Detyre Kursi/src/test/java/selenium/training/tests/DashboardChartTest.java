package selenium.training.tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.text.ParseException;

import selenium.training.pages.CartPage;
import selenium.training.pages.DashboardPage;
import selenium.training.utils.Driver;

public class DashboardChartTest {
    private DashboardPage dashboard;
    private CartPage cart;

    public DashboardChartTest() {
        dashboard = new DashboardPage();
        cart = new CartPage();

    }

/*     @AfterMethod
    public void tearDown() {
        Driver.getDriver().quit();
    } */

    @Test
    public void chartMenuTest() {
        dashboard.hoverChartMenu();
        dashboard.wait(500);
        assertTrue(dashboard.isGoToCartButtonDisplayed(), "Go To Cart button is not displayed");
        dashboard.clickGoToCartButton();

        String expectedUrl = "https://demo.nopcommerce.com/cart";
        String currentUrl = Driver.getDriver().getCurrentUrl();
        assertEquals(currentUrl, expectedUrl, "Current URL doesn't match expected URL");

        assertTrue(cart.isContinueShoppingButtonDisplayed(), "Continue Shopping button is not displayed");
        assertTrue(cart.isEstimateShippingDisplayed(), "Estimate shipping popup is not displayed");

        try {
            assertTrue(cart.verifyTotalValue(), "The sum of prices does not match the total value");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        cart.checkTermsOfServiceCheckbox();
        cart.clickCheckoutButton();
    }
}
