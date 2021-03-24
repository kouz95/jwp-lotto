package me.kouz.jwp.lotto;

import me.kouz.jwp.lotto.application.dto.LottoRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

@AutoConfigureWebTestClient
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class JwpLottoApplicationTests {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void buyLotto() {
        webTestClient.post()
                .uri("/lotto-ticket")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(new LottoRequest(14_000))
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$..lottoTickets.length()").isEqualTo(14)
                .jsonPath("$..lottoTickets[0]..lottoNumbers.length()").isEqualTo(6);
    }
}
