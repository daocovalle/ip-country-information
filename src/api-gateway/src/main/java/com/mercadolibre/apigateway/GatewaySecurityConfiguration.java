package com.mercadolibre.apigateway;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class GatewaySecurityConfiguration extends WebSecurityConfigurerAdapter {

	private final GatewayConfigurationProperties gatewayProperties;

	public GatewaySecurityConfiguration(GatewayConfigurationProperties gatewayProperties) {
		super();
		this.gatewayProperties = gatewayProperties;
	}

	@Override
	protected void configure(final HttpSecurity http) throws Exception {

		// @formatter:off
        http.csrf().disable()
            .authorizeRequests()
                .antMatchers(gatewayProperties.getAllowedPaths().toArray(new String[0])).permitAll()
                .anyRequest().denyAll()
            .and()
                .formLogin().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().addFilterBefore(new SecurityFilter(), UsernamePasswordAuthenticationFilter.class);
        // @formatter:on
	}

}
