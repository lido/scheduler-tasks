package com.lido.schedulertasks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SchedulerTasksApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchedulerTasksApplication.class, args);
	}

}
