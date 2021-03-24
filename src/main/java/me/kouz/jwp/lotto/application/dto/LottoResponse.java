package me.kouz.jwp.lotto.application.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import me.kouz.jwp.lotto.domain.model.LottoTicket;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class LottoResponse {
    private final List<LottoTicket> lottoTickets;
}
