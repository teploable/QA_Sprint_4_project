package ru.yandex.praktikum.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AboutRentPage {
    private final WebDriver driver;

    private final By dateInputField = By.className("react-datepicker__input-container");//Поле "Когда привезти самокат"
    private final By rentalPeriod = By.className("Dropdown-root");//Поле "Когда привезти самокат"
    private final By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");//Поле "Комментарий для курьера"
    private final By orderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");//Кнопка "Заказать" под формой "Про аренду"
    private final By agreeButton = By.xpath(".//div[@class='Order_Modal__YZ-d3']/div[@class='Order_Buttons__1xGrp']/button[text()='Да']");//Кнопка "Да" при подтверждении заказа
    private final By orderPlacedSuccessfullyPopup = By.className("Order_ModalHeader__3FDaJ");//Попап с сообщением об успешно оформленном заказе
    private final String reactDatePicker = ".//div[contains(@class,'react-datepicker__day--0";//Начало Xpath кнопки с датой в календаре "Когда привезти заказ"
    private final String reactDatePickerEnding = "')]";//Конец Xpath кнопки с датой в календаре "Когда привезти заказ"
    private final String dateDropDown = ".//div[@class='Dropdown-option' and text()='";//Начало Xpath пункта из выпадающего списка "Срок аренды"
    private final String dateDropDownEnding = "']";//Конец Xpath пункта из выпадающего списка "Срок аренды"
    private final String colourLabel = ".//label[@for='";//Начало Xpath пункта чекбокса "Цвет самоката"
    private final String colourLabelEnding = "']";//Окончание Xpath пункта чекбокса "Цвет самоката"

    public AboutRentPage(WebDriver driver) {
        this.driver = driver;
    }

    //Выбрать дату доставки самоката
    public void setDeliveryDate(String date) {
        driver.findElement(dateInputField).click();
        driver.findElement(By.xpath(reactDatePicker + date + reactDatePickerEnding)).click();
    }

    //Выбрать срок аренды
    public void setRentalPeriod(String rentalPeriod) {
        driver.findElement(this.rentalPeriod).click();
        driver.findElement(By.xpath(dateDropDown + rentalPeriod + dateDropDownEnding)).click();
    }

    //Выбрать цвет самоката
    public void setScooterColour(String colour) {
        driver.findElement(By.xpath(colourLabel + colour + colourLabelEnding)).click();
    }

    //Заполнить поле Комментарий для курьера
    public void setComment(String comment) {
        driver.findElement(commentField).sendKeys(comment);
    }

    //Метод-шаг, заполняет все поля формы "Про аренду"
    public void setALlAboutRentFields(String date, String rentalPeriod, String colour, String comment) {
        setDeliveryDate(date);
        setRentalPeriod(rentalPeriod);
        setScooterColour(colour);
        setComment(comment);

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