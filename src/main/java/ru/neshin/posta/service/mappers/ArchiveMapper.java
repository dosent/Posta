package ru.neshin.posta.service.mappers;

import ru.neshin.posta.dto.ArchiveDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import ru.neshin.posta.model.Archive;

import javax.validation.constraints.NotNull;

@Mapper(unmappedSourcePolicy = ReportingPolicy.WARN)
public interface ArchiveMapper {
    ArchiveMapper INSTANCE = Mappers.getMapper(ArchiveMapper.class);

    @Mappings({
            @Mapping(source = "batchName", target = "batchName"),
            @Mapping(source = "batchStatus", target = "batchStatus"),
            @Mapping(source = "branchName", target = "branchName"),
            @Mapping(source = "dateUpdateStatus", target = "dateUpdateStatus"),
            @Mapping(source = "typeMail", target = "typeMail"),
            @Mapping(source = "rankMail", target = "rankMail"),
            @Mapping(source = "noticePaymentMethod", target = "noticePaymentMethod"),
            @Mapping(source = "paymentMethod", target = "paymentMethod"),
            @Mapping(source = "international", target = "international"),
            @Mapping(source = "listNumber", target = "listNumber"),
            @Mapping(source = "dateListNumber", target = "dateListNumber"),
            @Mapping(source = "categoryMail", target = "categoryMail"),
            @Mapping(source = "deliveryNoticeMethodPay", target = "deliveryNoticeMethodPay"),
            @Mapping(source = "courierCallWithOutVat", target = "courierCallWithOutVat"),
            @Mapping(source = "courierCallRateWithVat", target = "courierCallRateWithVat"),
            @Mapping(source = "postOfficeAddress", target = "postOfficeAddress"),
            @Mapping(source = "postOfficeCode", target = "postOfficeCode"),
            @Mapping(source = "postOfficeName", target = "postOfficeName"),
            @Mapping(source = "shipmentAviaRateSum", target = "shipmentAviaRateSum"),
            @Mapping(source = "shipmentAviaRateVatSum", target = "shipmentAviaRateVatSum"),
            @Mapping(source = "shipmentCompletenessCheckingRateSum", target = "shipmentCompletenessCheckingRateSum"),
            @Mapping(source = "shipmentCompletenessCheckingRateVatSum", target = "shipmentCompletenessCheckingRateVatSum"),
            @Mapping(source = "shipmentContentsCheckingRateSum", target = "shipmentContentsCheckingRateSum"),
            @Mapping(source = "shipmentContentsCheckingRateVatSum", target = "shipmentContentsCheckingRateVatSum"),
            @Mapping(source = "shipmentCount", target = "shipmentCount"),
            @Mapping(source = "shipmentGroundRateSum", target = "shipmentGroundRateSum"),
            @Mapping(source = "shipmentGroundRateVatSum", target = "shipmentGroundRateVatSum"),
            @Mapping(source = "shipmentInsureRateSum", target = "shipmentInsureRateSum"),
            @Mapping(source = "shipmentInsureRateVatSum", target = "shipmentInsureRateVatSum"),
            @Mapping(source = "shipmentInventoryRateSum", target = "shipmentInventoryRateSum"),
            @Mapping(source = "shipmentInventoryRateVatSum", target = "shipmentInventoryRateVatSum"),
            @Mapping(source = "shipmentMass", target = "shipmentMass"),
            @Mapping(source = "shipmentMassRateSum", target = "shipmentMassRateSum"),
            @Mapping(source = "shipmentMassRateVatSum", target = "shipmentMassRateVatSum"),
            @Mapping(source = "shipmentNoticeRateSum", target = "shipmentNoticeRateSum"),
            @Mapping(source = "shipmentNoticeRateVatSum", target = "shipmentNoticeRateVatSum"),
            @Mapping(source = "shipmentSmsNoticeRateSum", target = "shipmentSmsNoticeRateSum"),
            @Mapping(source = "shipmentSmsNoticeRateVatSum", target = "shipmentSmsNoticeRateVatSum"),
            @Mapping(source = "shippingNoticeType", target = "shippingNoticeType"),
            @Mapping(source = "transportType", target = "transportType"),
            @Mapping(source = "useOnlineBalance", target = "useOnlineBalance"),
            @Mapping(source = "woMass", target = "woMass"),
            @Mapping(source = "id", target = "archive_id")
    })
    ArchiveDto archiveToArchiveDto(Archive archive);

