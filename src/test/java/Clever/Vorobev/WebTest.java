package Clever.Vorobev;

import com.codeborne.selenide.CollectionCondition;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class WebTest {

    @BeforeEach
    void setUp() {
        open("https://www.duckduckgo.com/");
    }

    @Test
    @Tag("BLOCKER")
    @DisplayName("Для поискового запроса 'seleinde' должен отдаваться не пустой список")
    void successfulSearchTest() {
        $("#searchbox_input").setValue("selenide").pressEnter();
        $$("[data-testid=\"mainline\"] li[data-layout=\"organic\"]")
                .shouldBe(CollectionCondition.sizeGreaterThan(0));
    }

    @Test
    @Tag("BLOCKER")
    @DisplayName("Для поискового запроса 'selenide' должен отдаваться не пустой список фото")
    void successfulSearchPhotoTest() {
        $("#searchbox_input").setValue("selenide").pressEnter();
        $("[href=\"/?t=h_&q=selenide&ia=images&iax=images\"]").click();
        $$("img.tile--img__img")
                .shouldBe(CollectionCondition.sizeGreaterThan(0));
    }
}
