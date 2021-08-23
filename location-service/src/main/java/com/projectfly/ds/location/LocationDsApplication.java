package com.projectfly.ds.location;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.projectfly.ds.location.repo")
public class LocationDsApplication {

	private static final Logger LOG = LoggerFactory.getLogger(LocationDsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LocationDsApplication.class, args);
	}

	@Bean
	ApplicationListener<ApplicationReadyEvent> onApplicationReadyEventListener(ServerProperties serverProperties) {

		return (evt) -> {
			Integer port = serverProperties.getPort();

			LOG.info("Embedded Keycloak started: http://localhost:{}/swagger-ui.html to use employee-ds", port);
		};
	}
}
