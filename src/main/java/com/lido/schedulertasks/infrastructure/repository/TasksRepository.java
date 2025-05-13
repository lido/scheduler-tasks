package com.lido.schedulertasks.infrastructure.repository;

import com.lido.schedulertasks.infrastructure.entity.Tasks;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TasksRepository extends MongoRepository<Tasks, String> {

    List<Tasks> findByDateOfEventBetween(LocalDateTime startDate, LocalDateTime finishDate);

    List<Tasks> findByUserEmail(String email);
}
