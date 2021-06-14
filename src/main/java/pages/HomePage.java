package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//div[@id='chrome-sticky-header']")
    private WebElement header;

    @FindBy(xpath = "//footer")
    private WebElement footer;

    @FindBy(xpath = "//input[@id='chrome-search']")
    private WebElement searchField;

    @FindBy(xpath = "//button[@data-testid='search-button-inline']")
    private WebElement searchButton;

    @FindBy(xpath = "//p[@id='titleMessage']")
    private WebElement messageAbsentPage;

    @FindBy(xpath = "//button[@data-testid='myAccountIcon']")
    private WebElement myAccountIcon;

    @FindBy(xpath = "//a[@data-testid='signin-link']")
    private WebElement signInIcon;

    @FindBy(xpath = "//a[@data-testid='signup-link']")
    private WebElement joinIcon;

    @FindBy(xpath = "//a[@data-testid='miniBagIcon']")
    private WebElement bagIcon;

    @FindBy(xpath = "//a[@data-testid='savedItemsIcon']")
    private WebElement savedItemsIcon;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openPage(String url) {
        driver.get(url);
    }

    public void isHeaderVisible() {
        header.isDisplayed();
    }

    public void isFooterVisible() {
        footer.isDisplayed();
    }

    public void isSearchFieldVisible() {
        searchField.isDisplayed();
    }

    public void enterTextToSearchField(final String searchText) {
        searchField.clear();
        searchField.sendKeys(searchText);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public String getMessageWrongPageText() {
        return messageAbsentPage.getText();
    }

    public void clickMyAccountIcon() {
        myAccountIcon.click();
    }

    public void clickSignInIcon() {
        signInIcon.click();
    }

    public WebElement getSignInIcon() {
        return signInIcon;
    }

    public void isBagIconVisible() {
        bagIcon.isDisplayed();
    }

    public void isSavedItemsIconVisible() {
        savedItemsIcon.isDisplayed();
    }

    public void isMyAccountIconVisible() {
        myAccountIcon.isDisplayed();
    }

    public void isSignInIconVisible() {
        signInIcon.isDisplayed();
    }

    public void isJoinIconVisible() {
        joinIcon.isDisplayed();
    }
}
