package ru.yandex.praktikum;

public class TestData {
    //URL главной страницы Яндекс Самокат
    public static final String BASE_URL = "https://qa-scooter.praktikum-services.ru/";

    //Время ожидания по умолчанию
    public static final int EXPLICIT_WAIT = 10;

    //ID вопросов: accordion__heading-[QUESTION_ID_N]
    public static final String QUESTION_PAYMENT = "0";
    public static final String QUESTION_QUANTITY_SCOOTERS_RENT = "1";
    public static final String QUESTION_CALCULATION_RENTAL_TIME = "2";
    public static final String QUESTION_RENT_TODAY = "3";
    public static final String QUESTION_PROLONG_AND_RETURN = "4";
    public static final String QUESTION_CHARGER = "5";
    public static final String QUESTION_ORDER_CANCELLATION = "6";
    public static final String QUESTION_ORDER_OUT_MKAD = "7";

    //Ожидаемый текст ответов на вопросы
    public static final String ANSWER_PAYMENT = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    public static final String ANSWER_QUANTITY_SCOOTERS_RENT = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    public static final String ANSWER_CALCULATION_RENTAL_TIME = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    public static final String ANSWER_RENT_TODAY = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    public static final String ANSWER_PROLONG_AND_RETURN = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    public static final String ANSWER_CHARGER = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    public static final String ANSWER_ORDER_CANCELLATION = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    public static final String ANSWER_ORDER_OUT_MKAD = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

    //Тестовые данные для заполнения форм "Для кого" и "Про аренду"
    //Имя
    public static final String NAME_ALEXANDER = "Александр";
    public static final String NAME_KARL = "Карл";
    //Фамилия
    public static final String SURNAME_PUSHKIN = "Пушкин";
    public static final String SURNAME_BRYULLOV = "Брюллов";
    //Адрес
    public static final String ADDRESS_UL_MOSKOVSKAYA = "ул. Московская, д. 16";
    public static final String ADDRESS_UL_ZHIVOPISNAYA = "ул. Живописная, д.5";
    //Станция метро
    public static final String METRO_KRASNOSELSKAYA = "5";
    public static final String METRO_SOKOLNIKI = "4";
    //Телефон
    public static final String PHONE_NUMBER_1 = "+79998887766";
    public static final String PHONE_NUMBER_2 = "+79995554433";
    //Дата доставки
    public static final String DATE_30 = "30";
    public static final String DATE_31 = "31";
    //Срок аренды
    public static final String ONE_DAY_RENT = "сутки";
    public static final String TWO_DAYS_RENT = "двое суток";
    //Цвета самокатов
    public static final String COLOUR_BLACK = "black";
    public static final String COLOUR_GREY = "grey";
    //Комментарий для курьера
    public static final String COMMENT_POTATO = "Захватите картошку фри";
    public static final String COMMENT_BIGMAC = "Захватите бигмак";

    //Ожидаемый текст при успешно оформленном заказе самоката
    public static final String EXPECTED_CONFIRMATION_TEXT = "Заказ оформлен";
}