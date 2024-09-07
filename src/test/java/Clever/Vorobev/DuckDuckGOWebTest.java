package Clever.Vorobev;

import Clever.Vorobev.data.Language;
import com.codeborne.selenide.CollectionCondition;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class DuckDuckGOWebTest {

    @BeforeEach
    void setUp() {
        open("https://www.duckduckgo.com/");
    }

    @ValueSource(strings = {
            "Selenide", "Junit 5"
    })
    @ParameterizedTest(name = "Для поискового запроса {0} должен отдаваться не пустой список")
    @Tag("BLOCKER")
    void searchResultsShouldNotBeEmpty(String searchQuery) {
        $("#searchbox_input").setValue(searchQuery).pressEnter();
        $$("[data-testid=\"mainline\"] li[data-layout=\"organic\"]")
                .shouldBe(CollectionCondition.sizeGreaterThan(0));
    }

    @CsvSource(value = {
            "Selenide , https://selenide.org",
            "Junit 5  , https://junit.org"
    })
    @ParameterizedTest(name = "Для поискового запроса {0} в первой карточке должна быть ссылка {1}")
    @Tag("BLOCKER")
    void searchResultsShouldContainExpectedUrl(String searchQuery, String expectedLink) {
        $("#searchbox_input").setValue(searchQuery).pressEnter();
        $("[data-testid='mainline'] li[data-layout='organic']")
                .shouldHave(text(expectedLink));
    }


    @Test
    @Tag("BLOCKER")
    @DisplayName("Для поискового запроса 'selenide' должен отдаваться не пустой список фото")
    void successfulSearchPhotoTest () {
        $("#searchbox_input").setValue("selenide").pressEnter();
        $("[href=\"/?t=h_&q=selenide&ia=images&iax=images\"]").click();
        $$("img.tile--img__img")
                .shouldBe(CollectionCondition.sizeGreaterThan(0));
    }
}
