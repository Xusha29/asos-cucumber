package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingBagPage extends BasePage {

    @FindBy(xpath = "//span[@data-test-id='miniBagItemCount']")
    private WebElement shoppingBagTitle;

    @FindBy(xpath = "//a[contains(@class,'bag-total-button--checkout--total')]")
    private WebElement checkoutButton;

    public ShoppingBagPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getShoppingBagTitle() {
        return shoppingBagTitle;
    }

    public String getShoppingBagTitleAmountOfProducts() {
        return shoppingBagTitle.getText();
    }

    public boolean isShoppingBagTitleVisible() {
        return shoppingBagTitle.isDisplayed();
    }

    public void clickCheckoutButton() {
        checkoutButton.click();
    }
}
