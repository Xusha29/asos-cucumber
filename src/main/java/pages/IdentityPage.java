package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IdentityPage extends BasePage {

    @FindBy(xpath = "//a[@id='new-to-asos-tab']")
    private WebElement joinTab;

    @FindBy(xpath = "//input[@value='Continue to checkout']")
    private WebElement continueToCheckoutButton;

    @FindBy(xpath = "//input[@name='Username']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@name='Password']")
    private WebElement passwordField;

    @FindBy(xpath = "//span[@id='EmailAddress-error']")
    private WebElement emailErrorNotification;

    @FindBy(xpath = "//span[@id='Password-error']")
    private WebElement passwordErrorNotification;

    @FindBy(xpath = "//div[@class='social-links-container']")
    private WebElement ssoLinks;

    public IdentityPage(WebDriver driver) {
        super(driver);
    }

    public void clickJoinTab() {
        joinTab.click();
    }

    public WebElement getJoinTab() {
        return joinTab;
    }

    public void clickContinueToCheckoutButton() {
        continueToCheckoutButton.click();
    }

    public void enterTextToEmailField(final String text) {
        emailField.clear();
        emailField.sendKeys(text);
        emailField.sendKeys(Keys.ENTER);
    }

    public void enterBlankTextToPasswordField() {
        passwordField.clear();
        passwordField.sendKeys(Keys.ENTER);
    }

    public String getEmailErrorNotificationText() {
        return emailErrorNotification.getText();
    }

    public String getPasswordErrorNotificationText() {
        return passwordErrorNotification.getText();
    }

    public void isEmailFieldVisible() {
        emailField.isDisplayed();
    }

    public void isPasswordFieldVisible() {
        passwordField.isDisplayed();
    }

    public void isJoinTabVisible() {
        joinTab.isDisplayed();
    }

    public void isSsoLinksVisible() {
        ssoLinks.isDisplayed();
    }
}
