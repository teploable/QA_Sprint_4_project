package ru.yandex.praktikum.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static ru.yandex.praktikum.TestData.BASE_URL;

public class MainPage {
    private final WebDriver driver;

    protected final By orderButtonInHeader = By.className("Button_Button__ra12g");//Кнопка "Заказать" в хеддере страницы
    protected final By orderButtonUnderRoadMap = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");//Кнопка "Заказать" под шагами
    protected final By acceptCookiesButton = By.id("rcc-confirm-button");//Кнопка "да все привыкли" чтобы согласиться с cookies

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

}