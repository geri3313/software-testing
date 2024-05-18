package selenium.training.pages;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import selenium.training.utils.Driver;

public class DashboardPage extends BasePage{

    @FindBy(xpath = "//h2[contains(text(), 'Welcome to our store')]")
    private WebElement welcomeMessage;

    @FindBy(className = "ico-logout")
    private WebElement logoutMenu;

    @FindBy(linkText = "Computers")
    private WebElement computerMenu;

    @FindBy(linkText = "Notebooks")
    private WebElement notebooksMenu;

    @FindBy(xpath = "//button[@class='button-2 add-to-wishlist-button']")
    private List<WebElement> addToWishlistButtons;

    @FindBy(xpath = "//div[contains(@class, 'bar-notification') and contains(@class, 'success') and contains(., 'The product has been added to your') and .//a[contains(., 'wishlist')]]")
    private WebElement wishlistNotification;
    
    @FindBy(xpath = "//button[@class='button-2 product-box-add-to-cart-button']")
    private List<WebElement> addToCartButtons;

    @FindBy(xpath = "//div[contains(@class, 'bar-notification') and contains(@class, 'success') and contains(., 'The product has been added to your') and .//a[contains(., 'shopping cart')]]")
    private WebElement addedToCartNotification;

    @FindBy(className = "wishlist-qty")
    private WebElement wishlistItemCount;

    @FindBy(className = "cart-qty")
    private WebElement chartItemCount;

    @FindBy(className = "close")
    private WebElement closeNotificationButton;

    @FindBy(className = "cart-label")
    private WebElement chartLabel;

    @FindBy(xpath = "//button[contains(@class, 'cart-button') and text()='Go to cart']")
    private WebElement goToCartButton;

    // Method to click the close button
    public void clickCloseNotificationButton() {
        closeNotificationButton.click();
    }

    public void clickLogout() {
        logoutMenu.click();
    }

    public void wait(int milliseconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds); // Wait for the specified duration
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getWishlistItemCount() {
        return wishlistItemCount.getText();
    }

    public String getChartItemCount() {
        return chartItemCount.getText();
    }

    public boolean isWelcomeMessageDisplayed() {
        try {
            return welcomeMessage.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isLogoutMenuDisplayed() {
        try {
            return logoutMenu.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isAddedToWishlist(){
        try {
            return wishlistNotification.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isAddedToChart(){
        try {
            return addedToCartNotification.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void navigateToNotebooksMenu() {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(computerMenu).perform();
        notebooksMenu.click();
    }

    public void hoverChartMenu(){
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(chartLabel).perform();
    }

    public void clickGoToCartButton() {
        goToCartButton.click();
    }

    public void clickAddToWishlistButtons(int index) {
        if (index >= 0 && index < addToWishlistButtons.size()) {
            addToWishlistButtons.get(index).click();
        } else if (addToWishlistButtons.isEmpty()) {
            System.out.println("No Add to Wishlist buttons found on the page.");
        } else {
            System.out.println("Invalid index. Please provide a valid index within the range of available buttons.");
        }
    }

    public void clickAddToChartButtons(int index) {
        if (addToCartButtons.size() >= 6) {
            addToCartButtons.get(index).click();
        } else {
            System.out.println("There are not enough Add to Cart buttons on the page.");
        }
    }

    public boolean isGoToCartButtonDisplayed() {
        return goToCartButton.isDisplayed();
    }
}
