package tests.store;

import core.LogListener;
import io.qameta.allure.Feature;
import store.page_object.HomePage;
import store.page_object.SearchResultsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import tests.BaseTest;

import static com.codeborne.selenide.Selenide.open;

@Feature("Search feature")
@Listeners({LogListener.class})
public class SearchTest extends BaseTest {

    private HomePage homePage;
    private SearchResultsPage searchResultsPage;

    @BeforeMethod
    public void openHomePage() {
        open("/");
        homePage = new HomePage();
        searchResultsPage = new SearchResultsPage();
        homePage.verifyHomePageIsOpened();
    }

    @Test(description = "Check Search results", dataProvider = "validValue")
    public void checkSearchWithValidValueTest(String itemName) {
        homePage.searchItemByValue(itemName);
        searchResultsPage.searchResultIsOpened();
        searchResultsPage.verifyItems(itemName);
    }

    @Test(description = "Check Search results", dataProvider = "invalidValue")
    public void checkSearchWithInvalidValueTest(String itemName) {
        homePage.searchItemByValue(itemName);
        searchResultsPage.searchResultIsOpened();
        searchResultsPage.itemsNotfound(itemName);
    }

    @DataProvider(name = "validValue")
    public static Object[][] validValueProvider() {
        return new Object[][]{
                {"Blouse"},
                {"Printed"},
                {"T-shirts"}
        };
    }

    @DataProvider(name = "invalidValue")
    public static Object[][] invalidValueProvider() {
        return new Object[][]{
                {"sssc"},
                {"Printed"},
                {"35536"}
        };
    }
}
