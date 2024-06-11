package com.usto.re.ushort.entities;

import java.time.Instant;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table(value = "tinyurl")
public class TinyUrl {

	@PrimaryKey
	private String code;

	@Column
	private String originalURL;
	
	@Column
	private Instant creationDate;
	
	public TinyUrl(String code, String originalURL, Instant creationDate) {
		this.code = code;
		this.originalURL = originalURL;	
		this.creationDate = creationDate;
	}

	public TinyUrl() {
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getOriginalURL() {
		return originalURL;
	}

	public void setOriginalURL(String originalURL) {
		this.originalURL = originalURL;
	}

	public Instant getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Instant creationDate) {
		this.creationDate = creationDate;
	}
}
