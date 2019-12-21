package ru.neshin.posta.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import ru.neshin.posta.annotations.IncludeHash;
import ru.neshin.posta.annotations.IncludeHashDelegator;
import ru.neshin.posta.model.enums.BatchStatus;
import ru.neshin.posta.service.converters.BaseConverter;

@Data
public class ArchiveDto implements BaseConverter, IncludeHashDelegator {
    private Long archive_id;

    @JsonProperty("batch-name")
    @IncludeHash
    private String batchName;

    @JsonProperty("batch-status")
    @IncludeHash
    private BatchStatus batchStatus;
}
