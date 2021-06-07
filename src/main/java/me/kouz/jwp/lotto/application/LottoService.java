package me.kouz.jwp.lotto.application;

import lombok.RequiredArgsConstructor;
import me.kouz.jwp.lotto.application.dto.LottoRequest;
import me.kouz.jwp.lotto.application.dto.LottoResponse;
import me.kouz.jwp.lotto.domain.model.LottoRepository;
import me.kouz.jwp.lotto.domain.model.LottoTicketFactory;
import me.kouz.jwp.lotto.domain.model.PurchaseAmount;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class LottoService {
    private final LottoRepository lottoRepository;
    private final LottoTicketFactory lottoTicketFactory;

    public Mono<LottoResponse> createLottoTickets(Mono<LottoRequest> request) {
        return request.flatMap(it -> lottoRepository.saveAll(lottoTicketFactory.createTickets(new PurchaseAmount(it.getPurchaseAmount())))
                .map(LottoResponse::new));
    }

    public Mono<LottoResponse> findLottoTickets() {
        return lottoRepository.findAll()
                .map(LottoResponse::new);
    }
}
