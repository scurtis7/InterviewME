package com.scurtis.ime.service;

import com.scurtis.ime.converter.QuestionConverter;
import com.scurtis.ime.dto.QuestionDto;
import com.scurtis.ime.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository repository;
    private final QuestionConverter converter;

    public Mono<QuestionDto> addQuestion(QuestionDto dto) {
        log.info("QuestionService.addQuestion()   {}", dto.toString());
        return repository.save(converter.toEntity(dto))
            .map(converter::toDto);
    }

    public Flux<QuestionDto> getAllQuestions() {
        log.info("QuestionService.getAllQuestions()");
        return repository.findAll()
            .map(converter::toDto);
    }

}