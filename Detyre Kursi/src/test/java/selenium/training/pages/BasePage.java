package selenium.training.pages;

import org.openqa.selenium.support.PageFactory;
import selenium.training.utils.Driver;

//import java.time.Duration;

public class BasePage {

    protected String email = "test111.test@test.com";

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
