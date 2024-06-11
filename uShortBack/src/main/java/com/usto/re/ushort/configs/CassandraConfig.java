package com.usto.re.ushort.configs;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CqlSessionFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.CassandraAdminTemplate;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@EnableCassandraRepositories
public class CassandraConfig extends AbstractCassandraConfiguration {

	@Value("${spring.cassandra.keyspace-name}")
	private String keyspaceName;

	@Value("${spring.cassandra.contact-points}")
	private String contactPoints;

	@Value("${spring.cassandra.port}")
	private int port;

	@Value("${spring.cassandra.schema-action}")
	private SchemaAction schemaAction;

	@Value("${spring.cassandra.local-datacenter}")
	private String datacenter;

	@Override
	protected String getKeyspaceName() {
		return keyspaceName;
	}

	@Override
	protected int getPort() {
		return port;
	}

	@Override
	public SchemaAction getSchemaAction() {
		return schemaAction;
	}

	@Override
	protected String getContactPoints() {
		return contactPoints;
	}

	@Override
	protected String getLocalDataCenter() {
		return datacenter;
	}
	
	@Override
	protected List<CreateKeyspaceSpecification> getKeyspaceCreations() {
		return Collections.singletonList(
				CreateKeyspaceSpecification.createKeyspace(getKeyspaceName()).ifNotExists().withSimpleReplication(1));
	}
	
	@Override
	public CqlSessionFactoryBean cassandraSession() {
		CqlSessionFactoryBean session = new CqlSessionFactoryBean();
		session.setKeyspaceSpecifications(getKeyspaceCreations());
		session.setContactPoints(contactPoints);
		session.setLocalDatacenter(datacenter);
		session.setKeyspaceName(keyspaceName);
		session.setUsername("cassandra");
		session.setPassword("cassandra");
		session.setPort(port);
		
		return session;
	}
	
	@Override
	public CassandraAdminTemplate cassandraTemplate() {
		return super.cassandraTemplate();
	}
}
