package com.masai.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@EnableJpaRepositories(basePackages="com.masai.app.Repository")
@SpringBootApplication
public class Evaluation3Application {

	public static void main(String[] args) {
		SpringApplication.run(Evaluation3Application.class, args);
	}

}
 