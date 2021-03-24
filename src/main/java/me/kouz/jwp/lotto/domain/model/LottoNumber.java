package me.kouz.jwp.lotto.domain.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class LottoNumber implements Comparable<LottoNumber> {
    private final int number;

    private LottoNumber() {
        this(0);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return this.number - o.number;
    }
}
