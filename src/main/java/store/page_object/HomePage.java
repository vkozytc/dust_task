package store.page_object;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.*;

public class HomePage {

    private SelenideElement searchField = $(byAttribute("id", "search_query_top"));
    private SelenideElement submitSearchField = $x(".//button[@name='submit_search']");
    private SelenideElement loginButton = $x("//a[@class='login']");

    @Step("Search item by value: {0}")
    public void searchItemByValue(String value) {
        searchField.setValue(value);
        submitSearchField.click();
    }

    @Step("Search item by value: {0}")
    public void verifyHomePageIsOpened() {
        searchField.shouldBe(visible);
        loginButton.shouldBe(visible);
        $x("//div[@id='block_top_menu']").shouldBe(visible);
        $x("//div[@id='center_column']").shouldBe(visible);
    }
}
