package com.scurtis.ime.controller;

import com.scurtis.ime.dto.QuestionDto;
import com.scurtis.ime.service.QuestionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("ime/question")
public class QuestionController {

    private final QuestionService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<QuestionDto> addQuestion(@RequestBody QuestionDto dto) {
        log.info("QuestionController.addQuestion()   {}", dto.toString());
        return service.addQuestion(dto);
    }

    @GetMapping()
    public Flux<QuestionDto> getAllQuestions() {
        log.info("QuestionController.getAllQuestions()");
        return service.getAllQuestions();
    }

    @DeleteMapping
    public Mono<Void> deleteQuestion(@RequestParam(name = "id") Long id) {
        log.info("QuestionController.deleteQuestion() with id {}", id);
        return service.deleteQuestion(id);
    }

}
