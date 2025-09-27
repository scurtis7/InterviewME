package com.scurtis.ime.service;

import com.scurtis.ime.converter.QuestionConverter;
import com.scurtis.ime.dto.CriteriaDto;
import com.scurtis.ime.dto.QuestionDto;
import com.scurtis.ime.entity.Question;
import com.scurtis.ime.repository.QuestionRepository;
import java.util.Collections;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static com.scurtis.ime.TestUtils.ANSWER;
import static com.scurtis.ime.TestUtils.CATEGORY_NAME;
import static com.scurtis.ime.TestUtils.QUESTION;
import static com.scurtis.ime.TestUtils.QUESTION_ID;
import static com.scurtis.ime.TestUtils.SKILL_LEVEL_NAME;
import static com.scurtis.ime.TestUtils.getCriteriaDto;
import static com.scurtis.ime.TestUtils.getQuestionDto;
import static com.scurtis.ime.TestUtils.getQuestionEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class QuestionServiceTest {

    private QuestionService questionService;

    @Mock
    private QuestionRepository questionRepositoryMock;
    @Mock
    private QuestionConverter questionConverterMock;

    @BeforeEach
    void beforeEach() {
        questionService = spy(new QuestionService(questionRepositoryMock, questionConverterMock));
    }

    @AfterEach
    void afterEach() {
        verifyNoMoreInteractions(questionRepositoryMock);
        verifyNoMoreInteractions(questionConverterMock);
        verifyNoMoreInteractions(questionService);
    }

    @Test
    void testAddQuestionSuccess() {
        QuestionDto questionDto = getQuestionDto();
        Question questionEntity = getQuestionEntity();

        when(questionRepositoryMock.save(questionEntity)).thenReturn(Mono.just(questionEntity));
        when(questionConverterMock.toEntity(questionDto)).thenReturn(questionEntity);
        when(questionConverterMock.toDto(questionEntity)).thenReturn(questionDto);

        Mono<QuestionDto> result = questionService.addQuestion(questionDto);

        StepVerifier.create(result)
            .thenConsumeWhile(dto -> {
                assertEquals(QUESTION_ID, dto.getId());
                assertEquals(QUESTION, dto.getQuestion());
                assertEquals(ANSWER, dto.getAnswer());
                assertEquals(SKILL_LEVEL_NAME, dto.getSkill());
                assertEquals(CATEGORY_NAME, dto.getCategory());
                return true;
            })
            .verifyComplete();

        verify(questionRepositoryMock).save(questionEntity);
        verify(questionConverterMock).toEntity(questionDto);
        verify(questionConverterMock).toDto(questionEntity);
        verify(questionService).addQuestion(questionDto);
    }

    @Test
    void testGetAllQuestionsSuccess() {
        QuestionDto questionDto = getQuestionDto();
        Question questionEntity = getQuestionEntity();

        when(questionRepositoryMock.findAll()).thenReturn(Flux.just(questionEntity));
        when(questionConverterMock.toDto(questionEntity)).thenReturn(questionDto);

        Flux<QuestionDto> result = questionService.getAllQuestions();

        StepVerifier.create(result)
            .thenConsumeWhile(dto -> {
                assertEquals(QUESTION_ID, dto.getId());
                assertEquals(QUESTION, dto.getQuestion());
                assertEquals(ANSWER, dto.getAnswer());
                assertEquals(SKILL_LEVEL_NAME, dto.getSkill());
                assertEquals(CATEGORY_NAME, dto.getCategory());
                return true;
            })
            .verifyComplete();

        verify(questionRepositoryMock).findAll();
        verify(questionConverterMock).toDto(questionEntity);
        verify(questionService).getAllQuestions();
    }

    @Test
    void testSearchQuestionsWithCategoryAndSkillSuccess() {
        CriteriaDto criteriaDto = getCriteriaDto();
        Question questionEntity = getQuestionEntity();
        Flux<Question> questionFlux = Flux.just(questionEntity);
        QuestionDto questionDto = getQuestionDto();

        when(questionRepositoryMock.searchQuestionsByCategoryAndSkill(criteriaDto.getCategories(), criteriaDto.getSkills())).thenReturn(questionFlux);
        when(questionConverterMock.toDto(questionEntity)).thenReturn(questionDto);

        Flux<QuestionDto> result = questionService.searchQuestions(criteriaDto);

        StepVerifier.create(result)
            .thenConsumeWhile(dto -> {
                assertEquals(QUESTION_ID, dto.getId());
                assertEquals(QUESTION, dto.getQuestion());
                assertEquals(ANSWER, dto.getAnswer());
                assertEquals(SKILL_LEVEL_NAME, dto.getSkill());
                assertEquals(CATEGORY_NAME, dto.getCategory());
                return true;
            })
            .verifyComplete();

        verify(questionRepositoryMock).searchQuestionsByCategoryAndSkill(criteriaDto.getCategories(), criteriaDto.getSkills());
        verify(questionConverterMock).toDto(questionEntity);
        verify(questionService).searchQuestions(criteriaDto);
    }

    @Test
    void testSearchQuestionsWithCategorySuccess() {
        CriteriaDto criteriaDto = getCriteriaDto();
        criteriaDto.setSkills(Collections.emptyList());
        Question questionEntity = getQuestionEntity();
        Flux<Question> questionFlux = Flux.just(questionEntity);
        QuestionDto questionDto = getQuestionDto();

        when(questionRepositoryMock.searchQuestionsByCategory(criteriaDto.getCategories())).thenReturn(questionFlux);
        when(questionConverterMock.toDto(questionEntity)).thenReturn(questionDto);

        Flux<QuestionDto> result = questionService.searchQuestions(criteriaDto);

        StepVerifier.create(result)
            .thenConsumeWhile(dto -> {
                assertEquals(QUESTION_ID, dto.getId());
                assertEquals(QUESTION, dto.getQuestion());
                assertEquals(ANSWER, dto.getAnswer());
                assertEquals(SKILL_LEVEL_NAME, dto.getSkill());
                assertEquals(CATEGORY_NAME, dto.getCategory());
                return true;
            })
            .verifyComplete();

        verify(questionRepositoryMock).searchQuestionsByCategory(criteriaDto.getCategories());
        verify(questionConverterMock).toDto(questionEntity);
        verify(questionService).searchQuestions(criteriaDto);
    }

    @Test
    void testSearchQuestionsWithNullSkillsSuccess() {
        CriteriaDto criteriaDto = getCriteriaDto();
        criteriaDto.setSkills(null);
        Question questionEntity = getQuestionEntity();
        Flux<Question> questionFlux = Flux.just(questionEntity);
        QuestionDto questionDto = getQuestionDto();

        when(questionRepositoryMock.searchQuestionsByCategory(criteriaDto.getCategories())).thenReturn(questionFlux);
        when(questionConverterMock.toDto(questionEntity)).thenReturn(questionDto);

        Flux<QuestionDto> result = questionService.searchQuestions(criteriaDto);

        StepVerifier.create(result)
            .thenConsumeWhile(dto -> {
                assertEquals(QUESTION_ID, dto.getId());
                assertEquals(QUESTION, dto.getQuestion());
                assertEquals(ANSWER, dto.getAnswer());
                assertEquals(SKILL_LEVEL_NAME, dto.getSkill());
                assertEquals(CATEGORY_NAME, dto.getCategory());
                return true;
            })
            .verifyComplete();

        verify(questionRepositoryMock).searchQuestionsByCategory(criteriaDto.getCategories());
        verify(questionConverterMock).toDto(questionEntity);
        verify(questionService).searchQuestions(criteriaDto);
    }

    @Test
    void testSearchQuestionsWithSkillSuccess() {
        CriteriaDto criteriaDto = getCriteriaDto();
        criteriaDto.setCategories(Collections.emptyList());
        Question questionEntity = getQuestionEntity();
        Flux<Question> questionFlux = Flux.just(questionEntity);
        QuestionDto questionDto = getQuestionDto();

        when(questionRepositoryMock.searchQuestionsBySkill(criteriaDto.getSkills())).thenReturn(questionFlux);
        when(questionConverterMock.toDto(questionEntity)).thenReturn(questionDto);

        Flux<QuestionDto> result = questionService.searchQuestions(criteriaDto);

        StepVerifier.create(result)
            .thenConsumeWhile(dto -> {
                assertEquals(QUESTION_ID, dto.getId());
                assertEquals(QUESTION, dto.getQuestion());
                assertEquals(ANSWER, dto.getAnswer());
                assertEquals(SKILL_LEVEL_NAME, dto.getSkill());
                assertEquals(CATEGORY_NAME, dto.getCategory());
                return true;
            })
            .verifyComplete();

        verify(questionRepositoryMock).searchQuestionsBySkill(criteriaDto.getSkills());
        verify(questionConverterMock).toDto(questionEntity);
        verify(questionService).searchQuestions(criteriaDto);
    }

    @Test
    void testSearchQuestionsWithNullCategoriesSuccess() {
        CriteriaDto criteriaDto = getCriteriaDto();
        criteriaDto.setCategories(null);
        Question questionEntity = getQuestionEntity();
        Flux<Question> questionFlux = Flux.just(questionEntity);
        QuestionDto questionDto = getQuestionDto();

        when(questionRepositoryMock.searchQuestionsBySkill(criteriaDto.getSkills())).thenReturn(questionFlux);
        when(questionConverterMock.toDto(questionEntity)).thenReturn(questionDto);

        Flux<QuestionDto> result = questionService.searchQuestions(criteriaDto);

        StepVerifier.create(result)
            .thenConsumeWhile(dto -> {
                assertEquals(QUESTION_ID, dto.getId());
                assertEquals(QUESTION, dto.getQuestion());
                assertEquals(ANSWER, dto.getAnswer());
                assertEquals(SKILL_LEVEL_NAME, dto.getSkill());
                assertEquals(CATEGORY_NAME, dto.getCategory());
                return true;
            })
            .verifyComplete();

        verify(questionRepositoryMock).searchQuestionsBySkill(criteriaDto.getSkills());
        verify(questionConverterMock).toDto(questionEntity);
        verify(questionService).searchQuestions(criteriaDto);
    }

    @Test
    void testSearchQuestionsWithEmptyCategoriesAndSkillsSuccess() {
        CriteriaDto criteriaDto = new CriteriaDto();
        criteriaDto.setCategories(Collections.emptyList());
        criteriaDto.setSkills(Collections.emptyList());

        Flux<QuestionDto> result = questionService.searchQuestions(criteriaDto);

        StepVerifier.create(result)
            .verifyComplete();

        verify(questionService).searchQuestions(criteriaDto);
    }

    @Test
    void testSearchQuestionsWithNullCategoriesAndSkillsSuccess() {
        CriteriaDto criteriaDto = new CriteriaDto();
        criteriaDto.setCategories(null);
        criteriaDto.setSkills(null);

        Flux<QuestionDto> result = questionService.searchQuestions(criteriaDto);

        StepVerifier.create(result)
            .verifyComplete();

        verify(questionService).searchQuestions(criteriaDto);
    }

    @Test
    void testDeleteQuestionSuccess() {
        when(questionRepositoryMock.deleteById(QUESTION_ID)).thenReturn(Mono.empty());

        Mono<Void> result = questionService.deleteQuestion(QUESTION_ID);

        StepVerifier.create(result)
            .verifyComplete();

        verify(questionRepositoryMock).deleteById(QUESTION_ID);
        verify(questionService).deleteQuestion(QUESTION_ID);
    }

}
