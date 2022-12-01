package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class HandValueAceTest {

    private static final Suit DUMMY_SUIT = Suit.HEARTS;

    @Test
    public void handWithOneAceTwoCardsIsValuedAt11() throws Exception {
        Hand hand = createHandWithRanksOf("A", "5");

        assertThat(hand.value())
                .isEqualTo(11 + 5); // EVIDENT DATA
    }

    @Test
    public void handWithOneAceAndOtherCardsEqualTo11IsValuedAt1() throws Exception {
        Hand hand = createHandWithRanksOf("A", "8", "3");

        assertThat(hand.value())
                .isEqualTo(1 + 8 + 3);
    }

    @Test
    void handWithOneAceAndOtherCardsEqualTo12AceIsValuedAt1() {
        Hand hand = createHandWithRanksOf("A", "8", "4");

        assertThat(hand.value())
                .isEqualTo(1 + 8 + 4);
    }

    @Test
    void handWithOneAceAndOtherCardsEqualTo10AceIsValuedAt11() {
        Hand hand = createHandWithRanksOf("A", "8", "2");

        assertThat(hand.value())
                .isEqualTo(11 + 8 + 2);
    }

    private Hand createHandWithRanksOf(String... ranks) {
        List<Card> cards = new ArrayList<>();
        for (String rank : ranks) {
            cards.add(new Card(DUMMY_SUIT, rank));
        }
        return Hand.createHandForTest(cards);
    }

}
