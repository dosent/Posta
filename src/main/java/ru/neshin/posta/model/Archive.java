package ru.neshin.posta.model;

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
import ru.neshin.posta.model.listeners.ArchiveEntityListeners;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@EntityListeners(ArchiveEntityListeners.class)
@Table(name = "archive",
        indexes = {@Index(name = "idx_custom_hash", columnList = "custom_hash")})
public class Archive implements IncludeHashDelegator {
    @Id
    @GeneratedValue
    @Column(name = "archive_id", nullable = false)
    private Long id;

    /**
     * Хеш MD5 на основе данных аннотации @IncludeHash
     * заполняется @EntityListeners
     */
    @Column(name = "custom_hash")
    private  String hash;

    /**
     * Номер партии
     */
    @IncludeHash
    @Column(name = "batch_name", nullable = false)
    private String batchName;

    /**
     * Статусы партии
     */
    @Column(name="batch_status")
    @Enumerated(EnumType.STRING)
    @IncludeHash
    private BatchStatus batchStatus;

    /**
     * Список заказов
     */
    @OneToMany(fetch = FetchType.LAZY)
    private List<Shipment> shipments;

    /**
     * Дата обновления статуса
     */

    @Column(name = "batch_status_date", columnDefinition = "TIMESTAMP")
    @IncludeHash
    private LocalDateTime dateUpdateStatus;

    /**
     * Идентификатор подразделения
     */
    @Column(name = "branch_name")
    private String branchName;

    /**
     * Плата за услугу "Курьерский сбор" с НДС
     */
    @Column(name = "courier_call_rate_with_vat")
    private Integer courierCallRateWithVat = 0;

    /**
     * Плата за услугу "Курьерский сбор" без НДС
     */
    @Column(name = "courier_call_rate_wo_vat")
    private Integer courierCallWithOutVat = 0;

    /**
     * Способ оплаты уведомления о вручении РПО
     */
    @Column(name = "delivery_notice_payment_method")
    @Enumerated(EnumType.STRING)
    private MethodPay deliveryNoticeMethodPay;

    /**
     * Категория регистрируемого почтового отправления (РПО)
     */
    @Column(name = "mail_category")
    @Enumerated(EnumType.STRING)
    private CategoryMail categoryMail;

    /**
     * Дата документа для сдачи партии
     */
    @Column(name = "list_number_date", columnDefinition = "TIMESTAMP")
    private LocalDate dateListNumber;

    /**
     * Номер документа для сдачи партии
     */
    @Column(name="list_number")
    private Integer listNumber;

    /**
     * Признак международной почты
     */
    @Column(name = "is_international")
    private boolean international;

    /**
     * Способ оплаты
     */
    @Column(name="payment_method")
    @Enumerated(EnumType.STRING)
    private MethodPay paymentMethod;

    /**
     * Строка (Опционально) что за оплата нодо посмотреть
     * Способ оплаты
     */
    @Column(name = "notice_payment_method")
    @Enumerated(EnumType.STRING)
    private MethodPay noticePaymentMethod;

    /**
     * Разряд письма
     */
    @Column(name = "mail_rank")
    @Enumerated(EnumType.STRING)
    private RankMail rankMail;

    /**
     * Вид регистрируемоего почтового отправления РПО
     */
    @Column(name="mail_type")
    @Enumerated(EnumType.STRING)
    private TypeMail typeMail;
    /**
     * Адрес места приема
     */
    @Column(name = "post_office_address")
    private String postOfficeAddress;

    /**
     * Индекс места приема
     */
    @Column(name = "post_office_code")
    private String postOfficeCode;

    /**
     * Наименование места приема
     */
    @Column(name = "post_office_name")
    private String postOfficeName;

    /**
     * Сумма платы за авиа пересылку в копейках, без НДС (Опционально)
     */
    @Column(name = "shipment_avia_rate_sum")
    private Integer shipmentAviaRateSum;

    /**
     * НДС от суммы платы за авиа пересылку в копейках (Опционально)
     */
    @Column(name = "shipment_avia_rate_vat_sum")
    private Integer shipmentAviaRateVatSum;

