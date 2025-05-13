package com.lido.schedulertasks.infrastructure.repository;

import com.lido.schedulertasks.infrastructure.entity.Tasks;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TasksRepository extends MongoRepository<Tasks, String> {
}
