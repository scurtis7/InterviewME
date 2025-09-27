package com.scurtis.ime.controller;

import com.scurtis.ime.dto.CategoryDto;
import com.scurtis.ime.dto.SkillLevelDto;
import com.scurtis.ime.service.InterviewService;
import java.time.LocalDate;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class InterviewControllerTest {

    private InterviewController interviewController;
    private WebTestClient webTestClient;

    @Mock
    private InterviewService interviewServiceMock;

    @BeforeEach
    void beforeEachTest() {
        interviewController = spy(new InterviewController(interviewServiceMock));
        webTestClient = WebTestClient.bindToController(interviewController).build();
    }

    @AfterEach
    void afterEachTest() {
        verifyNoMoreInteractions(interviewServiceMock);
    }

    @Test
    void testAddCategorySuccess() {
        CategoryDto body = getCategoryDto();
        Mono<CategoryDto> monoCategoryDto = Mono.just(body);

        when(interviewServiceMock.saveCategory(body)).thenReturn(monoCategoryDto);

        webTestClient.post().uri("/ime/category")
            .accept(MediaType.APPLICATION_JSON)
            .bodyValue(body)
            .exchange()
            .expectStatus().isOk()
            .expectBody(CategoryDto.class)
            .isEqualTo(body);

        verify(interviewServiceMock).saveCategory(body);
        verify(interviewController).addCategory(body);
    }

    @Test
    void testGetAllCategoriesSuccess() {
        webTestClient.get().uri("/ime/category")
            .exchange()
            .expectStatus().isOk()
            .expectBodyList(CategoryDto.class);

        verify(interviewServiceMock).getAllCategories();
        verify(interviewController).getAllCategories();
    }

    @Test
    void testGetAllSkillLevelsSuccess() {
        webTestClient.get().uri("/ime/skill")
            .exchange()
            .expectStatus().isOk()
            .expectBodyList(SkillLevelDto.class);

        verify(interviewServiceMock).getAllSkillLevels();
        verify(interviewController).getAllSkillLevels();
    }

    @Test
    void testDeleteCategorySuccess() {
        webTestClient.delete().uri("/ime/category?name=category")
            .exchange()
            .expectStatus().isOk()
            .expectBodyList(SkillLevelDto.class);

        verify(interviewServiceMock).deleteCategoryByName("CATEGORY");
        verify(interviewController).deleteCategory("category");
    }

    private CategoryDto getCategoryDto() {
        return new CategoryDto(1L, "name", LocalDate.now());
    }

}
