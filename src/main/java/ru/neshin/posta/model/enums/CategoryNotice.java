package ru.neshin.posta.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public enum CategoryNotice {

    SIMPLE("Простое"),
    ORDERED("Заказное"),
    ORDINARY("Обыкновенное");

    @Getter
    @Setter
    private String title;
}
