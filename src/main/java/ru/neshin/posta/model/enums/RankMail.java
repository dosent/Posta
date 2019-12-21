package ru.neshin.posta.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public enum RankMail {
    WO_RANK("Без разряда"),
    GOVERNMENTAL("Правительственное"),
    MILITARY("Воинское"),
    OFFICIAL("Служебное"),
    JUDICIAL("Судебное"),
    PRESIDENTIAL("Президентское"),
    CREDIT("Кредитное"),
    ADMINISTRATIVE("Административное");

    @Getter
    @Setter
    private String title;
}
