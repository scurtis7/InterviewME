package com.scurtis.ime.controller;

import com.scurtis.ime.dto.QuestionDto;
import com.scurtis.ime.service.QuestionService;
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
@WebFluxTest(controllers = QuestionController.class)
class QuestionControllerTest {

    @MockBean
    private QuestionService mockQuestionService;

    @Autowired
    private WebTestClient webTestClient;

    @AfterEach
    void afterEach() {
        verifyNoMoreInteractions(mockQuestionService);
    }

    @Test
    void testAddQuestionSuccess() {
        QuestionDto body = getQuestionDto();
        Mono<QuestionDto> monoQuestionDto = Mono.just(body);

        when(mockQuestionService.addQuestion(body)).thenReturn(monoQuestionDto);

        webTestClient.post().uri("/ime/question")
            .accept(MediaType.APPLICATION_JSON)
            .bodyValue(body)
            .exchange()
            .expectStatus().isOk()
            .expectBody(QuestionDto.class)
            .isEqualTo(body);

        verify(mockQuestionService).addQuestion(body);
    }

    @Test
    void testGetAllQuestionsSuccess() {
        webTestClient.get().uri("/ime/question")
            .exchange()
            .expectStatus().isOk()
            .expectBodyList(QuestionDto.class);

        verify(mockQuestionService).getAllQuestions();
    }

    private QuestionDto getQuestionDto() {
        return new QuestionDto(1L, "question", "answer", "skill", "category", LocalDate.now());
    }


}
