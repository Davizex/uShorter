package com.usto.re.ushort.repositories;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.usto.re.ushort.entities.AccessCount;
import com.usto.re.ushort.entities.AccessCountKey;

@Repository
public interface AccessCountRepository extends CassandraRepository<AccessCount, AccessCountKey>{

}
