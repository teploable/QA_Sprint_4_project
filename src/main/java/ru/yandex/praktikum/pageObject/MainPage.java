package ru.yandex.praktikum.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static ru.yandex.praktikum.TestData.*;

public class MainPage {
    private final WebDriver driver;

    private final By orderButtonInHeader = By.className("Button_Button__ra12g");//Кнопка "Заказать" в хеддере страницы
    private final By orderButtonUnderRoadMap = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");//Кнопка "Заказать" под шагами
    private final By acceptCookiesButton = By.id("rcc-confirm-button");//Кнопка "да все привыкли" чтобы согласиться с cookies
    private final By questionsHeader = By.className("Home_FourPart__1uthg");//Заголовок с вопросами
    private final String questionsAccordionHeading = "accordion__heading-";//Базовое наименование класса вопроса без индекса
    private final String answerAccordionPanel = "accordion__panel-";//Базовое наименование класса ответа без индекса

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //Метод открывает главную страницу
    public void openMainPage() {
        driver.get(BASE_URL);
    }

    //Метод соглашается с cookies, чтобы скрыть плавающий элемент
    public MainPage acceptCookiesMainPage() {
        driver.findElement(acceptCookiesButton).click();
        return this;
    }

    //Метод кликает на кнопку "Заказать", расположенную в хеддере страницы
    public AboutCustomerPage clickOrderButtonInHeader() {
        driver.findElement(orderButtonInHeader).click();
        return new AboutCustomerPage(driver);
    }

    //Скролл до кнопки "Заказать", расположенной под шагами
    public void scrollToOrderButtonUnderRoadMap() {
        WebElement element = driver.findElement(orderButtonUnderRoadMap);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    //Метод кликает на кнопку "Заказать", расположенную под шагами
    public AboutCustomerPage clickOrderButtonUnderRoadMap() {
        driver.findElement(orderButtonUnderRoadMap).click();
        return new AboutCustomerPage(driver);
    }

    //Скролл до заголовка с вопросами
    public void scrollToQuestionsHeader() {
        WebElement element = driver.findElement(questionsHeader);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    //Клик на вопрос
    public MainPage clickOnQuestion(String index) {
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT))
                .until(ExpectedConditions.elementToBeClickable(By.id(questionsAccordionHeading + index)));
        driver.findElement(By.id(questionsAccordionHeading + index)).click();
        return this;
    }

    //Ожидание появления ответа на вопрос
    public MainPage waitAnswerToBeVisible(String index) {
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id(answerAccordionPanel + index)));
        return this;
    }

    //Получить текст ответа на вопрос
    public String getAnswerText(String index){
        return
                driver.findElement(By.id(answerAccordionPanel + index)).getText();
    }

}