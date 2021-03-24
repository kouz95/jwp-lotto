package me.kouz.jwp.lotto.domain.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class LottoTicket {
    private final List<LottoNumber> lottoNumbers;

    private LottoTicket() {
        this(null);
    }
}
