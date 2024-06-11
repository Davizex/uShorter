package com.usto.re.ushort.repositories;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.usto.re.ushort.entities.TinyUrl;

@Repository
public interface TinyUrlRepository extends CassandraRepository<TinyUrl, String> {

}
