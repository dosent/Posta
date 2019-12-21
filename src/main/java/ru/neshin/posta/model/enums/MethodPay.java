package ru.neshin.posta.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public enum MethodPay {
    CASHLESS("Безналичный расчет"),
    STAMP("Оплата марками"),
    FRANKING("Франкирование"),
    TO_FRANKING("На франкировку"),
    ONLINE_PAYMENT_MARK("Знак онлайн оплаты");

    @Getter
    @Setter
    private String title;
}
