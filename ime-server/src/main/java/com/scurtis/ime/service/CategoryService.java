package com.scurtis.ime.service;

import com.scurtis.ime.converter.CategoryConverter;
import com.scurtis.ime.dto.CategoryDto;
import com.scurtis.ime.entity.Category;
import com.scurtis.ime.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository repository;
    private final CategoryConverter converter;

    public Mono<CategoryDto> addCategory(Category category) {
        log.info("CategoryService.addCategory()   {}", category.toString());
        return repository.save(category)
            .map(converter::toDto);
    }

    public Flux<CategoryDto> getAllCategories() {
        log.info("CategoryService.getAllCategories()");
        return repository.findAll()
            .map(converter::toDto);
    }

}
