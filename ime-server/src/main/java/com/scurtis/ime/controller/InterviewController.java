package com.scurtis.ime.controller;

import com.scurtis.ime.dto.CategoryDto;
import com.scurtis.ime.dto.SkillLevelDto;
import com.scurtis.ime.service.InterviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("ime")
public class InterviewController {

    private final InterviewService interviewService;

    @PostMapping(path = "category", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<CategoryDto> addCategory(@RequestBody CategoryDto dto) {
        log.info("InterviewController.addCategory()   {}", dto.toString());
        return interviewService.addCategory(dto);
    }

    @GetMapping(path = "category")
    public Flux<CategoryDto> getAllCategories() {
        log.info("InterviewController.getAllCategories()");
        return interviewService.getAllCategories();
    }

    @GetMapping(path = "skill_level")
    public Flux<SkillLevelDto> getAllSkillLevels() {
        log.info("InterviewController.getAllSkillLevels()");
        return interviewService.getAllSkillLevels();
    }

}
