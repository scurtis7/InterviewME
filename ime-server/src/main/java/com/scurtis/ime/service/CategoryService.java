package com.scurtis.ime.service;

import com.scurtis.ime.entity.Category;
import com.scurtis.ime.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository repository;

    public Mono<Category> saveCategory(Category category) {
        return repository.save(category);
    }

}
