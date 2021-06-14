package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//button[@data-auto-id='saveForLater']")
    private List<WebElement> saveForLaterIcon;

    @FindBy(xpath = "//a[@aria-label='Saved Items']")
    private WebElement savedItems;

    @FindBy(xpath = "//div[contains(@class,'itemCount')]")
    private WebElement itemCount;

    @FindBy(xpath = "//button[contains(@class,'toBagButton')]")
    private List<WebElement> moveToBagButton;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public void clickSaveForLaterIcon() {
        saveForLaterIcon.get(0).click();
        saveForLaterIcon.get(1).click();
        saveForLaterIcon.get(2).click();
    }

    public void clickSavedItems() {
        savedItems.click();
    }

    public String getItemCountText() {
        return itemCount.getText();
    }

    public WebElement getItemCount() {
        return itemCount;
    }

    public int getMoveToBagButtonCount() {
        return moveToBagButton.size();
    }
}
