package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;


import com.github.dockerjava.api.model.Driver;

import dev.failsafe.internal.util.Assert;

public class Lab4 {
    @Test
    public void firstSeleniumTest() throws InterruptedException {
        //Initialize edge webdriver
        WebDriverManager.edgedriver().setup();

        //initialize new edge browser instance
        WebDriver driver = new EdgeDriver();

        driver.manage().window().maximize();

        driver.get("https://demo.nopcommerce.com/");
        
        WebElement login_menu = driver.findElement(By.className("ico-login"));
        login_menu.click();

        WebElement register_menu = driver.findElement(By.className("register-button"));
        register_menu.click();
        System.out.println("title"+ driver.getTitle());

        driver.findElement(By.id("gender-male")).click();

        driver.findElement(By.id("FirstName")).sendKeys("Geri");

        driver.findElement(By.id("LastName")).sendKeys("Meko");

        Select drpBirthday = new Select(driver.findElement(By.name("DateOfBirthDay")));

        JavascriptExecutor jsx = (JavascriptExecutor) driver;
        jsx.executeScript("arguments[0].scrollIntoView(true);", drpBirthday);

        drpBirthday.selectByVisibleText("30");
        Thread.sleep(2000);

        Select drpDateOfBirthMonth = new Select(driver.findElement(By.name("DateOfBirthMonth")));

        JavascriptExecutor jsx1 = (JavascriptExecutor) driver;
        jsx1.executeScript("arguments[0].scrollIntoView(true);", drpDateOfBirthMonth);

        drpDateOfBirthMonth.selectByVisibleText("June");
        Thread.sleep(2000);

        Select drpDateOfBirthYear = new Select(driver.findElement(By.name("DateOfBirthYear")));

        JavascriptExecutor jsx2 = (JavascriptExecutor) driver;
        jsx2.executeScript("arguments[0].scrollIntoView(true);", drpDateOfBirthYear);

        drpDateOfBirthYear.selectByVisibleText("2000");
        Thread.sleep(2000);

        driver.findElement(By.id("Email")).sendKeys("geri.meko@fti.edu.al");

        driver.findElement(By.id("Company")).sendKeys("fti");

        driver.findElement(By.id("Password")).sendKeys("123456");

        driver.findElement(By.id("ConfirmPassword")).sendKeys("123456");

        driver.findElement(By.id("register-button")).click();

        Assertions.assertEquals(driver.findElement(By.className("result")).getText(), "Your registration completed");

        login_menu.click();

        driver.findElement(By.id("Email")).sendKeys("geri.meko@fti.edu.al");

        driver.findElement(By.id("Password")).sendKeys("123456");

        driver.findElement(By.className("ico-login")).click();

        Assertions.assertEquals(driver.findElement(By.xpath("//h2[contains(text(), 'Welcome to our store')]")).getText(),"Welcome to our store");
         
        Assertions.assertEquals(driver.findElement(By.className("ico-logout")).getText(), "Log out");

        driver.findElement(By.className("ico-logout")).click();

    }
}
