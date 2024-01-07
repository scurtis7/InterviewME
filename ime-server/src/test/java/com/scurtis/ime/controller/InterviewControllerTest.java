package com.scurtis.ime.controller;

import com.scurtis.ime.dto.CategoryDto;
import com.scurtis.ime.entity.Category;
import com.scurtis.ime.service.InterviewService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = InterviewController.class)
@Import(InterviewService.class)
class InterviewControllerTest {

    @MockBean
    private InterviewService interviewService;

    @Autowired
    private WebTestClient webTestClient;

    @AfterEach
    void afterEach() {
        verifyNoMoreInteractions(interviewService);
    }

    @Test
    void addCategorySuccess() {
        CategoryDto body = getCategory();
        Mono<CategoryDto> monoCategory = Mono.just(body);

        when(interviewService.addCategory(body)).thenReturn(monoCategory);

        webTestClient.post().uri("/ime/category")
            .accept(MediaType.APPLICATION_JSON)
            .bodyValue(body)
            .exchange()
            .expectStatus().isOk()
            .expectBody(Category.class);

        verify(interviewService).addCategory(body);
    }

    private CategoryDto getCategory() {
        return new CategoryDto(null, "name", null);
    }

}
