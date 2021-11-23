package store.page_object;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class SearchResultsPage {

    private ElementsCollection searchedItems = $$x("//img[contains(@class, 'img-responsive') and @itemprop]");
    private SelenideElement pageTitle = $x("//span[@class='navigation_page' and text()='Search']");
    private SelenideElement alertBlock = $x("//p[contains(@class, 'alert-warning')]");

    @Step("Verify search result page is opened")
    public void searchResultIsOpened() {
        pageTitle.shouldBe(visible);
    }

    @Step("Verify products: {0}")
    public void verifyItems(String items) {
        for (int i = 0; i < searchedItems.size(); i++) {
            searchedItems.get(i).shouldHave(attributeMatching("title", ".*" + items + ".*"));
        }
    }

    @Step("Verify items not found")
    public void itemsNotfound(String searchedItem) {
        alertBlock.shouldHave(text("No results were found for your search \"" + searchedItem + "\""));
    }
}
