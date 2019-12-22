package ru.neshin.posta.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public enum TransportType {

    SURFACE	("Наземный"),
    AVIA	("Авиа"),
    COMBINED	("Комбинированный"),
    EXPRESS	("Системой ускоренной почты"),
    STANDARD	("Используется для отправлений \"EMS Оптимальное\"");

    @Getter
    @Setter
    private String title;
}
