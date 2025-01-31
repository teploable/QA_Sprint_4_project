package ru.yandex.praktikum;

import org.hamcrest.MatcherAssert;
import org.junit.After;
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


    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][] {
                {NAME_ALEXANDER, SURNAME_PUSHKIN, ADDRESS_UL_MOSKOVSKAYA, METRO_KRASNOSELSKAYA, PHONE_NUMBER_1, DATE_30, ONE_DAY_RENT, COLOUR_BLACK, COMMENT_POTATO},
                {NAME_KARL, SURNAME_BRYULLOV, ADDRESS_UL_ZHIVOPISNAYA, METRO_SOKOLNIKI, PHONE_NUMBER_2, DATE_31, TWO_DAYS_RENT, COLOUR_GREY, COMMENT_BIGMAC}
        };
    }

    @Test
    public void orderByButtonInHeader() {
        WebDriver driver = factory.getDriver();
        var objMainPage = new MainPage(driver);
        objMainPage.openMainPage();
        objMainPage.acceptCookiesMainPage();

        var objAboutCustomerPage = objMainPage.clickOrderButtonInHeader();
        objAboutCustomerPage.setAllAboutCustomerFields(name, surname, address, metroStationIndex, phoneNumber);

        var objAboutRentPage = objAboutCustomerPage.clickButtonFurther();
        objAboutRentPage.setALlAboutRentFields(date, rentalPeriod, scooterColour, comment);
        objAboutRentPage.clickOrderButton();
        objAboutRentPage.clickAgreeButton();

        String text = objAboutRentPage.getTextSuccessfulOrder();
        MatcherAssert.assertThat(text, startsWith(EXPECTED_CONFIRMATION_TEXT));

    }

    @Test
    public void orderByButtonUnderRoadMap() {
        WebDriver driver = factory.getDriver();

        var objMainPage = new MainPage(driver);
        objMainPage.openMainPage();
        objMainPage.acceptCookiesMainPage();
        objMainPage.scrollToOrderButtonUnderRoadMap();

        var objAboutCustomerPage = objMainPage.clickOrderButtonUnderRoadMap();
        objAboutCustomerPage.setAllAboutCustomerFields(name, surname, address, metroStationIndex, phoneNumber);

        var objAboutRentPage = objAboutCustomerPage.clickButtonFurther();
        objAboutRentPage.setALlAboutRentFields(date, rentalPeriod, scooterColour, comment);
        objAboutRentPage.clickOrderButton();
        objAboutRentPage.clickAgreeButton();

        String text = objAboutRentPage.getTextSuccessfulOrder();
        MatcherAssert.assertThat(text, startsWith(EXPECTED_CONFIRMATION_TEXT));
    }

    @After
    public void tearDown() {
        WebDriver driver = factory.getDriver();
        driver.quit();
    }
}