package com.scurtis.ime.repository;

import com.scurtis.ime.entity.Question;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends ReactiveCrudRepository<Question, Long> {
}
