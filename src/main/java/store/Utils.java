package store;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class Utils {

    @Step("Add item to cart by name: {0}")
    public void addItemToCartByName(String itemName) {
        ElementsCollection items = $$x("//img[contains(@class, 'img-responsive') and contains(@title, '" + itemName + "')]");
        items.first().hover().$x("ancestor::div[@class='product-container']/descendant::a[contains(@class, 'add_to_cart_button')]").click();
        $x("//div[contains(@class,'layer_cart_product')]").shouldBe(Condition.visible);
    }

    @Step("Click proceed to checkout")
    public void clickProceedToCheckout() {
        $x("//a[@title='Proceed to checkout']").click();
    }
}
