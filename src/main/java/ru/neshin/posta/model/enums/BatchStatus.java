package ru.neshin.posta.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public enum BatchStatus {
    CREATED("Партия создана"),
    FROZEN("Партия в процессе приема, редактирование запрещено"),
    ACCEPTED("Партия принята в отделении связи"),
    SENT("По заказам в партии существуют данные в сервисе трекинга"),
    ARCHIVED("Партия находится в архиве");

    @Getter
    @Setter
    private String title;

}
