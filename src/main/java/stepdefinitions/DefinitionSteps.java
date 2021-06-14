package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.apache.commons.lang3.StringUtils.startsWith;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DefinitionSteps {

    private static final long DEFAULT_TIMEOUT = 30;

    WebDriver driver;
    HomePage homePage;
    ShoppingBagPage shoppingBagPage;
    SearchResultsPage searchResultsPage;
    ProductPage productPage;
    IdentityPage identityPage;
    PageFactoryManager pageFactoryManager;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @And("User opens {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openPage(url);
    }

    @And("User checks header visibility")
    public void checkHeaderVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        homePage.isHeaderVisible();
    }

    @And("User checks footer visibility")
    public void checkFooterVisibility() {
        homePage.isFooterVisible();
    }

    @And("User checks search field visibility")
    public void checkSearchVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.isSearchFieldVisible();
    }

    @When("User makes search by keyword {string}")
    public void userMakesSearchByKeywordKeyword(final String keyword) {
        homePage.enterTextToSearchField(keyword);
    }

    @And("User clicks search button")
    public void userClicksSearchButton() {
        homePage.clickSearchButton();
    }

    @And("User clicks 'Add to bag' button on product")
    public void userClicksAddToBagButtonOnProduct() {
        productPage = pageFactoryManager.getProductPage();
        productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        productPage.waitForAjaxToCompletePdp(DEFAULT_TIMEOUT);
        productPage.clickAddToBagButton();
    }

    @And("User clicks 'Add to bag' button on product second time")
    public void userClicksAddToBagButtonOnProductSecondTime() {
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, productPage.getAddToBagButton());
        productPage.clickAddToBagButton();
    }

    @And("User checks that add to bag popup visible")
    public void userChecksThatAddToBagPopupVisible() {
        productPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, productPage.getAddToBagPopupHeader());
        assertTrue(productPage.isAddToBagPopupVisible());
    }

    @And("User checks 'View bag' button visibility")
    public void userChecksViewBagButtonVisibility() {
        productPage.isViewBagButtonVisible();
    }

    @And("User clicks 'View bag' button")
    public void userClicksViewBagButton() {
        productPage.clickViewBagButton();
    }

    @And("User clicks 'Checkout' button")
    public void userClicksCheckoutButton() {
        productPage.clickCheckoutButton();
    }

    @And("User clicks 'Join' tab")
    public void userClicksJoinTab() {
        identityPage = pageFactoryManager.getIdentityPage();
        identityPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, identityPage.getJoinTab());
        identityPage.clickJoinTab();
    }

    @Then("User checks that amount of products in saved items are {string}")
    public void userChecksThatAmountOfProductsInSavedItemsAreAmountOfItems(final String expectedText) {
        searchResultsPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, searchResultsPage.getItemCount());
        assertEquals(searchResultsPage.getItemCountText(), expectedText);
    }

    @And("User checks 'Checkout' button visibility")
    public void userChecksCheckoutButtonVisibility() {
        productPage.isCheckoutButtonVisible();
    }

    @Then("User checks that add to bag popup header is {string}")
    public void userChecksThatAddToBagPopupHeaderIsHeader(final String expectedText) {
        assertEquals(productPage.getAddToBagPopupHeaderText(), expectedText);
    }

    @And("User clicks 'Checkout' button in bag")
    public void userClicksCheckoutInBagButton() {
        shoppingBagPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        shoppingBagPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        shoppingBagPage.clickCheckoutButton();
    }

    @And("User clicks 'Continue to checkout' button")
    public void userClicksContinueToCheckoutButton() {
        identityPage.clickContinueToCheckoutButton();
    }

    @Then("User checks add to bag popup title is {string}")
    public void userChecksAddToBagPopupTitleIsTitle(final String expectedText) {
        shoppingBagPage = pageFactoryManager.getShoppingCartPage();
        shoppingBagPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, shoppingBagPage.getShoppingBagTitle());
        assertEquals(shoppingBagPage.getShoppingBagTitleAmountOfProducts(), expectedText);
    }

    @And("User clicks 'Save for later' on first product")
    public void userClicksSaveForLaterOnFirstProduct() {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.clickSaveForLaterIcon();
    }

    @And("User clicks 'Saved Items' button")
    public void userClicksSavedItemsButton() {
        searchResultsPage.clickSavedItems();
    }

    @And("User checks that amount of buttons is {int}")
    public void userChecksThatAmountOfButtonsIsAmountOfButtons(final int expectedText) {
        assertEquals(searchResultsPage.getMoveToBagButtonCount(), expectedText);
    }

    @When("User enters {string} page")
    public void userEntersWrongPage(final String url) {
        homePage.openPage(url);
    }

    @Then("^User checks message wrong page: (.*)")
    public void userChecksMessageWrongPage(final String expectedText) {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(startsWith(homePage.getMessageWrongPageText(), expectedText));
    }

    @And("User clicks My Account Icon")
    public void userClicksMyAccountIcon() {
        homePage.clickMyAccountIcon();
    }

    @And("User clicks Sign In Icon")
    public void userClicksSignInIcon() {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getSignInIcon());
        homePage.clickSignInIcon();
    }

    @When("User enters {string} to email address field")
    public void userEntersEmailToEmailAddressField(String email) {
        identityPage = pageFactoryManager.getIdentityPage();
        identityPage.enterTextToEmailField(email);
    }

    @And("User enters blank text to password field")
    public void userEntersBlankTextToPasswordField() {
        identityPage = pageFactoryManager.getIdentityPage();
        identityPage.enterBlankTextToPasswordField();
    }

    @Then("User checks that there is wrong email notification: {string}")
    public void userChecksThatThereIsNotification(final String expectedText) {
        assertTrue(startsWith(identityPage.getEmailErrorNotificationText(), expectedText));
    }

    @Then("User checks that there is empty password notification: {string}")
    public void userChecksThatThereIsEmptyPasswordNotification(final String expectedText) {
        assertEquals(identityPage.getPasswordErrorNotificationText(), expectedText);
    }

    @And("User checks bag icon visibility")
    public void userChecksCartVisibility() {
        homePage.isBagIconVisible();
    }

    @And("User checks saved items icon visibility")
    public void userChecksSavedItemsIconVisibility() {
        homePage.isSavedItemsIconVisible();
    }

    @And("User checks my account icon visibility")
    public void userChecksMyAccountIconVisibility() {
        homePage.isMyAccountIconVisible();
    }

    @And("User checks sign in icon visibility")
    public void userChecksSignInIconVisibility() {
        homePage.isSignInIconVisible();
    }

    @And("User checks join icon visibility")
    public void userChecksJoinIconVisibility() {
        homePage.isJoinIconVisible();
    }

    @Then("User checks Join tab visibility")
    public void userChecksJoinTabVisibility() {
        identityPage = pageFactoryManager.getIdentityPage();
        identityPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        identityPage.waitForAjaxToComplete(DEFAULT_TIMEOUT);
        identityPage.isJoinTabVisible();
    }

    @And("User checks email field visibility on sign in")
    public void userChecksEmailFieldVisibilityOnSignIn() {
        identityPage.isEmailFieldVisible();
    }

    @And("User checks password field visibility on sign in")
    public void userChecksPasswordFieldVisibilityOnSignIn() {
        identityPage.isPasswordFieldVisible();
    }

    @And("User checks SSO authentication links visibility")
    public void userChecksSSOAuthenticationLinksVisibility() {
        identityPage.isSsoLinksVisible();
    }
}
