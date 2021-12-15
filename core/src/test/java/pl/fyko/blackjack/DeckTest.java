package pl.fyko.blackjack;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Filip Kołodziejczyk
 */
class DeckTest {

    @Test
    void getCard_On53rdTry_ExpectEmptyStackException() {
        Deck deck = new Deck();
        int deckSize = Figures.values().length * Suits.values().length;

        for (int i = 0; i < deckSize; i++) {
            deck.getCard();
        }

        assertThrows(EmptyStackException.class, deck::getCard);
    }
}