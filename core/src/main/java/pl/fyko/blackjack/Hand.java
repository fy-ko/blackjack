package pl.fyko.blackjack;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author Filip Kołodziejczyk
 */
class Hand {
    private final HashSet<Card> hand = new HashSet<>();

    void giveCard(Card card) {
        hand.add(card);
    }

    int getSum() {
        int sum = 0;
        for (Card card: hand) {
            sum += card.getValue(sum); // BUG HERE! what if ace is first, then it will always count as 11
        }
        return sum;
    }
}
