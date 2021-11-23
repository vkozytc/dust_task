package tests.store;

import core.LogListener;
import io.qameta.allure.Feature;
import store.Utils;
import store.page_object.CartPage;
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
public class CreateOrderForUnregisteredUserTest extends BaseTest {

    private HomePage homePage;
    private CartPage cartPage;
    private Utils utils;
    private final String itemName = "Blouse";

    @BeforeMethod
    public void openHomePage() {
        open("/");
        homePage = new HomePage();
        utils = new Utils();
        cartPage = new CartPage();
        homePage.verifyHomePageIsOpened();
    }

    @Test(description = "Check create order for unregistered user")
    public void createOrderForUnregisteredUserTest() {
        utils.addItemToCartByName(itemName);
        utils.clickProceedToCheckout();
        cartPage.verifyCartPageIsOpened();
        cartPage.verifyAddedItemOnCartPage(itemName);
        cartPage.clickProceedToCheckoutOnCartPage();
        cartPage.verifyAuthenticationTab();
    }
}
