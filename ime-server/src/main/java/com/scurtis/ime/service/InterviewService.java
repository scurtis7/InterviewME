package com.scurtis.ime.service;

import com.scurtis.ime.converter.CategoryConverter;
import com.scurtis.ime.converter.SkillLevelConverter;
import com.scurtis.ime.dto.CategoryDto;
import com.scurtis.ime.dto.SkillLevelDto;
import com.scurtis.ime.repository.CategoryRepository;
import com.scurtis.ime.repository.SkillLevelRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
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

    public Mono<CategoryDto> addCategory(CategoryDto dto) {
        log.info("InterviewService.addCategory()   {}", dto.toString());
        return categoryRepository.save(categoryConverter.toEntity(dto))
            .map(categoryConverter::toDto);
    }

    public Flux<CategoryDto> getAllCategories() {
        log.info("InterviewService.getAllCategories()");
        return categoryRepository.findAll()
            .map(categoryConverter::toDto);
    }

    public Flux<SkillLevelDto> getAllSkillLevels() {
        log.info("InterviewService.getAllSkillLevels()");
        return skillLevelRepository.findAll()
            .map(skillLevelConverter::toDto);
    }

}
