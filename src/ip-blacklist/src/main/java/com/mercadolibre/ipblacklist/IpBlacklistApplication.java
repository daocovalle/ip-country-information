package com.mercadolibre.ipblacklist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
@EntityScan(basePackages = { "com.mercadolibre.ipblacklist.db.entity" })
@EnableJpaRepositories(basePackages = { "com.mercadolibre.ipblacklist.db.repository" })
public class IpBlacklistApplication {

	public static void main(String[] args) {
		SpringApplication.run(IpBlacklistApplication.class, args);
	}

}
