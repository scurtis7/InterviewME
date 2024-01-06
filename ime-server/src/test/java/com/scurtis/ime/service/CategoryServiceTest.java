package com.scurtis.ime.service;

import com.scurtis.ime.entity.Category;
import com.scurtis.ime.repository.CategoryRepository;
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
class CategoryServiceTest {

    private CategoryService categoryService;

    @Mock
    private CategoryRepository categoryRepository;

    @BeforeEach
    void beforeEach() {
        categoryService = spy(new CategoryService(categoryRepository));
    }

    @AfterEach
    void afterEach() {
        verifyNoMoreInteractions(categoryRepository);
        verifyNoMoreInteractions(categoryService);
    }

    @Test
    void saveCategorySuccess() {
        Category category = getCategory();

        when(categoryRepository.save(category)).thenReturn(Mono.just(category));

        Mono<Category> result = categoryService.addCategory(category);

        StepVerifier.create(result)
            .thenConsumeWhile(r -> {
                assertEquals("name", r.getName());
                return true;
            })
            .verifyComplete();

        verify(categoryRepository).save(category);
        verify(categoryService).addCategory(category);
    }

    private Category getCategory() {
        Category category = new Category();
        category.setName("name");
        return category;
    }

}
