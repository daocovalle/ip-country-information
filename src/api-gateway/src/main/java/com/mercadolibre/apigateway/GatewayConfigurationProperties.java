package com.mercadolibre.apigateway;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "gateway-security")
public class GatewayConfigurationProperties {

	private List<String> allowedPaths;

	public void setAllowedPaths(List<String> allowedPaths) {
		this.allowedPaths = allowedPaths;
	}

	public List<String> getAllowedPaths() {
		return allowedPaths;
	}

}
