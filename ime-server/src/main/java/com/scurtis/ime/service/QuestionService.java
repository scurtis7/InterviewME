package com.scurtis.ime.service;

import com.scurtis.ime.converter.QuestionConverter;
import com.scurtis.ime.dto.CriteriaDto;
import com.scurtis.ime.dto.QuestionDto;
import com.scurtis.ime.exception.ImeServerException;
import com.scurtis.ime.repository.QuestionRepository;
import java.util.List;
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
            .sort()
            .onErrorMap(e -> {
                throw new ImeServerException(HttpStatus.BAD_REQUEST, e.getMessage(), e.getClass().getName());
            });
    }

    public Flux<QuestionDto> searchQuestions(CriteriaDto dto) {
        log.info("QuestionService.searchQuestions()");
        if (dto.getCategories().isEmpty() && dto.getSkills().isEmpty()) {
            return Flux.empty();
        } else if (dto.getCategories().isEmpty()) {
            return repository.searchQuestionsBySkill(dto.getSkills())
                .map(converter::toDto);
        } else if (dto.getSkills().isEmpty()) {
            return repository.searchQuestionsByCategory(dto.getCategories())
                .map(converter::toDto);
        } else {
            return repository.searchQuestionsByCategoryAndSkill(dto.getCategories(), dto.getSkills())
                .map(converter::toDto);
        }
    }

    public Mono<Void> deleteQuestion(Long id) {
        log.info("QuestionService.deleteQuestion()");
        return repository.deleteById(id);
    }

}
