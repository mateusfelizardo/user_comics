package com.api.user_comics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class UserComicsApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserComicsApplication.class, args);
	}
}
