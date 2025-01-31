//package ru.yandex.praktikum.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static ru.yandex.praktikum.TestData.*;

//public class FaqBlockPage {
//    private final WebDriver driver;
//    private final By acceptCookiesButton = By.id("rcc-confirm-button");//Кнопка "да все привыкли" чтобы согласиться с cookies
//    private final By questionsHeader = By.className("Home_FourPart__1uthg");//Заголовок с вопросами
//    private final String questionsAccordionHeading = "accordion__heading-";//Базовое наименование класса вопроса без индекса
//   private final String answerAccordionPanel = "accordion__panel-";//Базовое наименование класса ответа без индекса

//    public FaqBlockPage(WebDriver driver) {
//        this.driver = driver;
//    }

    //Метод открывает главную страницу
//    public FaqBlockPage openFaqPage() {
//        driver.get(BASE_URL);
//        return this;
//    }

    //Метод соглашается с cookies, чтобы скрыть плавающий элемент
//    public FaqBlockPage acceptCookiesFaqPage() {
//        driver.findElement(acceptCookiesButton).click();
//        return this;
//    }

    //Скролл до заголовка с вопросами
//    public void scrollToQuestionsHeader() {
//        WebElement element = driver.findElement(questionsHeader);
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
//    }

    //Клик на вопрос
//    public FaqBlockPage clickOnQuestion(String index) {
//        driver.findElement(By.id(questionsAccordionHeading + index)).click();
//        return this;
//    }

    //Ожидание появления ответа на вопрос
//    public FaqBlockPage waitAnswerToBeVisible(String index) {
//        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT))
//                .until(ExpectedConditions.visibilityOfElementLocated(By.id(answerAccordionPanel + index)));
//        return this;
//    }

    //Получить текст ответа на вопрос
//    public String getAnswerText(String index){
//        return
//                driver.findElement(By.id(answerAccordionPanel + index)).getText();
//    }
//}