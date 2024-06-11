package com.usto.re.ushort.dto;

public class CreateTinyUrl {

	private String originalURL;

	public CreateTinyUrl(String originalURL) {
		this.originalURL = originalURL;
	}

	public CreateTinyUrl() {
		super();
	}

	public String getOriginalURL() {
		return originalURL;
	}

	public void setOriginalURL(String originalURL) {
		this.originalURL = originalURL;
	}

}
