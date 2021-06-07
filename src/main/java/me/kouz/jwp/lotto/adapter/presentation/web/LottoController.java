package me.kouz.jwp.lotto.adapter.presentation.web;

import lombok.RequiredArgsConstructor;
import me.kouz.jwp.lotto.application.LottoService;
import me.kouz.jwp.lotto.application.dto.LottoRequest;
import me.kouz.jwp.lotto.application.dto.LottoResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
public class LottoController {
    private final LottoService lottoService;

    @PostMapping("/lotto-ticket")
    public Mono<LottoResponse> saveAll(@RequestBody Mono<LottoRequest> request) {
        return lottoService.createLottoTickets(request);
    }

    @GetMapping("/lotto-ticket")
    public Mono<LottoResponse> findAll() {
        return lottoService.findLottoTickets();
    }
}
