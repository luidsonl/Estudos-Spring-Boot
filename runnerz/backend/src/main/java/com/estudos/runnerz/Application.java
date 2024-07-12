package com.estudos.runnerz;

import com.estudos.runnerz.run.Coordinate;
import com.estudos.runnerz.run.Run;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			Run run = new Run(
					1,
					"corrida",
					new Coordinate(20.3, 20.3),
					new Coordinate(20.3001, 20.3001),
					LocalDateTime.now(),
					LocalDateTime.now().plusHours(1)
			);

			log.info("Run: " + run);
		};
	}
}
