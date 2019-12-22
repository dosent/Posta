package ru.neshin.posta.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import ru.neshin.posta.annotations.IncludeHash;
import ru.neshin.posta.annotations.IncludeHashDelegator;
import ru.neshin.posta.model.enums.BatchStatus;
import ru.neshin.posta.model.enums.CategoryMail;
import ru.neshin.posta.model.enums.CategoryNotice;
import ru.neshin.posta.model.enums.MethodPay;
import ru.neshin.posta.model.enums.RankMail;
import ru.neshin.posta.model.enums.TransportType;
import ru.neshin.posta.model.enums.TypeMail;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ArchiveDto implements IncludeHashDelegator {
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
    @JsonProperty("batch-status-date")
    @IncludeHash
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
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
     * Способ оплаты уведомления о вручении РПО
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
    @JsonProperty("list-number-date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateListNumber;

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

    /**
     * Адрес места приема
     */
    @JsonProperty("postoffice-address")
    private String postOfficeAddress;

    /**
     * Индекс места приема
     */
    @JsonProperty("postoffice-code")
    private String postOfficeCode;

    /**
     * Наименование места приема
     */
    @JsonProperty("postoffice-name")
    private String postOfficeName;

    /**
     * Сумма платы за авиа пересылку в копейках, без НДС (Опционально)
     */
    @JsonProperty("shipment-avia-rate-sum")
    private Integer shipmentAviaRateSum;

    /**
     * НДС от суммы платы за авиа пересылку в копейках (Опционально)
     */
    @JsonProperty("shipment-avia-rate-vat-sum")
    private Integer shipmentAviaRateVatSum;

    /**
     * Сумма платы за проверку комплектности в копейках, без НДС
     */
    @JsonProperty("shipment-completeness-checking-rate-sum")
    private Integer shipmentCompletenessCheckingRateSum;

    /**
     * НДС от суммы платы за проверку комплектности в копейках
     */
    @JsonProperty("shipment-completeness-checking-rate-vat-sum")
    private Integer shipmentCompletenessCheckingRateVatSum;

    /**
     * Сумма платы за проверку вложений в копейках, без НДС
     */
    @JsonProperty("shipment-contents-checking-rate-sum")
    private Integer shipmentContentsCheckingRateSum;

    /**
     * НДС от суммы платы за проверку вложений в копейках
     */
    @JsonProperty("shipment-contents-checking-rate-vat-sum")
    private Integer shipmentContentsCheckingRateVatSum;

    /**
     * Количество заказов в партии
     */
    @JsonProperty("shipment-count")
    private Integer shipmentCount;

    /**
     * Сумма платы за наземную пересылку в копейках, без НДС
     */
    @JsonProperty("shipment-ground-rate-sum")
    private Integer shipmentGroundRateSum;

    /**
     * НДС от суммы платы за наземную пересылку в копейках
     */
    @JsonProperty("shipment-ground-rate-vat-sum")
    private Integer shipmentGroundRateVatSum;

    /**
     * Сумма платы за объявленную ценность в копейках, без НДС
     */
    @JsonProperty("shipment-insure-rate-sum")
    private Integer shipmentInsureRateSum;

    /**
     * НДС от суммы платы за объявленную ценность в копейках
     */
    @JsonProperty("shipment-insure-rate-vat-sum")
    private Integer shipmentInsureRateVatSum;

    /**
     * Сумма платы за опись вложения в копейках, без НДС
     */
    @JsonProperty("shipment-inventory-rate-sum")
    private Integer shipmentInventoryRateSum;

    /**
     * НДС от суммы платы за опись вложения в копейках, без НДС
     */
    @JsonProperty("shipment-inventory-rate-vat-sum")
    private Integer shipmentInventoryRateVatSum;

    /**
     * Общий вес в граммах
     */
    @JsonProperty("shipment-mass")
    private Integer shipmentMass;

    /**
     * Сумма платы за пересылку в копейках, без НДС
     */
    @JsonProperty("shipment-mass-rate-sum")
    private Integer shipmentMassRateSum;

    /**
     * НДС от суммы платы за пересылку в копейках
     */
    @JsonProperty("shipment-mass-rate-vat-sum")
    private Integer shipmentMassRateVatSum;

    /**
     * Сумма надбавки за уведомление о вручении в копейках
     */
    @JsonProperty("shipment-notice-rate-sum")
    private Integer shipmentNoticeRateSum;

    /**
     * НДС от суммы надбавки за уведомление о вручении в копейках
     */
    @JsonProperty("shipment-notice-rate-vat-sum")
    private Integer shipmentNoticeRateVatSum;

    /**
     * Сумма платы за смс нотификацию в копейках, без НДС
     */
    @JsonProperty("shipment-sms-notice-rate-sum")
    private Integer shipmentSmsNoticeRateSum;

    /**
     * НДС от суммы платы за смс нотификацию в копейках
     */
    @JsonProperty("shipment-sms-notice-rate-vat-sum")
    private Integer shipmentSmsNoticeRateVatSum;

    /**
     * Категория уведомления о вручении РПО.
     */
    @JsonProperty("shipping-notice-type")
    private CategoryNotice shippingNoticeType;

    /**
     * Вид транспортировки
     */
    @JsonProperty("transport-type")
    private TransportType transportType;

    /**
     * Логические: true или false (Опционально)
     * Признак использования онлайн-баланса
     */
    @JsonProperty("use-online-balance")
    private Boolean useOnlineBalance;

    /**
     * Логические: true или false (Опционально)
     * Без указания массы
     */
    @JsonProperty("wo-mass")
    private Boolean woMass;
}
