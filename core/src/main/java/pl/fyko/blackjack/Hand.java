package pl.fyko.blackjack;

import java.util.HashSet;

/**
 * @author Filip Kołodziejczyk
 */
class Hand {
    private final HashSet<Card> hand = new HashSet<>();
    private Card lastCard;

    void giveCard(Card card) {
        lastCard = card;
        hand.add(lastCard);
    }

    void clear() {
        hand.clear();
        lastCard = null;
    }

    int getSum() {
        int sum = 0;
        for (Card card: hand.stream().sorted().toList()) {
            sum += card.getValue(sum);
        }
        return sum;
    }

    int cardCount() {
        return hand.size();
    }

    Card getLastCard() {
        return lastCard;
    }

    boolean isBlackjack() {
        return getSum() == 21;
    }

    boolean isBust() {
        return getSum() > 21;
    }
}
