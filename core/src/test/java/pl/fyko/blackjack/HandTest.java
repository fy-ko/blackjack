package pl.fyko.blackjack;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Filip Kołodziejczyk
 */
class HandTest {

    @Test
    void getSum_TwoAces_Expect12() {
        Card card1 = new Card(Figures.ACE, Suits.HEARTS);
        Card card2 = new Card(Figures.ACE, Suits.SPADES);

        Hand hand = new Hand();
        hand.giveCard(card1);
        hand.giveCard(card2);
        assertEquals(12, hand.getSum());
    }

    @Test
    void getSum_SameCards_Expect11() {
        Card card1 = new Card(Figures.ACE, Suits.HEARTS);
        Card card2 = new Card(Figures.ACE, Suits.HEARTS);

        Hand hand = new Hand();
        hand.giveCard(card1);
        hand.giveCard(card2); // this card should not be added since it's the same as the previous one
        assertEquals(11, hand.getSum());
    }

    @Test
    void isBust_EightNineSix_ExpectTrue() {
        Card card1 = new Card(Figures.EIGHT, Suits.HEARTS);
        Card card2 = new Card(Figures.NINE, Suits.SPADES);
        Card card3 = new Card(Figures.SIX, Suits.HEARTS);

        Hand hand = new Hand();
        hand.giveCard(card1);
        hand.giveCard(card2);
        hand.giveCard(card3);
        assertTrue(hand.isBust());
    }

    @Test
    void isBust_EightAceSix_ExpectFalse() {
        Card card1 = new Card(Figures.EIGHT, Suits.HEARTS);
        Card card2 = new Card(Figures.ACE, Suits.SPADES);
        Card card3 = new Card(Figures.SIX, Suits.HEARTS);

        Hand hand = new Hand();
        hand.giveCard(card1);
        hand.giveCard(card2);
        hand.giveCard(card3);
        assertFalse(hand.isBust());
    }


    @Test
    void isBlackjack_KingKingAce_ExpectTrue() {
        Card card1 = new Card(Figures.KING, Suits.HEARTS);
        Card card2 = new Card(Figures.KING, Suits.SPADES);
        Card card3 = new Card(Figures.ACE, Suits.HEARTS);

        Hand hand = new Hand();
        hand.giveCard(card1);
        hand.giveCard(card2);
        hand.giveCard(card3);
        assertTrue(hand.isBlackjack());
    }

    @Test
    void isBlackjack_KingNine_ExpectFalse() {
        Card card1 = new Card(Figures.KING, Suits.HEARTS);
        Card card2 = new Card(Figures.NINE, Suits.SPADES);

        Hand hand = new Hand();
        hand.giveCard(card1);
        hand.giveCard(card2);
        assertFalse(hand.isBlackjack());
    }
}