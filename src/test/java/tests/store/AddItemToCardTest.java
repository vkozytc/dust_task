package tests.store;

import core.LogListener;
import io.qameta.allure.Feature;
import store.Utils;
import store.page_object.HomePage;
import store.page_object.SearchResultsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import tests.BaseTest;

import static com.codeborne.selenide.Selenide.open;

@Feature("Add item")
@Listeners({LogListener.class})
public class AddItemToCardTest extends BaseTest {

    private HomePage homePage;
    private Utils utils;
    private final String itemName = "Blouse";

    @BeforeMethod
    public void openLogin() {
        open("/");
        homePage = new HomePage();
        utils = new Utils();
        homePage.verifyHomePageIsOpened();
    }

    @Test(description = "Check add item to cart from search results")
    public void checkAddItemFromSearchPage() {
        SearchResultsPage searchResultsPage = new SearchResultsPage();
        homePage.searchItemByValue(itemName);
        searchResultsPage.searchResultIsOpened();
        searchResultsPage.verifyItems(itemName);
        utils.addItemToCartByName(itemName);
    }

    @Test(description = "Check add item to cart from home page")
    public void checkAddItemFromMainPage() {
        utils.addItemToCartByName(itemName);
    }
}
