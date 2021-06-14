package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//span[contains(text(),'Add to bag')]")
    private WebElement addToBagButton;

    @FindBy(xpath = "//ul[@class ='_12ChTgQ']//div[@class='_1F1C1jC']")
    private WebElement addToBagPopupHeader;

    @FindBy(xpath = "//a[@data-test-id ='checkout-link']//span[@class='_1M-cSy1']")
    private WebElement checkoutButton;

    @FindBy(xpath = "//a[@data-test-id ='bag-link']//span[@class='_1M-cSy1']")
    private WebElement viewBagButton;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddToBagButton() {
        addToBagButton.click();
    }

    public WebElement getAddToBagButton() {
        return addToBagButton;
    }

    public boolean isAddToBagPopupVisible() {
        return addToBagPopupHeader.isDisplayed();
    }

    public String getAddToBagPopupHeaderText() {
        return addToBagPopupHeader.getText();
    }

    public void isViewBagButtonVisible() {
        viewBagButton.isDisplayed();
    }

    public void isCheckoutButtonVisible() {
        checkoutButton.isDisplayed();
    }

    public void clickViewBagButton() {
        viewBagButton.click();
    }

    public void clickCheckoutButton() {
        checkoutButton.click();
    }

    public WebElement getAddToBagPopupHeader() {
        return addToBagPopupHeader;
    }
}
