package ru.yandex.praktikum;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.assertEquals;

import ru.yandex.praktikum.pageObject.FaqBlockPage;
import static ru.yandex.praktikum.TestData.*;


@RunWith(Parameterized.class)
public class FaqTest {
    private final String headingIndex;
    private final String answerText;

    @ClassRule
    public static DriverFactory factory = new DriverFactory();

    public FaqTest(String headingIndex, String answerText) {
        this.headingIndex = headingIndex;
        this.answerText = answerText;
    }

    @BeforeClass
    public static void closeCookies() {
        WebDriver driver = factory.getDriver();
        var FaqPage = new FaqBlockPage(driver);
        FaqPage.openFaqPage();
        FaqPage.acceptCookiesFaqPage();
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][]{
                {QUESTION_ID_0, TEXT_ANSWER_0},
                {QUESTION_ID_1, TEXT_ANSWER_1},
                {QUESTION_ID_2, TEXT_ANSWER_2},
                {QUESTION_ID_3, TEXT_ANSWER_3},
                {QUESTION_ID_4, TEXT_ANSWER_4},
                {QUESTION_ID_5, TEXT_ANSWER_5},
                {QUESTION_ID_6, TEXT_ANSWER_6},
                {QUESTION_ID_7, TEXT_ANSWER_7}
        };
    }

    @Test
    public void checkFAQ() {
        WebDriver driver = factory.getDriver();
        var FaqPage = new FaqBlockPage(driver);
        FaqPage.clickOnQuestion(headingIndex);
        FaqPage.scrollToQuestionsHeader();
        FaqPage.waitAnswerToBeVisible(headingIndex);
        String text = FaqPage.getAnswerText(headingIndex);
        assertEquals(answerText, text);
    }

    @AfterClass
    public static void tearDown() {
        WebDriver driver = factory.getDriver();
        driver.quit();
    }
}