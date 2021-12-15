package pl.fyko.blackjack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Filip Kołodziejczyk
 */
class DealerTest {

    @Test
    void getCards_ForSum21_ExpectSumGreaterOrEqual21() {
        Dealer dealer = new Dealer();
        dealer.getCards(21);

        assertTrue(dealer.showHand().getSum() >= 21);
    }

    @Test
    void getCards_ForSum18_ExpectSumGreaterOrEqual18() {
        Dealer dealer = new Dealer();
        dealer.getCards(18);

        assertTrue(dealer.showHand().getSum() >= 18);
    }

    @Test
    void getCards_ForSum22_ExpectSumLessOrEqual21() {
        Dealer dealer = new Dealer();
        dealer.getCards(22);

        assertTrue(dealer.showHand().getSum() <= 21);
    }

    @Test
    void dealCards_WithEmptyHand_ExpectCardCount2() {
        Dealer dealer = new Dealer();
        Hand hand = new Hand();

        dealer.dealCards(hand);

        assertEquals(2, hand.cardCount());
    }

    @Test
    void dealCards_Twice_ExpectCardCount2() {
        Dealer dealer = new Dealer();
        Hand hand = new Hand();

        dealer.dealCards(hand);
        dealer.dealCards(hand);

        assertEquals(2, hand.cardCount());
    }

    @Test
    void giveCard_Once_ExpectCardCount1() {
        Dealer dealer = new Dealer();
        Hand hand = new Hand();

        dealer.giveCard(hand);

        assertEquals(1, hand.cardCount());
    }
}