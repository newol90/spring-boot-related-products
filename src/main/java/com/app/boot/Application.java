package com.app.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.app.config.AppConfiguration;

@SpringBootApplication
@ComponentScan(basePackages = { "com.app.controller", "com.app.model.mapper", "com.app.service.impl" })
@EntityScan(basePackages = "com.app.model.entity")
@EnableJpaRepositories(basePackages = "com.app.repository")
@Import(AppConfiguration.class)
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
