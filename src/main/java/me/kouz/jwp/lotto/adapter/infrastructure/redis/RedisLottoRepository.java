package me.kouz.jwp.lotto.adapter.infrastructure.redis;

import lombok.RequiredArgsConstructor;
import me.kouz.jwp.lotto.domain.model.LottoRepository;
import me.kouz.jwp.lotto.domain.model.LottoTicket;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Repository
public class RedisLottoRepository implements LottoRepository {
    private final ReactiveRedisOperations<String, LottoTicket> redisOperations;

    @Override
    public Mono<LottoTicket> save(Mono<LottoTicket> lottoTicket) {
        return lottoTicket.map(it ->
                redisOperations.opsForValue()
                        .set(UUID.randomUUID().toString(), it))
                .flatMap(__ -> lottoTicket);
    }

    @Override
    public Mono<List<LottoTicket>> saveAll(List<LottoTicket> lottoTickets) {
        return redisOperations.opsForValue()
                .multiSet(lottoTickets.stream()
                        .collect(Collectors.toMap(__ -> UUID.randomUUID().toString(), Function.identity())))
                .map(__ -> lottoTickets);
    }

    @Override
    public Mono<List<LottoTicket>> findAll() {
        return redisOperations.keys("*")
                .flatMap(redisOperations.opsForValue()::get)
                .collectList();
    }
}
