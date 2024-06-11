package com.usto.re.ushort.configs.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;

@ConfigurationProperties(prefix = "app.cors")
public class AppCorsProperties {
	
	private final String[] origins;
	
	private final String[] headers;
	
	private final String[] methods;

	@ConstructorBinding
	public AppCorsProperties(String[] origins, String[] headers, String[] methods) {
		this.origins = origins;
		this.headers = headers;
		this.methods = methods;
	}

	public String[] getOrigins() {
		return origins;
	}

	public String[] getHeaders() {
		return headers;
	}

	public String[] getMethods() {
		return methods;
	}
}
