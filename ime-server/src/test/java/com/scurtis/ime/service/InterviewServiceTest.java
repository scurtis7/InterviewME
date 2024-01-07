package com.scurtis.ime.service;

import com.scurtis.ime.converter.CategoryConverter;
import com.scurtis.ime.dto.CategoryDto;
import com.scurtis.ime.entity.Category;
import com.scurtis.ime.repository.CategoryRepository;
import java.time.LocalDate;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class InterviewServiceTest {

    private InterviewService interviewService;

    @Mock
    private CategoryRepository mockRepository;

    @Mock
    private CategoryConverter mockConverter;

    @BeforeEach
    void beforeEach() {
        interviewService = spy(new InterviewService(mockRepository, mockConverter));
    }

    @AfterEach
    void afterEach() {
        verifyNoMoreInteractions(mockRepository);
        verifyNoMoreInteractions(mockConverter);
        verifyNoMoreInteractions(interviewService);
    }

    @Test
    void saveCategorySuccess() {
        Category entity = getEntity();
        CategoryDto dto = getDto();

        when(mockRepository.save(entity)).thenReturn(Mono.just(entity));
        when(mockConverter.toEntity(dto)).thenReturn(entity);
        when(mockConverter.toDto(entity)).thenReturn(dto);

        Mono<CategoryDto> result = interviewService.addCategory(dto);

        StepVerifier.create(result)
            .thenConsumeWhile(r -> {
                assertEquals("name", r.getName());
                return true;
            })
            .verifyComplete();

        verify(mockRepository).save(entity);
        verify(mockConverter).toEntity(dto);
        verify(mockConverter).toDto(entity);
        verify(interviewService).addCategory(dto);
    }

    private Category getEntity() {
        return new Category(null, "name", null);
    }

    private CategoryDto getDto() {
        return new CategoryDto(1L, "name", LocalDate.now());
    }

}
