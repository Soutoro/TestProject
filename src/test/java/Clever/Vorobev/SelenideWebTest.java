package Clever.Vorobev;

import Clever.Vorobev.data.Language;
import com.codeborne.selenide.CollectionCondition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.awt.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


public class SelenideWebTest {

    @EnumSource(Language.class)
    @ParameterizedTest
    void selenideSiteShouldDisplayCorrectTest(Language language) {
        open("https://ru.selenide.org/");
        $$("#languages a").find(text(language.name())).click();
        $("h3").shouldHave(text(language.description));
    }
}
