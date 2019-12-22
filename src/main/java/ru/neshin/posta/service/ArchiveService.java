package ru.neshin.posta.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import static java.util.Objects.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.neshin.posta.service.clients.PochtaRestTemplate;
import ru.neshin.posta.service.mappers.ArchiveMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.neshin.posta.configuration.PostaRunTimeException;
import ru.neshin.posta.dao.ArchiveDao;
import ru.neshin.posta.model.Archive;
import ru.neshin.posta.dto.ArchiveDto;
import java.util.Optional;

@Data
@Service
public class ArchiveService {

    public static final String URL_ARCHIVE = "https://otpravka-api.pochta.ru/1.0/archive";

    private static final Logger LOGGER = LoggerFactory.getLogger(ArchiveService.class);

    private final ArchiveMapper archiveMapper = ArchiveMapper.INSTANCE;

    private ArchiveDao archiveDao;

    private PochtaRestTemplate restTemplate;

    private ObjectMapper objectMapper;

    @Autowired
    public ArchiveService(ArchiveDao archiveDao, PochtaRestTemplate restTemplate, ObjectMapper objectMapper) {
        this.archiveDao = archiveDao;
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    @Transactional
    public ArchiveDto getId(Long id) {
        Optional<Archive> archive = archiveDao.findById(id);
        return archiveMapper.archiveToArchiveDto(
                archive.orElseThrow(PostaRunTimeException::new));
    }

    @Transactional
    public void updateArchiveFromPochtaRu() {
        String uri = URL_ARCHIVE;
        ResponseEntity<String> response = restTemplate.exchangePochta(uri, HttpMethod.GET, String.class);
        if (HttpStatus.OK == response.getStatusCode()) {
            try {
                objectMapper.readTree(requireNonNull(response.getBody()))
                        .forEach(this::mergeArchive);
            } catch (JsonProcessingException e) {
                LOGGER.error("Не могу достучаться до " + uri);
            }
        }
    }

    private void mergeArchive(JsonNode batch) {
        try {
            ArchiveDto archiveDto = objectMapper
                    .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                    .readValue(batch.toString(), ArchiveDto.class);
            if (!archiveDao.findFirstByHash(archiveDto.getCustomHash()).isPresent()) {
                archiveDao.save(archiveMapper.archiveDtoToArchive(archiveDto));
            }
        } catch (Throwable e) {
            LOGGER.error("Ошибка обработки: " + batch.toString());
            LOGGER.error("Error: " + e.getMessage());
        }
    }
}
