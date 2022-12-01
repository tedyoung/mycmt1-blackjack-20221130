package com.jitterted.ebp.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.fusesource.jansi.Ansi.ansi;

public class Hand {
    private final List<Card> cards = new ArrayList<>();

    public Hand() {
    }

    private Hand(List<Card> cards) {
        this.cards.addAll(cards);
    }

    static Hand createHandForTest(List<Card> cards) {
        return new Hand(cards);
    }

    void drawFrom(Deck deck) {
        // REQUIRE deck not empty
        // REQUIRE not busted
        cards.add(deck.draw());
    }

    int value() {
        int handValue = cards
                .stream()
                .mapToInt(Card::rankValue)
                .sum();

        // does the hand contain at least 1 Ace?
        boolean hasAce = cards
                .stream()
                .anyMatch(card -> card.rankValue() == 1);

        // if the total hand value <= 11, then count the Ace as 11 by adding 10
        if (hasAce && handValue <= 11) {
            handValue += 10;
        }

        return handValue;
    }

    Card faceUpCard() {
        return cards.get(0);
    }

    void display() {
        System.out.println(cards.stream()
                                .map(Card::display)
                                .collect(Collectors.joining(
                                        ansi().cursorUp(6).cursorRight(1).toString())));
    }

    boolean isBusted() {
        return value() > 21;
    }

    boolean shouldDealerHit() {
        return value() <= 16;
    }

    boolean beats(Hand hand) {
        // [Pre-condition] REQUIRE: neither hand is busted --> if not THROW EXCEPTION
        requireNoBustedHands(hand);
        return hand.value() < value();
    }

    private void requireNoBustedHands(Hand hand) {
        if (isBusted() || hand.isBusted()) {
            throw new IllegalStateException();
        }
    }

    boolean pushes(Hand hand) {
        return hand.value() == value();
    }

}
