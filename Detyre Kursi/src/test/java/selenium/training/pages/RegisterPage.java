package selenium.training.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage extends BasePage {

    @FindBy(id = "gender-male")
    private WebElement genderMaleRadioButton;

    @FindBy(id = "FirstName")
    private WebElement firstNameField;

    @FindBy(id = "LastName")
    private WebElement lastNameField;

    @FindBy(name = "DateOfBirthDay")
    private WebElement dateOfBirthDayDropdown;

    @FindBy(name = "DateOfBirthMonth")
    private WebElement dateOfBirthMonthDropdown;

    @FindBy(name = "DateOfBirthYear")
    private WebElement dateOfBirthYearDropdown;

    @FindBy(id = "Email")
    private WebElement emailField;

    @FindBy(id = "Company")
    private WebElement companyField;

    @FindBy(id = "Password")
    private WebElement passwordField;

    @FindBy(id = "ConfirmPassword")
    private WebElement confirmPasswordField;

    @FindBy(id = "register-button")
    private WebElement registerButton;

    @FindBy(className = "result")
    private WebElement registrationResult;

    public void register(String firstName, String lastName, String company, String password) {
        genderMaleRadioButton.click(); 
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        new Select(dateOfBirthDayDropdown).selectByVisibleText("30");
        new Select(dateOfBirthMonthDropdown).selectByVisibleText("June");
        new Select(dateOfBirthYearDropdown).selectByVisibleText("2000");
        emailField.sendKeys(email);
        companyField.sendKeys(company);
        passwordField.sendKeys(password);
        confirmPasswordField.sendKeys(password);
        registerButton.click();
    }

    public String getRegistrationResult() {
        return registrationResult.getText();
    }
}
