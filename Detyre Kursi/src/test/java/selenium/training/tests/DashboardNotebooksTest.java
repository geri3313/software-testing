package selenium.training.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import selenium.training.pages.DashboardPage;
import selenium.training.pages.HomePage;
import selenium.training.pages.LoginPage;
import selenium.training.utils.Driver;

public class DashboardNotebooksTest {
    private HomePage homePage;
    private LoginPage login;
    private DashboardPage dashboard;

    public DashboardNotebooksTest(){
        homePage = new HomePage();
        login = new LoginPage();
        dashboard = new DashboardPage();
    }

    @AfterMethod
    public void afterAll(){
        DashboardPage dashboard = new DashboardPage();
        dashboard.clickCloseNotificationButton();
        //dashboard.clickLogout();
        //Driver.getDriver().quit();
    }

    @Test
    public void notebooksMenuTest(){
        homePage.homeLogin();
        login.login("password123");
        dashboard.navigateToNotebooksMenu();

        String expectedUrl = "https://demo.nopcommerce.com/notebooks";
        String currentUrl = Driver.getDriver().getCurrentUrl();
        assertEquals(expectedUrl, currentUrl);

        dashboard.clickAddToWishlistButtons(1);
        dashboard.wait(500);
        assertTrue(dashboard.isAddedToWishlist(),"The item was not added to the Wishlist.");

        dashboard.clickAddToWishlistButtons(2);
        dashboard.wait(500);
        assertTrue(dashboard.isAddedToWishlist(),"The item was not added to the Wishlist.");
        
        dashboard.clickAddToChartButtons(3);
        dashboard.wait(1000);
        assertTrue(dashboard.isAddedToChart(), "The item was not added to the chart.");
        dashboard.clickAddToChartButtons(4);
        dashboard.wait(1000);
        assertTrue(dashboard.isAddedToChart(), "The item was not added to the chart.");
        dashboard.clickAddToChartButtons(5);
        dashboard.wait(1000);
        assertTrue(dashboard.isAddedToChart(), "The item was not added to the chart.");

        String wishlistCountText = dashboard.getWishlistItemCount();
        wishlistCountText = wishlistCountText.replaceAll("\\s*\\(\\s*", "(");
        assertEquals("(2)", wishlistCountText);

        String chartCountText = dashboard.getChartItemCount();
        chartCountText = chartCountText.replaceAll("\\s*\\(\\s*", "(");
        //assertEquals(0, 0);
        assertEquals("(3)", chartCountText);
        
    }

}

