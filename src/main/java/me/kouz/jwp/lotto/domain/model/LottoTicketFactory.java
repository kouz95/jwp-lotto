package me.kouz.jwp.lotto.domain.model;

import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class LottoTicketFactory {
    public List<LottoTicket> createTickets(PurchaseAmount purchaseAmount) {
        return IntStream.iterate(0, i -> i++)
                .limit(purchaseAmount.calculateTicketCount())
                .mapToObj(__ -> createRandomTicket())
                .collect(Collectors.toList());
    }

    private LottoTicket createRandomTicket() {
        List<LottoNumber> lottoNumbers = IntStream.rangeClosed(1, 45)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());

        Collections.shuffle(lottoNumbers);

        return new LottoTicket(lottoNumbers.stream()
                .limit(6)
                .sorted()
                .collect(Collectors.toList()));
    }
}
