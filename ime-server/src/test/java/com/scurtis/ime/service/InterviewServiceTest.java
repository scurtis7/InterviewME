package com.scurtis.ime.service;

import com.scurtis.ime.converter.CategoryConverter;
import com.scurtis.ime.converter.SkillLevelConverter;
import com.scurtis.ime.dto.CategoryDto;
import com.scurtis.ime.dto.SkillLevelDto;
import com.scurtis.ime.entity.Category;
import com.scurtis.ime.entity.SkillLevel;
import com.scurtis.ime.repository.CategoryRepository;
import com.scurtis.ime.repository.SkillLevelRepository;
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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class InterviewServiceTest {

    private InterviewService interviewService;

    @Mock
    private CategoryRepository mockCategoryRepository;
    @Mock
    private CategoryConverter mockCategoryConverter;
    @Mock
    private SkillLevelRepository mockSkillLevelRepository;
    @Mock
    private SkillLevelConverter mockSkillLevelConverter;

    @BeforeEach
    void beforeEach() {
        interviewService = spy(new InterviewService(mockCategoryRepository, mockCategoryConverter, mockSkillLevelRepository, mockSkillLevelConverter));
    }

    @AfterEach
    void afterEach() {
        verifyNoMoreInteractions(mockCategoryRepository);
        verifyNoMoreInteractions(mockCategoryConverter);
        verifyNoMoreInteractions(mockSkillLevelRepository);
        verifyNoMoreInteractions(mockSkillLevelConverter);
        verifyNoMoreInteractions(interviewService);
    }

    @Test
    void testSaveCategorySuccess() {
        Category entity = getCategoryEntity();
        CategoryDto dto = getCategoryDto();

        when(mockCategoryRepository.save(entity)).thenReturn(Mono.just(entity));
        when(mockCategoryConverter.toEntity(dto)).thenReturn(entity);
        when(mockCategoryConverter.toDto(entity)).thenReturn(dto);

        Mono<CategoryDto> result = interviewService.addCategory(dto);

        StepVerifier.create(result)
            .thenConsumeWhile(categoryDto -> {
                assertEquals(1L, categoryDto.getId());
                assertEquals("Java", categoryDto.getName());
                return true;
            })
            .verifyComplete();

        verify(mockCategoryRepository).save(entity);
        verify(mockCategoryConverter).toEntity(dto);
        verify(mockCategoryConverter).toDto(entity);
        verify(interviewService).addCategory(dto);
    }

    @Test
    void testGetAllCategoriesSuccess() {
        Category entity = getCategoryEntity();
        CategoryDto dto = getCategoryDto();

        when(mockCategoryRepository.findAll()).thenReturn(Flux.just(entity));
        when(mockCategoryConverter.toDto(entity)).thenReturn(dto);

        Flux<CategoryDto> result = interviewService.getAllCategories();

        StepVerifier.create(result)
            .thenConsumeWhile(categoryDto -> {
                assertEquals("Java", categoryDto.getName());
                return true;
            })
            .verifyComplete();

        verify(mockCategoryRepository).findAll();
        verify(mockCategoryConverter).toDto(any());
        verify(interviewService).getAllCategories();
    }

    @Test
    void testGetAllSkillLevelsSuccess() {
        SkillLevel entity = getSkillLevelEntity();
        SkillLevelDto dto = getSkillLevelDto();

        when(mockSkillLevelRepository.findAll()).thenReturn(Flux.just(entity));
        when(mockSkillLevelConverter.toDto(entity)).thenReturn(dto);

        Flux<SkillLevelDto> result = interviewService.getAllSkillLevels();

        StepVerifier.create(result)
            .thenConsumeWhile(skillLevelDto -> {
                assertEquals("Easy", skillLevelDto.getName());
                return true;
            })
            .verifyComplete();

        verify(mockSkillLevelRepository).findAll();
        verify(mockSkillLevelConverter).toDto(any());
        verify(interviewService).getAllSkillLevels();
    }

    private Category getCategoryEntity() {
        return new Category(null, "Java", null);
    }

    private CategoryDto getCategoryDto() {
        return new CategoryDto(1L, "Java", LocalDate.now());
    }

    private SkillLevel getSkillLevelEntity() {
        return new SkillLevel(1L, "Easy", LocalDate.now());
    }

    private SkillLevelDto getSkillLevelDto() {
        return new SkillLevelDto(1L, "Easy", LocalDate.now());
    }

}
