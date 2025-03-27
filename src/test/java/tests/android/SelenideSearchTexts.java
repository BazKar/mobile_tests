package tests.android;

import io.appium.java_client.AppiumBy;

import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class SelenideSearchTexts extends TestBase{

    @Test
    void successSearchTest() {

        $(AppiumBy.accessibilityId("Search Wikipedia")).click();
        $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Java");
        $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_description")).shouldHave(sizeGreaterThan(0));
    }
}
