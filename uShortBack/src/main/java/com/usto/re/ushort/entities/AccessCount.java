package com.usto.re.ushort.entities;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table(value = "access_count")
public class AccessCount {
	
	@PrimaryKey
	private AccessCountKey key;
	
	@Column
	private String code;

	public AccessCount(AccessCountKey key, String code) {
		this.key = key;
		this.code = code;
	}

	public AccessCountKey getKey() {
		return key;
	}

	public void setKey(AccessCountKey key) {
		this.key = key;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
}
