package com.usto.re.ushort.dto;

import java.time.Instant;
import java.util.Date;

import com.usto.re.ushort.entities.TinyUrl;

public class TinyUrlDTO {
	
	private String code;
	
	private Instant creationDate;

	public TinyUrlDTO(String code, Instant creationDate) {
		this.code = code;
		this.creationDate = creationDate;
	}
	
	public TinyUrlDTO(TinyUrl tinyUrl) {
		this.code = tinyUrl.getCode();
		this.creationDate = tinyUrl.getCreationDate();
	}
	
	public TinyUrlDTO() {
		super();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public Instant getCreationDate() {
		return creationDate;
	}
	
	public void setCreationDate(Instant creationDate) {
		this.creationDate = creationDate;
	}

}
