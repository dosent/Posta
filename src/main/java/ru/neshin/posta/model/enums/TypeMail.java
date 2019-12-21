package ru.neshin.posta.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public enum TypeMail {
    POSTAL_PARCEL	("Посылка \"нестандартная\""),
    ONLINE_PARCEL	("Посылка \"онлайн\""),
    ONLINE_COURIER	("Курьер \"онлайн\""),
    EMS	("Отправление EMS"),
    EMS_OPTIMAL	("EMS оптимальное"),
    EMS_RT	("EMS РТ"),
    EMS_TENDER	("EMS тендер"),
    LETTER	("Письмо"),
    LETTER_CLASS_1	("Письмо 1-го класса"),
    BANDEROL	("Бандероль"),
    BUSINESS_COURIER	("Бизнес курьер"),
    BUSINESS_COURIER_ES	("Бизнес курьер экпресс"),
    PARCEL_CLASS_1	("Посылка 1-го класса"),
    BANDEROL_CLASS_1	("Бандероль 1-го класса"),
    VGPO_CLASS_1	("ВГПО 1-го класса"),
    SMALL_PACKET	("Мелкий пакет"),
    EASY_RETURN	("Легкий возврат"),
    VSD	("Отправление ВСД"),
    ECOM	("ЕКОМ"),
    COMBINED	("Комбинированное");

    @Getter
    @Setter
    private String title;

}
