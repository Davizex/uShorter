package com.usto.re.ushort.configs.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;

@ConfigurationProperties(prefix = "app")
public class AppProperties {

	private final AppCorsProperties cors;
	
	private final int encodedLength;
	
	@ConstructorBinding
	public AppProperties(AppCorsProperties cors, int encodedLength) {
		super();
		this.cors = cors;
		this.encodedLength = encodedLength;
	}

	public AppCorsProperties getCors() {
		return cors;
	}

	public int getEncodedLength() {
		return encodedLength;
	}
	
}
