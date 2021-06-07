package me.kouz.jwp.lotto.domain.model;

import reactor.core.publisher.Mono;

import java.util.List;

public interface LottoRepository {
    Mono<LottoTicket> save(Mono<LottoTicket> lottoTicket);

    Mono<List<LottoTicket>> saveAll(List<LottoTicket> lottoTickets);

    Mono<List<LottoTicket>> findAll();
}
