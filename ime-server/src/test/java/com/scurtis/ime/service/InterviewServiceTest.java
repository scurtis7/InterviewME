package com.scurtis.ime.service;

import com.scurtis.ime.converter.CategoryConverter;
import com.scurtis.ime.converter.SkillLevelConverter;
import com.scurtis.ime.dto.CategoryDto;
import com.scurtis.ime.dto.SkillLevelDto;
import com.scurtis.ime.entity.Category;
import com.scurtis.ime.entity.SkillLevel;
import com.scurtis.ime.exception.ImeServerException;
import com.scurtis.ime.repository.CategoryRepository;
import com.scurtis.ime.repository.SkillLevelRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static com.scurtis.ime.TestUtils.CATEGORY_ID;
import static com.scurtis.ime.TestUtils.CATEGORY_NAME;
import static com.scurtis.ime.TestUtils.SKILL_LEVEL_NAME;
import static com.scurtis.ime.TestUtils.getCategoryDto;
import static com.scurtis.ime.TestUtils.getCategoryEntity;
import static com.scurtis.ime.TestUtils.getSkillLevelDto;
import static com.scurtis.ime.TestUtils.getSkillLevelEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class InterviewServiceTest {

    private InterviewService interviewService;

    @Mock
    private CategoryRepository categoryRepositoryMock;
    @Mock
    private CategoryConverter categoryConverterMock;
    @Mock
    private SkillLevelRepository skillLevelRepositoryMock;
    @Mock
    private SkillLevelConverter skillLevelConverterMock;

    @BeforeEach
    void beforeEachTest() {
        interviewService = spy(new InterviewService(categoryRepositoryMock, categoryConverterMock, skillLevelRepositoryMock, skillLevelConverterMock));
    }

    @AfterEach
    void afterEachTest() {
        verifyNoMoreInteractions(categoryRepositoryMock);
        verifyNoMoreInteractions(categoryConverterMock);
        verifyNoMoreInteractions(skillLevelRepositoryMock);
        verifyNoMoreInteractions(skillLevelConverterMock);
        verifyNoMoreInteractions(interviewService);
    }

    @Test
    void testSaveCategorySuccess() {
        Category entity = getCategoryEntity();
        CategoryDto dto = getCategoryDto();

        when(categoryRepositoryMock.save(entity)).thenReturn(Mono.just(entity));
        when(categoryConverterMock.toEntity(dto)).thenReturn(entity);
        when(categoryConverterMock.toDto(entity)).thenReturn(dto);

        Mono<CategoryDto> result = interviewService.saveCategory(dto);

        StepVerifier.create(result)
            .thenConsumeWhile(categoryDto -> {
                assertEquals(CATEGORY_ID, categoryDto.getId());
                assertEquals(CATEGORY_NAME, categoryDto.getName());
                return true;
            })
            .verifyComplete();

        verify(categoryRepositoryMock).save(entity);
        verify(categoryConverterMock).toEntity(dto);
        verify(categoryConverterMock).toDto(entity);
        verify(interviewService).saveCategory(dto);
    }

    @Test
    void testSaveCategoryWithNullDtoThrowsException() {
        CategoryDto dto = getCategoryDto();
        dto.setName(null);
        Throwable result = assertThrows(ImeServerException.class, () -> interviewService.saveCategory(dto));

        assertEquals("Category may not be blank", result.getMessage());
        verify(interviewService).saveCategory(dto);
    }

    @Test
    void testGetAllCategoriesSuccess() {
        Category entity = getCategoryEntity();
        CategoryDto dto = getCategoryDto();

        when(categoryRepositoryMock.findAll()).thenReturn(Flux.just(entity));
        when(categoryConverterMock.toDto(entity)).thenReturn(dto);

        Flux<CategoryDto> result = interviewService.getAllCategories();

        StepVerifier.create(result)
            .thenConsumeWhile(categoryDto -> {
                assertEquals(CATEGORY_NAME, categoryDto.getName());
                return true;
            })
            .verifyComplete();

        verify(categoryRepositoryMock).findAll();
        verify(categoryConverterMock).toDto(any());
        verify(interviewService).getAllCategories();
    }

    @Test
    void testDeleteCategorySuccess() {
        Category entity = getCategoryEntity();

        when(categoryRepositoryMock.deleteCategoryByName(CATEGORY_NAME)).thenReturn(Mono.just(entity));

        Mono<Category> result = interviewService.deleteCategoryByName(CATEGORY_NAME);

        StepVerifier.create(result)
            .thenConsumeWhile(category -> {
                assertEquals(CATEGORY_ID, category.getId());
                assertEquals(CATEGORY_NAME, category.getName());
                return true;
            })
            .verifyComplete();

        verify(categoryRepositoryMock).deleteCategoryByName(CATEGORY_NAME);
        verify(interviewService).deleteCategoryByName(CATEGORY_NAME);
    }

    @Test
    void testGetAllSkillLevelsSuccess() {
        SkillLevel entity = getSkillLevelEntity();
        SkillLevelDto dto = getSkillLevelDto();

        when(skillLevelRepositoryMock.findAll()).thenReturn(Flux.just(entity));
        when(skillLevelConverterMock.toDto(entity)).thenReturn(dto);

        Flux<SkillLevelDto> result = interviewService.getAllSkillLevels();

        StepVerifier.create(result)
            .thenConsumeWhile(skillLevelDto -> {
                assertEquals(SKILL_LEVEL_NAME, skillLevelDto.getName());
                return true;
            })
            .verifyComplete();

        verify(skillLevelRepositoryMock).findAll();
        verify(skillLevelConverterMock).toDto(any());
        verify(interviewService).getAllSkillLevels();
    }

}
