package com.scurtis.ime.service;

import com.scurtis.ime.converter.QuestionConverter;
import com.scurtis.ime.dto.QuestionDto;
import com.scurtis.ime.entity.Question;
import com.scurtis.ime.repository.QuestionRepository;
import java.time.LocalDate;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class QuestionServiceTest {

    private QuestionService questionService;

    @Mock
    private QuestionRepository mockRepository;
    @Mock
    private QuestionConverter mockConverter;

    @BeforeEach
    void beforeEach() {
        questionService = spy(new QuestionService(mockRepository, mockConverter));
    }

    @AfterEach
    void afterEach() {
        verifyNoMoreInteractions(mockRepository);
        verifyNoMoreInteractions(mockConverter);
        verifyNoMoreInteractions(questionService);
    }

    @Test
    void testAddQuestionSuccess() {
        QuestionDto questionDto = getQuestionDto();
        Question questionEntity = getQuestionEntity();

        when(mockRepository.save(questionEntity)).thenReturn(Mono.just(questionEntity));
        when(mockConverter.toEntity(questionDto)).thenReturn(questionEntity);
        when(mockConverter.toDto(questionEntity)).thenReturn(questionDto);

        Mono<QuestionDto> result = questionService.addQuestion(questionDto);

        StepVerifier.create(result)
            .thenConsumeWhile(dto -> {
                assertEquals(1L, dto.getId());
                assertEquals("question", dto.getQuestion());
                assertEquals("answer", dto.getAnswer());
                assertEquals("skill", dto.getSkill());
                assertEquals("category", dto.getCategory());
                return true;
            })
            .verifyComplete();

        verify(mockRepository).save(questionEntity);
        verify(mockConverter).toEntity(questionDto);
        verify(mockConverter).toDto(questionEntity);
        verify(questionService).addQuestion(questionDto);
    }

    @Test
    void testGetAllQuestionsSuccess() {
        QuestionDto questionDto = getQuestionDto();
        Question questionEntity = getQuestionEntity();

        when(mockRepository.findAll()).thenReturn(Flux.just(questionEntity));
        when(mockConverter.toDto(questionEntity)).thenReturn(questionDto);

        Flux<QuestionDto> result = questionService.getAllQuestions();

        StepVerifier.create(result)
            .thenConsumeWhile(dto -> {
                assertEquals(1L, dto.getId());
                assertEquals("question", dto.getQuestion());
                assertEquals("answer", dto.getAnswer());
                assertEquals("skill", dto.getSkill());
                assertEquals("category", dto.getCategory());
                return true;
            })
            .verifyComplete();

        verify(mockRepository).findAll();
        verify(mockConverter).toDto(questionEntity);
        verify(questionService).getAllQuestions();
    }

    private QuestionDto getQuestionDto() {
        return new QuestionDto(1L, "question", "answer", "skill", "category", LocalDate.now());
    }

    private Question getQuestionEntity() {
        return new Question(1L, "question", "answer", "skill", "category", LocalDate.now());
    }

}
