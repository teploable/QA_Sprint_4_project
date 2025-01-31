package ru.yandex.praktikum;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

import ru.yandex.praktikum.pageObject.MainPage;
import static ru.yandex.praktikum.TestData.*;


@RunWith(Parameterized.class)
public class FaqTest {
    private final String headingIndex;
    private final String answerText;

    @Before
    public void closeCookies() {
        WebDriver driver = factory.getDriver();
        var objMainPage = new MainPage(driver);
        objMainPage.openMainPage();
        objMainPage.acceptCookiesMainPage();
    }

    @Rule
    public DriverFactory factory = new DriverFactory();

    public FaqTest(String headingIndex, String answerText) {
        this.headingIndex = headingIndex;
        this.answerText = answerText;
    }


    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][]{
                {QUESTION_PAYMENT, ANSWER_PAYMENT},
                {QUESTION_QUANTITY_SCOOTERS_RENT, ANSWER_QUANTITY_SCOOTERS_RENT},
                {QUESTION_CALCULATION_RENTAL_TIME, ANSWER_CALCULATION_RENTAL_TIME},
                {QUESTION_RENT_TODAY, ANSWER_RENT_TODAY},
                {QUESTION_PROLONG_AND_RETURN, ANSWER_PROLONG_AND_RETURN},
                {QUESTION_CHARGER, ANSWER_CHARGER},
                {QUESTION_ORDER_CANCELLATION, ANSWER_ORDER_CANCELLATION},
                {QUESTION_ORDER_OUT_MKAD, ANSWER_ORDER_OUT_MKAD},
        };
    }

    @Test
    public void checkFAQ() {
        WebDriver driver = factory.getDriver();
        var objMainPage = new MainPage(driver);
        objMainPage.openMainPage();
        objMainPage.scrollToQuestionsHeader();
        objMainPage.clickOnQuestion(headingIndex);
        objMainPage.waitAnswerToBeVisible(headingIndex);
        String text = objMainPage.getAnswerText(headingIndex);
        assertEquals(answerText, text);
    }

    @After
    public void tearDown() {
        WebDriver driver = factory.getDriver();
        driver.quit();
    }
}