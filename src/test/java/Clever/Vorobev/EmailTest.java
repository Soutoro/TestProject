package Clever.Vorobev;

import org.junit.jupiter.api.*;

@DisplayName("Тесты на email рассылку")
public class EmailTest {

    @Test
    @Tag("SMOKE")
    @DisplayName("Email должен быть отправлен новому юзеру")
    void emailShouldbeSetForNewUser(){
        System.out.println("Hello world!");
    }

    @Test
    @Tags({
            @Tag("SMOKE"),
            @Tag("WEB"),
    })
    @DisplayName("Email должен быть отправлен забаненому юзеру")
    void emailShouldbeSetForBannedUser(){
        System.out.println("Hello world!");
    }

    @Disabled("Айдишник задачи")
    @Test
    @DisplayName("Email должен быть отправлен при изменении PaymentMethod")
    void emailShouldbeSetAfterChangePaymentMethod(){
        throw new AssertionError("Падаем!");
    }
}
