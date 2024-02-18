package com.scurtis.ime.repository;

import com.scurtis.ime.entity.Category;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface CategoryRepository extends ReactiveCrudRepository<Category, Long> {

    @Query(value = "select * from ime.category c order by c.name")
    Flux<Category> findAllSorted();

    Mono<Category> deleteCategoryByName(String name);

}
