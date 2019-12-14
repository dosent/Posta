package ru.neshin.posta.service.mappers;

import dto.ArchiveDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import ru.neshin.posta.model.Archive;

@Mapper(unmappedSourcePolicy = ReportingPolicy.WARN)
public interface ArchiveMapper {
    ArchiveMapper INSTANCE = Mappers.getMapper(ArchiveMapper.class);

    @Mappings({
            @Mapping(source = "batchName", target = "batchName"),
            @Mapping(source = "id", target = "archive_id")
    })
    ArchiveDto archiveToArchiveDro(Archive archive);
}
