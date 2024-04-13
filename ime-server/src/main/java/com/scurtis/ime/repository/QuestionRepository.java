package com.scurtis.ime.repository;

import com.scurtis.ime.entity.Question;
import java.util.List;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface QuestionRepository extends ReactiveCrudRepository<Question, Long> {

    @Query(value = "SELECT * FROM ime.question Q WHERE Q.category IN (:categories)")
    Flux<Question> searchQuestionsByCategory(List<String> categories);

    @Query(value = "SELECT * FROM ime.question Q WHERE Q.skill IN (:skills)")
    Flux<Question> searchQuestionsBySkill(List<String> skills);

    @Query(value = "SELECT * FROM ime.question Q WHERE Q.category IN (:categories) AND Q.skill IN (:skills)")
    Flux<Question> searchQuestionsByCategoryAndSkill(List<String> categories, List<String> skills);

}
