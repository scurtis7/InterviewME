package com.scurtis.ime.controller;

import com.scurtis.ime.entity.Category;
import com.scurtis.ime.service.CategoryService;
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
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = InterviewController.class)
@Import(CategoryService.class)
class InterviewControllerTest {

    @MockBean
    private CategoryService categoryService;

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void addCategorySuccess() {
        Category body = getCategory();
        Mono<Category> monoCategory = Mono.just(body);

        when(categoryService.addCategory(body)).thenReturn(monoCategory);

        webTestClient.post().uri("/ime/category")
            .accept(MediaType.APPLICATION_JSON)
            .bodyValue(body)
            .exchange()
            .expectStatus().isOk()
            .expectBody(Category.class);

        verify(categoryService).addCategory(body);
    }

    private Category getCategory() {
        Category category = new Category();
        category.setName("name");
        return category;
    }

}
