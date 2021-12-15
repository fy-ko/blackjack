package pl.fyko.blackjack;

import java.util.Collections;
import java.util.HashSet;
import java.util.Stack;

/**
 * Deck class sort of generates next cards to use in game.
 * During creation of this class a stack is being filled with all available cards
 * (All {@link Figures} in all {@link Suits}) and then shuffled.
 *
 * @author Filip Kołodziejczyk
 */
class Deck {
    private final Stack<Card> cards = new Stack<>();
    private final HashSet<Card> cardHashes = new HashSet<>();

    Deck() {
        reset();
    }

    /**
     * Fills the deck with cards.
     * In order to prevent duplicates, cards are also added to a HashSet. If this fails then an exception is thrown.
     */
    void reset() {
        cards.clear();
        // fill up the deck
        for (Figures figure: Figures.values()) {
            for (Suits suit: Suits.values()) {
                Card card = new Card(figure, suit);
                if (cardHashes.add(card)) {
                    cards.push(card);
                }
            }
        }

        Collections.shuffle(cards);
    }

    /**
     * Gets next card from the deck.
     * @throws java.util.EmptyStackException if no cards are left in the deck
     * @return next card from the deck
     */
    Card getCard() {
        Card card = cards.pop();
        cardHashes.remove(card);
        return card;
    }

    /**
     * Checks if deck is complete - contains all cards (all figures and suits) and none have been taken.
     * @return true if contains all cards
     */
    boolean isComplete() {
        return cardHashes.size() == (Suits.values().length * Figures.values().length);
    }
}
