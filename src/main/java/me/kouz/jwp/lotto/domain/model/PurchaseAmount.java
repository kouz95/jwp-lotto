package me.kouz.jwp.lotto.domain.model;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PurchaseAmount {
    private static final int TICKET_PRICE = 1000;

    private final int purchaseAmount;

    public int calculateTicketCount() {
        return purchaseAmount / TICKET_PRICE;
    }
}
