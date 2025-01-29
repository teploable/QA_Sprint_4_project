package ru.yandex.praktikum;

public class TestData {
    //URL главной страницы Яндекс Самокат
    public static final String BASE_URL = "https://qa-scooter.praktikum-services.ru/";

    //Время ожидания по умолчанию
    public static final int EXPLICIT_WAIT = 8;

    //ID вопросов: accordion__heading-[QUESTION_ID_N]
    public static final String QUESTION_ID_0 = "0";
    public static final String QUESTION_ID_1 = "1";
    public static final String QUESTION_ID_2 = "2";
    public static final String QUESTION_ID_3 = "3";
    public static final String QUESTION_ID_4 = "4";
    public static final String QUESTION_ID_5 = "5";
    public static final String QUESTION_ID_6 = "6";
    public static final String QUESTION_ID_7 = "7";

    //Ожидаемый текст ответов на вопросы
    public static final String TEXT_ANSWER_0 = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    public static final String TEXT_ANSWER_1 = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    public static final String TEXT_ANSWER_2 = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    public static final String TEXT_ANSWER_3 = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    public static final String TEXT_ANSWER_4 = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    public static final String TEXT_ANSWER_5 = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    public static final String TEXT_ANSWER_6 = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    public static final String TEXT_ANSWER_7 = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

    //Тестовые данные для заполнения форм "Для кого" и "Про аренду"
    //Имя
    public static final String NAME_1 = "Александр";
    public static final String NAME_2 = "Карл";
    //Фамилия
    public static final String SURNAME_1 = "Пушкин";
    public static final String SURNAME_2 = "Брюллов";
    //Адрес
    public static final String ADDRESS_1 = "ул. Московская, д. 16";
    public static final String ADDRESS_2 = "ул. Живописная, д.5";
    //Станция метро
    public static final String METRO_STATION_INDEX_1 = "5";
    public static final String METRO_STATION_INDEX_2 = "6";
    //Телефон
    public static final String PHONE_NUMBER_1 = "+79998887766";
    public static final String PHONE_NUMBER_2 = "+79995554433";
    //Дата доставки
    public static final String DATE_1 = "30";
    public static final String DATE_2 = "31";
    //Срок аренды
    public static final String RENTAL_PERIOD_1 = "сутки";
    public static final String RENTAL_PERIOD_2 = "двое суток";
    //Цвета самокатов
    public static final String COLOUR_BLACK = "black";
    public static final String COLOUR_GREY = "grey";
    //Комментарий для курьера
    public static final String COMMENT_1 = "Захватите картошку фри";
    public static final String COMMENT_2 = "Захватите бигмак";

    //Ожидаемый текст при успешно оформленном заказе самоката
    public static final String EXPECTED_CONFIRMATION_TEXT = "Заказ оформлен";
}