package com.api.worker;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class WorkerApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkerApiApplication.class, args);
		System.out.println("Rodando o WORKER API");
	}

}
