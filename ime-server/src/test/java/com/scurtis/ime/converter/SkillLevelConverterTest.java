package com.scurtis.ime.converter;

import com.scurtis.ime.dto.SkillLevelDto;
import com.scurtis.ime.entity.SkillLevel;
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
class SkillLevelConverterTest {

    private SkillLevelConverter converter;

    @BeforeEach
    void beforeEach() {
        converter = spy(new SkillLevelConverter());
    }

    @AfterEach
    void afterEach() {
        verifyNoMoreInteractions(converter);
    }

    @Test
    void testToDtoSuccess() {
        SkillLevel entity = getSkillLevelEntity();

        SkillLevelDto result = converter.toDto(entity);

        assertEquals(1L, result.getId());
        assertEquals("Easy", result.getName());

        verify(converter).toDto(entity);
    }

    private SkillLevel getSkillLevelEntity() {
        return new SkillLevel(1L, "Easy", LocalDate.now());
    }

}
