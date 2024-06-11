package com.usto.re.ushort.configs;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {
	
	@Value("${app.cors.origins}")
	private String[] origins;

	@Value("${app.cors.headers}")
	private String[] headers;

	@Value("${app.cors.methods}")
	private String[] methods;
	
	public CorsConfig(String[] origins, String[] headers, String[] methods) {
		this.origins = origins;
		this.headers = headers;
		this.methods = methods;
	}

	@Bean
	CorsFilter corsFilters() {
		var source = new UrlBasedCorsConfigurationSource();
		var config = new CorsConfiguration();
		
		config.setAllowedHeaders(Arrays.asList(headers));
		config.setAllowedMethods(Arrays.asList(methods));
		config.setAllowedOrigins(Arrays.asList(origins));
		
		source.registerCorsConfiguration("/**", config);
		
		return new CorsFilter(source);
	}
}
