package com.project.expensetracker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class ExpensetrackerApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExpensetrackerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ExpensetrackerApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void start() {
		LOGGER.info("EXPENSE TRACKER START");
	}

}
