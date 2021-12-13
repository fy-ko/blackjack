package pl.fyko.blackjack;

import java.util.Collections;
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

    Deck() {
        reset();
    }

    /**
     * Fills the deck with cards.
     */
    void reset() {
        cards.clear();
        // fill up the deck
        for (Figures figure: Figures.values()) {
            for (Suits suit: Suits.values()) {
                cards.push(new Card(figure, suit));
            }
        }

        Collections.shuffle(cards);
    }

    Card getCard() {
        return cards.pop();
    }
}
