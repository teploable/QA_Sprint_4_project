package ru.yandex.praktikum.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;


public class AboutCustomerPage {
    private final WebDriver driver;

    private final By nameInputField = By.xpath(".//input[@placeholder='* Имя']");//Поле "Имя"
    private final By surnameInputField = By.xpath(".//input[@placeholder='* Фамилия']");//Поле "Фамилия"
    private final By addressInputField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");//Поле "Адрес: куда привезти самокат"
    private final By metroStationField = By.xpath(".//input[@placeholder='* Станция метро']");
    private final By phoneInputField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");//"Поле Телефон: на него позвонит курьер"
    private final By buttonNext = By.className("Button_Middle__1CSJM");//Кнопка "Далее" под формой "Для кого самокат"
    private final String dataValueMetro = ".//li[@data-value='";
    private final String dataValueMetroEnding = "']";


    public AboutCustomerPage(WebDriver driver) {
        this.driver = driver;
    }

    //Заполнить поле Имя
    public void setName(String name) {
        driver.findElement(nameInputField).sendKeys(name);
    }

    //Заполнить поле Фамилия
    public void setSurname(String surname) {
        driver.findElement(surnameInputField).sendKeys(surname);
    }

    //Заполнить поле Адрес
    public void setAddress(String address) {
        driver.findElement(addressInputField).sendKeys(address);
    }

    //Выбрать станцию метро
    public void selectMetro(String stationDataValue) {
        driver.findElement(metroStationField).click();
        driver.findElement(By.xpath(dataValueMetro + stationDataValue + dataValueMetroEnding)).click();
    }

    //Заполнить поле Телефон
    public void setPhoneNumber(String phoneNumber) {
        driver.findElement(phoneInputField).sendKeys(phoneNumber);
    }

    //Кликнуть на кнопку Далее
    public AboutRentPage clickButtonFurther() {
        driver.findElement(buttonNext).click();
        return new AboutRentPage(driver);
    }

    //Метод-шаг, заполняет все поля формы "Для кого самокат"
    public void setAllAboutCustomerFields (String name, String surname, String address, String metroStationIndex, String phoneNumber) {
        setName(name);
        setSurname(surname);
        setAddress(address);
        selectMetro(metroStationIndex);
        setPhoneNumber(phoneNumber);
    }
}