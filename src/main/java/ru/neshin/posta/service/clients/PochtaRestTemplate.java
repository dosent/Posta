package ru.neshin.posta.service.clients;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
public class PochtaRestTemplate extends RestTemplate {
    //Токен авторизации
    @Value("${access.token}")
    private String accessToken;
    //Ключ авторизации
    @Value("${access.key}")
    private String accessKey;

    private HttpEntity<String> enrichHeader(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("authorization",accessToken);
        headers.set("x-user-authorization",accessKey);
        return new HttpEntity<>("body", headers);
    }

    public <T> ResponseEntity<T> exchangePochta(String url, HttpMethod method, Class<T> responseType, Object... uriVariables) throws RestClientException {
        HttpEntity<String> requestEntity = enrichHeader();
        return super.exchange(url, method, requestEntity, responseType, uriVariables);
    }
}
