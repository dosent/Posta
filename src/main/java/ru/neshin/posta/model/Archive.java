package ru.neshin.posta.model;

import lombok.Data;
import ru.neshin.posta.annotations.IncludeHash;
import ru.neshin.posta.annotations.IncludeHashDelegator;
import ru.neshin.posta.model.enums.BatchStatus;
import ru.neshin.posta.model.enums.CategoryMail;
import ru.neshin.posta.model.enums.MethodPay;
import ru.neshin.posta.model.enums.RankMail;
import ru.neshin.posta.model.enums.TypeMail;
import ru.neshin.posta.model.listeners.ArchiveEntityListeners;

import javax.persistence.*;
import java.math.BigDecimal;
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
    private BigDecimal courierCallRateWithVat = BigDecimal.ZERO;

    /**
     * Плата за услугу "Курьерский сбор" без НДС
     */
    @Column(name = "courier_call_rate_wo_vat")
    private BigDecimal courierCallWithOutVat = BigDecimal.ZERO;

    /**
     * delivery-notice-payment-method
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
    private LocalDateTime dateListNumber;

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
    private RankMail rankMail;

    /**
     * Вид регистрируемоего почтового отправления РПО
     */
    @Column(name="mail_type")
    @Enumerated(EnumType.STRING)
    private TypeMail typeMail;

    @Column(name = "custom_hash")
    private  String hash;

}
