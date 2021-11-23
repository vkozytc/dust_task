package store.page_object;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;

public class CartPage {

    private SelenideElement currentTab = $x("//li[contains(@class,'second')]/span");

    @Step("Verify cart page is opened")
    public void verifyCartPageIsOpened() {
        $x("//h1[contains(text(), 'Shopping-cart summary')]").shouldBe(visible);
        $x("//ul[@id='order_step']").shouldBe(visible);
    }

    @Step("Click proceed to checkout: {0}")
    public void verifyAddedItemOnCartPage(String itemName) {
        $x("//td/p[@class='product-name']/a").shouldHave(matchesText(itemName));
    }

    @Step("Verify authentication tab is opened")
    public void verifyAuthenticationTab() {
        $x("//h1[text()='Authentication']").shouldBe(visible);
        currentTab.shouldHave(matchesText("Sign in"));
    }

    @Step("Click proceed to checkout")
    public void clickProceedToCheckoutOnCartPage() {
        $x("//p/a[@title='Proceed to checkout']").click();
    }
}
