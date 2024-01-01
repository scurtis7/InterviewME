package com.scurtis.ime.repository;

import com.scurtis.ime.entity.Category;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CategoryRepository extends ReactiveCrudRepository<Category, Integer> {
}
