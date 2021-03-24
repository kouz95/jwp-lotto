package me.kouz.jwp.lotto.application.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class LottoRequest {
    private final int purchaseAmount;

    private LottoRequest() {
        this(0);
    }
}
