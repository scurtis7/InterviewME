package com.scurtis.ime.service;

import com.scurtis.ime.converter.QuestionConverter;
import com.scurtis.ime.dto.QuestionDto;
import com.scurtis.ime.exception.ImeServerException;
import com.scurtis.ime.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
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
            .map(converter::toDto)
            .onErrorMap(e -> {
                throw new ImeServerException(HttpStatus.BAD_REQUEST, e.getMessage(), e.getClass().getName());
            });
    }

    public Flux<QuestionDto> getAllQuestions() {
        log.info("QuestionService.getAllQuestions()");
        return repository.findAll()
            .map(converter::toDto)
            .onErrorMap(e -> {
                throw new ImeServerException(HttpStatus.BAD_REQUEST, e.getMessage(), e.getClass().getName());
            });
    }

    public Mono<Void> deleteQuestion(Long id) {
        log.info("QuestionService.getAllQuestions()");
        return repository.deleteById(id);
    }

}
