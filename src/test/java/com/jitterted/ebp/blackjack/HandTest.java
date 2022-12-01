package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class HandTest {
    private static final Suit DUMMY_SUIT = Suit.SPADES;

    @Test
    void handValuedAt22IsBusted() {
        Hand hand = Hand.createHandForTest(List.of(new Card(DUMMY_SUIT, "7"),
                                                   new Card(DUMMY_SUIT, "10"),
                                                   new Card(DUMMY_SUIT, "5")));

        assertThat(hand.isBusted())
                .isTrue();
    }

    @Test
    void handValuedAt21IsNotBusted() {
        Hand hand = Hand.createHandForTest(List.of(new Card(DUMMY_SUIT, "7"),
                                                   new Card(DUMMY_SUIT, "9"),
                                                   new Card(DUMMY_SUIT, "5")));

        assertThat(hand.isBusted())
                .isFalse();
    }
}