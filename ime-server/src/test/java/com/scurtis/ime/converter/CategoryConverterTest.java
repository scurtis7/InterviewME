package com.scurtis.ime.converter;

import com.scurtis.ime.dto.CategoryDto;
import com.scurtis.ime.entity.Category;
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
class CategoryConverterTest {

    private CategoryConverter converter;

    @BeforeEach
    void beforeEach() {
        converter = spy(new CategoryConverter());
    }

    @AfterEach
    void afterEach() {
        verifyNoMoreInteractions(converter);
    }

    @Test
    void testToDtoSuccess() {
        Category entity = getCategoryEntity();

        CategoryDto result = converter.toDto(entity);

        assertEquals(1L, result.getId());
        assertEquals("Java", result.getName());

        verify(converter).toDto(entity);
    }

    @Test
    void testToEntitySuccess() {
        CategoryDto dto = getCategoryDto();

        Category result = converter.toEntity(dto);

        assertEquals(1L, result.getId());
        assertEquals("Java", result.getName());

        verify(converter).toEntity(dto);
    }

    private Category getCategoryEntity() {
        return new Category(1L, "Java", LocalDate.now());
    }

    private CategoryDto getCategoryDto() {
        return new CategoryDto(1L, "Java", LocalDate.now());
    }

}
