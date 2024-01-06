package com.scurtis.ime.controller;

import com.scurtis.ime.entity.Category;
import com.scurtis.ime.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("ime")
public class InterviewController {

    private final CategoryService categoryService;

    @PostMapping(path = "category", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Category> addCategory(@RequestBody Category category) {
        log.info("InterviewController.addCategory()   {}", category.toString());
        return categoryService.addCategory(category);
    }

}
