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
            @Mapping(source = "id", target = "archive_id")
    })
    ArchiveDto archiveToArchiveDto(Archive archive);

    @Mappings({
            @Mapping(source = "batchName", target = "batchName"),
            @Mapping(source = "batchStatus", target = "batchStatus"),
            @Mapping(source = "archive_id", target = "id")
    })
    Archive archiveDtoToArchive(@NotNull ArchiveDto dto);


}