    /**
     * Сумма платы за проверку комплектности в копейках, без НДС
     */
    @Column(name = "shipment_completeness_checking_rate_sum")
    private Integer shipmentCompletenessCheckingRateSum;

    /**
     * НДС от суммы платы за проверку комплектности в копейках
     */
    @Column(name = "shipment_completeness_checking_rate_vat_sum")
    private Integer shipmentCompletenessCheckingRateVatSum;

    /**
     * Сумма платы за проверку вложений в копейках, без НДС
     */
    @Column(name = "shipment_contents_checking_rate_sum")
    private Integer shipmentContentsCheckingRateSum;

    /**
     * НДС от суммы платы за проверку вложений в копейках
     */
    @Column(name = "shipment_contents_checking_rate_vat_sum")
    private Integer shipmentContentsCheckingRateVatSum;

    /**
     * Количество заказов в партии
     */
    @Column(name = "shipment_count")
    private Integer shipmentCount;

    /**
     * Сумма платы за наземную пересылку в копейках, без НДС
     */
    @Column(name = "shipment_ground_rate_sum")
    private Integer shipmentGroundRateSum;

    /**
     * НДС от суммы платы за наземную пересылку в копейках
     */
    @Column(name = "shipment_ground_rate_vat_sum")
    private Integer shipmentGroundRateVatSum;

    /**
     * Сумма платы за объявленную ценность в копейках, без НДС
     */
    @Column(name = "shipment_insure_rate_sum")
    private Integer shipmentInsureRateSum;

    /**
     * НДС от суммы платы за объявленную ценность в копейках
     */
    @Column(name = "shipment_insure_rate_vat_sum")
    private Integer shipmentInsureRateVatSum;

    /**
     * Сумма платы за опись вложения в копейках, без НДС
     */
    @Column(name = "shipment_inventory_rate_sum")
    private Integer shipmentInventoryRateSum;

    /**
     * НДС от суммы платы за опись вложения в копейках, без НДС
     */
    @Column(name = "shipment_inventory_rate_vat_sum")
    private Integer shipmentInventoryRateVatSum;

    /**
     * Общий вес в граммах
     */
    @Column(name = "shipment_mass")
    private Integer shipmentMass;

    /**
     * Сумма платы за пересылку в копейках, без НДС
     */
    @Column(name = "shipment_mass_rate_sum")
    private Integer shipmentMassRateSum;

    /**
     * НДС от суммы платы за пересылку в копейках
     */
    @Column(name = "shipment_mass_rate_vat_sum")
    private Integer shipmentMassRateVatSum;

    /**
     * Сумма надбавки за уведомление о вручении в копейках
     */
    @Column(name = "shipment_notice_rate_sum")
    private Integer shipmentNoticeRateSum;

    /**
     * НДС от суммы надбавки за уведомление о вручении в копейках
     */
    @Column(name = "shipment_notice_rate_vat_sum")
    private Integer shipmentNoticeRateVatSum;

    /**
     * Сумма платы за смс нотификацию в копейках, без НДС
     */
    @Column(name = "shipment_sms_notice_rate_sum")
    private Integer shipmentSmsNoticeRateSum;

    /**
     * НДС от суммы платы за смс нотификацию в копейках
     */
    @Column(name = "shipment_sms_notice_rate_vat_sum")
    private Integer shipmentSmsNoticeRateVatSum;

    /**
     * Категория уведомления о вручении РПО.
     */
    @Column(name = "shipping_notice_type")
    private CategoryNotice shippingNoticeType;

    /**
     * Вид транспортировки
     */
    @Column(name = "transport_type")
    private TransportType transportType;

    /**
     * Логические: true или false (Опционально)
     * Признак использования онлайн_баланса
     */
    @Column(name = "use_online_balance")
    private Boolean useOnlineBalance;

    /**
     * Логические: true или false (Опционально)
     * Без указания массы
     */
    @Column(name = "wo_mass")
    private Boolean woMass;
}
