package br.com.filipeapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FilipeappApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilipeappApplication.class, args);
	}

}
