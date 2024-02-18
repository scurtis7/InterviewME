package com.scurtis.ime.repository;

import com.scurtis.ime.entity.Category;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface CategoryRepository extends ReactiveCrudRepository<Category, Long> {

    Mono<Category> deleteCategoryByName(String name);

}
