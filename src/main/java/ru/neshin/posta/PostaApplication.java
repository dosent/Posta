package ru.neshin.posta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PostaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostaApplication.class, args);
	}

}
