package me.kouz.jwp.lotto.application;

import lombok.RequiredArgsConstructor;
import me.kouz.jwp.lotto.application.dto.LottoRequest;
import me.kouz.jwp.lotto.application.dto.LottoResponse;
import me.kouz.jwp.lotto.domain.model.LottoRepository;
import me.kouz.jwp.lotto.domain.model.LottoTicket;
import me.kouz.jwp.lotto.domain.model.LottoTicketFactory;
import me.kouz.jwp.lotto.domain.model.PurchaseAmount;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import reactor.core.publisher.Mono;

import java.util.List;

@RequiredArgsConstructor
@Service
public class LottoService {
    private final LottoRepository lottoRepository;
    private final LottoTicketFactory lottoTicketFactory;

    public Mono<LottoResponse> createLottoTickets(LottoRequest request) {
        List<LottoTicket> tickets = lottoTicketFactory.createTickets(new PurchaseAmount(request.getPurchaseAmount()));

        return lottoRepository.saveAll(tickets)
                .map(LottoResponse::new);
    }

    public Mono<LottoResponse> findLottoTickets() {
        return lottoRepository.findAll()
                .map(LottoResponse::new);
    }
}
