package ru.neshin.posta.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import ru.neshin.posta.annotations.IncludeHash;
import ru.neshin.posta.annotations.IncludeHashDelegator;
import ru.neshin.posta.model.enums.BatchStatus;
import ru.neshin.posta.model.enums.CategoryMail;
import ru.neshin.posta.model.enums.MethodPay;
import ru.neshin.posta.model.enums.RankMail;
import ru.neshin.posta.model.enums.TypeMail;
import ru.neshin.posta.service.converters.BaseConverter;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ArchiveDto implements BaseConverter, IncludeHashDelegator {
    private Long archive_id;

    /**
     * Номер партии
     */
    @JsonProperty("batch-name")
    @IncludeHash
    private String batchName;

    /**
     * Статусы партии
     */
    @JsonProperty("batch-status")
    @IncludeHash
    private BatchStatus batchStatus;

    /**
     * Дата обновления статуса
     */
    //@JsonProperty("batch-status-date")
    @IncludeHash
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private LocalDateTime dateUpdateStatus;

    /**
     * Идентификатор подразделения
     */
    @JsonProperty("branch-name")
    private String branchName;

    /**
     * Плата за услугу "Курьерский сбор" с НДС
     */
    @JsonProperty("courier-call-rate-with-vat")
    private Integer courierCallRateWithVat;

    /**
     * Плата за услугу "Курьерский сбор" без НДС
     */
    @JsonProperty("courier-call-rate-wo-vat")
    private Integer courierCallWithOutVat;

    /**
     * delivery-notice-payment-method
     */
    @JsonProperty("delivery-notice-payment-method")
    private MethodPay deliveryNoticeMethodPay;

    /**
     * Категория регистрируемого почтового отправления (РПО)
     */
    @JsonProperty("mail-category")
    private CategoryMail categoryMail;

    /**
     * Дата документа для сдачи партии
     */
    //@JsonProperty("list-number-date")
    private LocalDateTime dateListNumber;

    /**
     * Номер документа для сдачи партии
     */
    @JsonProperty("list-number")
    private Integer listNumber;

    /**
     * Признак международной почты
     */
    @JsonProperty("international")
    private boolean international;

    /**
     * Способ оплаты
     */
    @JsonProperty("payment-method")
    private MethodPay paymentMethod;

    /**
     * Строка (Опционально) что за оплата надо посмотреть
     * Способ оплаты
     */
    @JsonProperty("notice-payment-method")
    private MethodPay noticePaymentMethod;

    /**
     * Разряд письма
     */
    @JsonProperty("mail-rank")
    private RankMail rankMail;

    /**
     * Вид регистрируемоего почтового отправления РПО
     */
    @JsonProperty("mail-type")
    private TypeMail typeMail;
}
