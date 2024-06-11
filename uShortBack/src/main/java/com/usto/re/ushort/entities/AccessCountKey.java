package com.usto.re.ushort.entities;

import java.time.Instant;

import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

@PrimaryKeyClass
public class AccessCountKey {
	
	@PrimaryKeyColumn(name = "request_identifier")
	private String requestIdentifier;
	
	@PrimaryKeyColumn(name = "access_timestamp", type = PrimaryKeyType.PARTITIONED, ordering = Ordering.DESCENDING)
	private Instant AccessTimestamp;

	public AccessCountKey(String requestIdentifier, Instant accessTimestamp) {
		super();
		this.requestIdentifier = requestIdentifier;
		AccessTimestamp = accessTimestamp;
	}

	public String getRequestIdentifier() {
		return requestIdentifier;
	}

	public void setRequestIdentifier(String requestIdentifier) {
		this.requestIdentifier = requestIdentifier;
	}

	public Instant getAccessTimestamp() {
		return AccessTimestamp;
	}

	public void setAccessTimestamp(Instant accessTimestamp) {
		AccessTimestamp = accessTimestamp;
	}
	
}
