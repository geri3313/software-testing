package selenium.training.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import selenium.training.pages.DashboardPage;
import selenium.training.pages.HomePage;
import selenium.training.pages.RegisterPage;
//import selenium.training.utils.Driver;

public class RegisterTest {
    
    private HomePage homePage;
    private RegisterPage register;
    private DashboardPage dashboard;

    public RegisterTest(){
        homePage = new HomePage();
        register = new RegisterPage();
        dashboard = new DashboardPage();
    }

    @AfterMethod
    public void afterRegistrationTest(){
        dashboard.clickLogout();
    }

    @Test
    public void registerTest(){
        homePage.homeRegister();
        register.register("Detyre", "Kursi", "Company", "password123");
        String actualResult = register.getRegistrationResult();
        assertEquals("Your registration completed", actualResult);
    }
}

