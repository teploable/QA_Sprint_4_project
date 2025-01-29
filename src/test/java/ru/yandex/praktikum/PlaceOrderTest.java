package ru.yandex.praktikum;

import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import static org.hamcrest.CoreMatchers.startsWith;

import ru.yandex.praktikum.pageObject.MainPage;
import static ru.yandex.praktikum.TestData.*;

@RunWith(Parameterized.class)
public class PlaceOrderTest {
    private final String name;
    private final String surname;
    private final String address;
    private final String metroStationIndex;
    private final String phoneNumber;
    private final String date;
    private final String rentalPeriod;
    private final String scooterColour;
    private final String comment;

    @Rule
    public DriverFactory factory = new DriverFactory();

    public PlaceOrderTest(String name, String surname, String address, String metroStationIndex, String phoneNumber, String date, String rentalPeriod, String scooterColour, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metroStationIndex = metroStationIndex;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.rentalPeriod = rentalPeriod;
        this.scooterColour = scooterColour;
        this.comment = comment;
    }

    @Before
    public void closeCookies() {
        WebDriver driver = factory.getDriver();
        var MainPage = new MainPage(driver);
        MainPage.openMainPage();
        MainPage.acceptCookiesMainPage();
    }

    @After
    public void tearDown() {
        WebDriver driver = factory.getDriver();
        driver.quit();
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][] {
                {NAME_1, SURNAME_1, ADDRESS_1, METRO_STATION_INDEX_1, PHONE_NUMBER_1, DATE_1, RENTAL_PERIOD_1, COLOUR_BLACK, COMMENT_1},
                {NAME_2, SURNAME_2, ADDRESS_2, METRO_STATION_INDEX_2, PHONE_NUMBER_2, DATE_2, RENTAL_PERIOD_2, COLOUR_GREY, COMMENT_2}
        };
    }

    @Test
    public void orderByButtonInHeader() {
        WebDriver driver = factory.getDriver();
        var mainPage = new MainPage(driver);

        var orderPageForWhom = mainPage.clickOrderButtonInHeader();
        orderPageForWhom.nameOrder(name);
        orderPageForWhom.surnameOrder(surname);
        orderPageForWhom.addressOrder(address);
        orderPageForWhom.selectMetro(metroStationIndex);
        orderPageForWhom.phoneOrder(phoneNumber);

        var orderPageAboutRent = orderPageForWhom.clickButtonLater();
        orderPageAboutRent.chooseDeliveryDate(date);
        orderPageAboutRent.chooseRentalPeriod(rentalPeriod);
        orderPageAboutRent.chooseColourCheckbox(scooterColour);
        orderPageAboutRent.typeComment(comment);
        orderPageAboutRent.clickOrderButton();
        orderPageAboutRent.clickAgreeButton();

        String text = orderPageAboutRent.getTextSuccessfulOrder();
        MatcherAssert.assertThat(text, startsWith(EXPECTED_CONFIRMATION_TEXT));

    }

    @Test
    public void orderByButtonUnderRoadMap() {
        WebDriver driver = factory.getDriver();
        var mainPage = new MainPage(driver);
        mainPage.scrollToOrderButtonUnderRoadMap();

        var orderPageForWhom = mainPage.clickOrderButtonUnderRoadMap();
        orderPageForWhom.nameOrder(name);
        orderPageForWhom.surnameOrder(surname);
        orderPageForWhom.addressOrder(address);
        orderPageForWhom.selectMetro(metroStationIndex);
        orderPageForWhom.phoneOrder(phoneNumber);

        var orderPageAboutRent = orderPageForWhom.clickButtonLater();
        orderPageAboutRent.chooseDeliveryDate(date);
        orderPageAboutRent.chooseRentalPeriod(rentalPeriod);
        orderPageAboutRent.chooseColourCheckbox(scooterColour);
        orderPageAboutRent.typeComment(comment);
        orderPageAboutRent.clickOrderButton();
        orderPageAboutRent.clickAgreeButton();

        String text = orderPageAboutRent.getTextSuccessfulOrder();
        MatcherAssert.assertThat(text, startsWith(EXPECTED_CONFIRMATION_TEXT));
    }
}