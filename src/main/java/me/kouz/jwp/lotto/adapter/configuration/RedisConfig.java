package me.kouz.jwp.lotto.adapter.configuration;

import me.kouz.jwp.lotto.domain.model.LottoTicket;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {
    @Bean
    ReactiveRedisOperations<String, LottoTicket> redisOperations(ReactiveRedisConnectionFactory factory) {
        Jackson2JsonRedisSerializer<LottoTicket> serializer = new Jackson2JsonRedisSerializer<>(LottoTicket.class);

        RedisSerializationContext.RedisSerializationContextBuilder<String, LottoTicket> builder =
                RedisSerializationContext.newSerializationContext(new StringRedisSerializer());

        RedisSerializationContext<String, LottoTicket> context = builder.value(serializer).build();

        return new ReactiveRedisTemplate<>(factory, context);
    }
}
