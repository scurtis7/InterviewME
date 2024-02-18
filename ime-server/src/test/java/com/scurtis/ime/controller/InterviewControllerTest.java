package com.scurtis.ime.controller;

import com.scurtis.ime.dto.CategoryDto;
import com.scurtis.ime.dto.SkillLevelDto;
import com.scurtis.ime.service.InterviewService;
import java.time.LocalDate;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = InterviewController.class)
class InterviewControllerTest {

    @MockBean
    private InterviewService mockInterviewService;

    @Autowired
    private WebTestClient webTestClient;

    @AfterEach
    void afterEach() {
        verifyNoMoreInteractions(mockInterviewService);
    }

    @Test
    void testAddCategorySuccess() {
        CategoryDto body = getCategoryDto();
        Mono<CategoryDto> monoCategoryDto = Mono.just(body);

        when(mockInterviewService.saveCategory(body)).thenReturn(monoCategoryDto);

        webTestClient.post().uri("/ime/category")
            .accept(MediaType.APPLICATION_JSON)
            .bodyValue(body)
            .exchange()
            .expectStatus().isOk()
            .expectBody(CategoryDto.class)
            .isEqualTo(body);

        verify(mockInterviewService).saveCategory(body);
    }

    @Test
    void testGetAllCategoriesSuccess() {
        webTestClient.get().uri("/ime/category")
            .exchange()
            .expectStatus().isOk()
            .expectBodyList(CategoryDto.class);

        verify(mockInterviewService).getAllCategories();
    }

    @Test
    void testGetAllSkillLevelsSuccess() {
        webTestClient.get().uri("/ime/skill_level")
            .exchange()
            .expectStatus().isOk()
            .expectBodyList(SkillLevelDto.class);

        verify(mockInterviewService).getAllSkillLevels();
    }

    private CategoryDto getCategoryDto() {
        return new CategoryDto(1L, "name", LocalDate.now());
    }

}
