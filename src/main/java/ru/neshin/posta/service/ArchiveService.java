package ru.neshin.posta.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.ArchiveDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import ru.neshin.posta.service.clients.PochtaRestTemplate;
import ru.neshin.posta.service.mappers.ArchiveMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.neshin.posta.configuration.PostaRunTimeException;
import ru.neshin.posta.dao.ArchiveDao;
import ru.neshin.posta.model.Archive;

import java.util.Collections;
import java.util.Optional;

@Data
@Service
public class ArchiveService {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private static final Logger LOGGER = LoggerFactory.getLogger(ArchiveService.class);

    private ArchiveDao archiveDao;

    private PochtaRestTemplate restTemplate;

    @Autowired
    public ArchiveService(ArchiveDao archiveDao, PochtaRestTemplate restTemplate) {
        this.archiveDao = archiveDao;
        this.restTemplate = restTemplate;
    }

    @Transactional
    public ArchiveDto getId(Long id) {
        Optional<Archive> archive = archiveDao.findById(id);
        ArchiveDto result = ArchiveMapper.INSTANCE.archiveToArchiveDro(
                archive.orElseThrow(() -> new PostaRunTimeException()));
        return result;
    }


    public void updateArchiveFromPochtaRu() {
        String uri = "https://otpravka-api.pochta.ru/1.0/archive";
        ResponseEntity<String> response = restTemplate.exchangePochta(uri, HttpMethod.GET, String.class);
        System.out.println("Result - status ("+ response.getStatusCode() + ") has body: " + response.getBody());
        if (HttpStatus.OK == response.getStatusCode()) {
            try {
                JsonNode actualObj = objectMapper.readTree(response.getBody());
                actualObj.forEach(batch -> mergeArchive(batch));
            } catch (JsonProcessingException e) {
                LOGGER.error("Не могу достучаться до " + uri);
            }
        }
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    protected void mergeArchive(JsonNode batch) {

    }
}
