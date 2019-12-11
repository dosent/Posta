package ru.neshin.posta.configuration;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Ой что-то пошло не так....")
public class PostaRunTimeException extends RuntimeException {
}
