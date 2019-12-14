package ru.neshin.posta.model;

import lombok.Data;
import ru.neshin.posta.model.enums.BatchStatus;
import ru.neshin.posta.model.enums.MethodPay;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "archive")
public class Archive {
    @Id
    @GeneratedValue
    @Column(name = "archive_id", nullable = false)
    private Long id;

    /**
     * Номер партии
     */
    @Column(name = "batch_name", nullable = false)
    private String batchName;

    /**
     * Статусы партии
     */
    @Column(name="batch_status")
    private BatchStatus batchStatus;

    /**
     * Список заказов
     */
    @OneToMany(fetch = FetchType.LAZY)
    private List<Shipment> shipments;

    /**
     * Дата обновления статуса
     */
    @Column(name = "batch_status_date")
    private ZonedDateTime dateUpdateStatus;

    /**
     * Идентификатор подразделения
     */
    @Column(name = "branch_name")
    private String branchName;

    /**
     * Плата за услугу "Курьерский сбор" с НДС
     */
    @Column(name = "courier_call_rate_with_vat")
    BigDecimal courierCallRateWithVat = BigDecimal.ZERO;

    /**
     * Плата за услугу "Курьерский сбор" без НДС
     */
    @Column(name = "courier_call_rate_wo_vat")
    BigDecimal courierCallWithOutVat = BigDecimal.ZERO;

    /**
     * delivery-notice-payment-method
     */
    @Column(name = "delivery_notice_payment_method")
    MethodPay deliveryNoticeMethodPay;
}
