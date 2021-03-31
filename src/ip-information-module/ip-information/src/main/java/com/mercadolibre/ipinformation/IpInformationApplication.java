package com.mercadolibre.ipinformation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

import com.mercadolibre.blacklist.configuration.BlackListConfigurationProperties;
import com.mercadolibre.coininformation.configuration.CoinConfigurationProperties;
import com.mercadolibre.countryinformation.configuration.CountryConfigurationProperties;
import com.mercadolibre.ipgeolocation.configuration.GeolocationConfigurationProperties;

@EnableCaching
@EnableConfigurationProperties(value = { CoinConfigurationProperties.class, CountryConfigurationProperties.class,
		GeolocationConfigurationProperties.class, BlackListConfigurationProperties.class })
@SpringBootApplication
@ComponentScan(basePackages = { "com.mercadolibre.countryinformation", "com.mercadolibre.ipinformation",
		"com.mercadolibre.coininformation", "com.mercadolibre.ipgeolocation", "com.mercadolibre.blacklist" })
public class IpInformationApplication {
	public static void main(String[] args) {
		SpringApplication.run(IpInformationApplication.class, args);
	}

}
