package pl.fyko.blackjack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Filip Kołodziejczyk
 */
class CardTest {
    @Test
    void getValue() {
        Card card1 = new Card(Figures.ACE, Suits.DIAMONDS);
        Card card2 = new Card(Figures.SIX, Suits.HEARTS);

        assertEquals(card1.getValue(0), Figures.ACE.value(), "ACE for value 0 should equal 11");
        assertEquals(card1.getValue(16), 1, "ACE for value 16 should equal 1");
        assertEquals(card2.getValue(8), Figures.SIX.value(), "SIX should always equal 6");
    }

    @Test
    void testEquals() {
        Card card1 = new Card(Figures.ACE, Suits.HEARTS);
        Card card2 = new Card(Figures.ACE, Suits.DIAMONDS);
        Card card3 = new Card(Figures.SIX, Suits.HEARTS);
        Card card4 = new Card(Figures.SIX, Suits.HEARTS);

        assertNotEquals(card1, card2, card1 + " should not be equal to " + card2);
        assertNotEquals(card1, card3, card1 + " should not be equal to " + card3);
        assertEquals(card3, card4, card3 + " should be equal to " + card4);
    }
}