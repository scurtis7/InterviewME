package com.scurtis.ime.service;

import com.scurtis.ime.converter.CategoryConverter;
import com.scurtis.ime.converter.SkillLevelConverter;
import com.scurtis.ime.dto.CategoryDto;
import com.scurtis.ime.dto.SkillLevelDto;
import com.scurtis.ime.entity.Category;
import com.scurtis.ime.exception.ImeServerException;
import com.scurtis.ime.repository.CategoryRepository;
import com.scurtis.ime.repository.SkillLevelRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class InterviewService {

    private final CategoryRepository categoryRepository;
    private final CategoryConverter categoryConverter;
    private final SkillLevelRepository skillLevelRepository;
    private final SkillLevelConverter skillLevelConverter;

    public Mono<CategoryDto> saveCategory(CategoryDto dto) {
        log.info("InterviewService.saveCategory()   {}", dto.toString());
        validateCategory(dto);
        return categoryRepository.save(categoryConverter.toEntity(dto))
            .map(categoryConverter::toDto)
            .onErrorMap(e -> {
                throw new ImeServerException(HttpStatus.BAD_REQUEST, e.getMessage(), e.getClass().getName());
            });
    }

    public Flux<CategoryDto> getAllCategories() {
        log.info("InterviewService.getAllCategories()");
        return categoryRepository.findAll()
            .map(categoryConverter::toDto)
            .sort()
            .onErrorMap(e -> {
                throw new ImeServerException(HttpStatus.BAD_REQUEST, e.getMessage(), e.getClass().getName());
            });
    }

    public Mono<Category> deleteCategoryByName(String name) {
        return categoryRepository.deleteCategoryByName(name)
            .onErrorMap(e -> {
                throw new ImeServerException(HttpStatus.BAD_REQUEST, e.getMessage(), e.getClass().getName());
            });
    }

    public Flux<SkillLevelDto> getAllSkillLevels() {
        log.info("InterviewService.getAllSkillLevels()");
        return skillLevelRepository.findAll()
            .map(skillLevelConverter::toDto)
            .onErrorMap(e -> {
                throw new ImeServerException(HttpStatus.BAD_REQUEST, e.getMessage(), e.getClass().getName());
            });
    }

    private void validateCategory(CategoryDto dto) {
        if (!StringUtils.hasText(dto.getName())) {
            throw new ImeServerException(HttpStatus.BAD_REQUEST, "Category may not be blank", null);
        }
    }

}
