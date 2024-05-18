package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class SeleniumTest {

    @Test
    public void firstSeleniumTest() throws InterruptedException {

        //Initialize edge webdriver
        WebDriverManager.edgedriver().setup();

        //initialize new edge browser instance
        WebDriver driver = new EdgeDriver();

        driver.manage().window().maximize();

        driver.get("https://demo.nopcommerce.com/");

        String currentTitle = driver.getTitle();
        System.out.println(currentTitle);

        System.out.println(driver.getCurrentUrl());



        driver.close();
    }

}
 