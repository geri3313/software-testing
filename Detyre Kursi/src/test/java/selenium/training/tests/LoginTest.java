package selenium.training.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

import selenium.training.pages.DashboardPage;
import selenium.training.pages.HomePage;
import selenium.training.pages.LoginPage;

public class LoginTest {
    private HomePage homePage;
    private LoginPage login;
    private DashboardPage dashboard;

    public LoginTest(){
        homePage = new HomePage();
        login = new LoginPage();
        dashboard = new DashboardPage();
    } 

    @AfterMethod
    public void afterLoginTest(){
        dashboard.clickLogout();
    }

    @Test
    public void loginTest(){
        homePage.homeLogin();
        login.login("password123");
        assertTrue(dashboard.isWelcomeMessageDisplayed(), "Welcome message is not displayed after login.");
        assertTrue(dashboard.isLogoutMenuDisplayed(),"Log out Menu is not displayed after login.");
    }
}


