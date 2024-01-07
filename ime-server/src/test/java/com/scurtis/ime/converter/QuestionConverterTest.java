package com.scurtis.ime.converter;

import com.scurtis.ime.dto.QuestionDto;
import com.scurtis.ime.entity.Question;
import java.time.LocalDate;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@ExtendWith(SpringExtension.class)
class QuestionConverterTest {

    private QuestionConverter converter;

    @BeforeEach
    void beforeEach() {
        converter = spy(new QuestionConverter());
    }

    @AfterEach
    void afterEach() {
        verifyNoMoreInteractions(converter);
    }

    @Test
    void testToDtoSuccess() {
        Question entity = getQuestionEntity();

        QuestionDto result = converter.toDto(entity);

        assertEquals(1L, result.getId());
        assertEquals("question", result.getQuestion());
        assertEquals("answer", result.getAnswer());
        assertEquals("skill", result.getSkill());
        assertEquals("category", result.getCategory());

        verify(converter).toDto(entity);
    }

    @Test
    void testToEntitySuccess() {
        QuestionDto dto = getQuestionDto();

        Question result = converter.toEntity(dto);

        assertEquals(1L, result.getId());
        assertEquals("question", result.getQuestion());
        assertEquals("answer", result.getAnswer());
        assertEquals("skill", result.getSkill());
        assertEquals("category", result.getCategory());

        verify(converter).toEntity(dto);
    }

    private Question getQuestionEntity() {
        return new Question(1L, "question", "answer", "skill", "category", LocalDate.now());
    }

    private QuestionDto getQuestionDto() {
        return new QuestionDto(1L, "question", "answer", "skill", "category", LocalDate.now());
    }

}
