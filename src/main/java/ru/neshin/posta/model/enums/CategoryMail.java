package ru.neshin.posta.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public enum CategoryMail {

    SIMPLE("Простое"),
    ORDERED("Заказное"),
    ORDINARY("Обыкновенное"),
    WITH_DECLARED_VALUE("С объявленной ценностью"),
    WITH_DECLARED_VALUE_AND_CASH_ON_DELIVERY("С объявленной ценностью и наложенным платежом"),
    WITH_DECLARED_VALUE_AND_COMPULSORY_PAYMENT("С объявленной ценностью и обязательным платежом"),
    WITH_COMPULSORY_PAYMENT("С обязательным платежом");

    @Getter
    @Setter
    private String title;
}
