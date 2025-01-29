package ru.yandex.praktikum.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AboutRentPage {
    private final WebDriver driver;

    protected final By dateInputField = By.className("react-datepicker__input-container");//Поле "Когда привезти самокат"
    protected final By rentalPeriod = By.className("Dropdown-root");//Поле "Когда привезти самокат"
    protected final By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");//Поле "Комментарий для курьера"
    protected final By orderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");//Кнопка "Заказать" под формой "Про аренду"
    protected final By agreeButton = By.xpath(".//div[@class='Order_Modal__YZ-d3']/div[@class='Order_Buttons__1xGrp']/button[text()='Да']");//Кнопка "Да" при подтверждении заказа
    protected final By orderPlacedSuccessfullyPopup = By.className("Order_ModalHeader__3FDaJ");//Попап с сообщением об успешно оформленном заказе

    public AboutRentPage(WebDriver driver) {
        this.driver = driver;
    }

    //Выбрать дату доставки самоката
    public void chooseDeliveryDate(String date) {
        driver.findElement(dateInputField).click();
        driver.findElement(By.xpath(".//div[contains(@class,'react-datepicker__day--0" + date +"')]")).click();
    }

    //Выбрать срок аренды
    public void chooseRentalPeriod(String rentalPeriod) {
        driver.findElement(this.rentalPeriod).click();
        driver.findElement(By.xpath(".//div[@class='Dropdown-option' and text()='" + rentalPeriod + "']")).click();
    }

    //Выбрать цвет самоката
    public void chooseColourCheckbox(String colour) {
        driver.findElement(By.xpath(".//label[@for='" + colour + "']")).click();
    }

    //Заполнить поле Комментарий для курьера
    public void typeComment(String comment) {
        driver.findElement(commentField).sendKeys(comment);
    }

    //Клик на кнопку "Заказать"
    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    //Клик на кнопку "Да" при подтверждении заказа
    public void clickAgreeButton() {
        driver.findElement(agreeButton).click();
    }

    //Получить текст подтверждения успешно оформленного заказа
    public String getTextSuccessfulOrder() {
        return
                driver.findElement(orderPlacedSuccessfullyPopup).getText();
    }
}