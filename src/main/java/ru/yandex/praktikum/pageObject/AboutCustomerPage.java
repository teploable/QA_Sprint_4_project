package ru.yandex.praktikum.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class AboutCustomerPage {
    private final WebDriver driver;

    protected final By nameInputField = By.xpath(".//input[@placeholder='* Имя']");//Поле "Имя"
    protected final By surnameInputField = By.xpath(".//input[@placeholder='* Фамилия']");//Поле "Фамилия"
    protected final By addressInputField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");//Поле "Адрес: куда привезти самокат"
    protected final By metroStationField = By.className("select-search__input");//Поле "Станция метро"
    protected final By phoneInputField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");//"Поле Телефон: на него позвонит курьер"
    protected final By buttonNext = By.className("Button_Middle__1CSJM");//Кнопка "Далее" под формой "Для кого самокат"

    public AboutCustomerPage(WebDriver driver) {
        this.driver = driver;
    }

    //Заполнить поле Имя
    public void nameOrder(String name) {
        driver.findElement(nameInputField).sendKeys(name);
    }

    //Заполнить поле Фамилия
    public void surnameOrder(String surname) {
        driver.findElement(surnameInputField).sendKeys(surname);
    }

    //Заполнить поле Адрес
    public void addressOrder(String address) {
        driver.findElement(addressInputField).sendKeys(address);
    }

    //Выбрать станцию метро
    public void selectMetro(String metroStationIndex) {
        driver.findElement(metroStationField).click();
        driver.findElement(By.xpath(".//li[@data-index='" + metroStationIndex + "']")).click();
    }

    //Заполнить поле Телефон
    public void phoneOrder(String phoneNumber) {
        driver.findElement(phoneInputField).sendKeys(phoneNumber);
    }

    //Кликнуть на кнопку Далее
    public AboutRentPage clickButtonLater() {
        driver.findElement(buttonNext).click();
        return new AboutRentPage(driver);
    }
}