    @Mappings({
            @Mapping(source = "batchName", target = "batchName"),
            @Mapping(source = "batchStatus", target = "batchStatus"),
            @Mapping(source = "branchName", target = "branchName"),
            @Mapping(source = "dateUpdateStatus", target = "dateUpdateStatus"),
            @Mapping(source = "typeMail", target = "typeMail"),
            @Mapping(source = "rankMail", target = "rankMail"),
            @Mapping(source = "noticePaymentMethod", target = "noticePaymentMethod"),
            @Mapping(source = "paymentMethod", target = "paymentMethod"),
            @Mapping(source = "international", target = "international"),
            @Mapping(source = "listNumber", target = "listNumber"),
            @Mapping(source = "dateListNumber", target = "dateListNumber"),
            @Mapping(source = "categoryMail", target = "categoryMail"),
            @Mapping(source = "deliveryNoticeMethodPay", target = "deliveryNoticeMethodPay"),
            @Mapping(source = "courierCallWithOutVat", target = "courierCallWithOutVat"),
            @Mapping(source = "courierCallRateWithVat", target = "courierCallRateWithVat"),
            @Mapping(source = "postOfficeAddress", target = "postOfficeAddress"),
            @Mapping(source = "postOfficeCode", target = "postOfficeCode"),
            @Mapping(source = "postOfficeName", target = "postOfficeName"),
            @Mapping(source = "shipmentAviaRateSum", target = "shipmentAviaRateSum"),
            @Mapping(source = "shipmentAviaRateVatSum", target = "shipmentAviaRateVatSum"),
            @Mapping(source = "shipmentCompletenessCheckingRateSum", target = "shipmentCompletenessCheckingRateSum"),
            @Mapping(source = "shipmentCompletenessCheckingRateVatSum", target = "shipmentCompletenessCheckingRateVatSum"),
            @Mapping(source = "shipmentContentsCheckingRateSum", target = "shipmentContentsCheckingRateSum"),
            @Mapping(source = "shipmentContentsCheckingRateVatSum", target = "shipmentContentsCheckingRateVatSum"),
            @Mapping(source = "shipmentCount", target = "shipmentCount"),
            @Mapping(source = "shipmentGroundRateSum", target = "shipmentGroundRateSum"),
            @Mapping(source = "shipmentGroundRateVatSum", target = "shipmentGroundRateVatSum"),
            @Mapping(source = "shipmentInsureRateSum", target = "shipmentInsureRateSum"),
            @Mapping(source = "shipmentInsureRateVatSum", target = "shipmentInsureRateVatSum"),
            @Mapping(source = "shipmentInventoryRateSum", target = "shipmentInventoryRateSum"),
            @Mapping(source = "shipmentInventoryRateVatSum", target = "shipmentInventoryRateVatSum"),
            @Mapping(source = "shipmentMass", target = "shipmentMass"),
            @Mapping(source = "shipmentMassRateSum", target = "shipmentMassRateSum"),
            @Mapping(source = "shipmentMassRateVatSum", target = "shipmentMassRateVatSum"),
            @Mapping(source = "shipmentNoticeRateSum", target = "shipmentNoticeRateSum"),
            @Mapping(source = "shipmentNoticeRateVatSum", target = "shipmentNoticeRateVatSum"),
            @Mapping(source = "shipmentSmsNoticeRateSum", target = "shipmentSmsNoticeRateSum"),
            @Mapping(source = "shipmentSmsNoticeRateVatSum", target = "shipmentSmsNoticeRateVatSum"),
            @Mapping(source = "shippingNoticeType", target = "shippingNoticeType"),
            @Mapping(source = "transportType", target = "transportType"),
            @Mapping(source = "useOnlineBalance", target = "useOnlineBalance"),
            @Mapping(source = "woMass", target = "woMass"),
            @Mapping(source = "archive_id", target = "id")
    })
    Archive archiveDtoToArchive(@NotNull ArchiveDto dto);

}
