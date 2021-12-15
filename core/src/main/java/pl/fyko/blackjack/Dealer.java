package pl.fyko.blackjack;

/**
 * Dealer class is resposible for dealing cards from a {@link Deck}.
 * @author Filip Kołodziejczyk
 */
class Dealer {
    private final Deck deck = new Deck();
    private final Hand dealersHand = new Hand();

    Dealer() {
        deal();
    }

    /**
     * Deals cards for Dealers Hand
     */
    private void deal() {
        dealersHand.giveCard(deck.getCard());
        dealersHand.giveCard(deck.getCard());
    }

    /**
     * Gets cards from deck to Dealers Hand until his sum ({@link Hand#getSum}) is greater or equal to
     * given sum.
     * No cards are given to Dealers Hand if given sum is greater than 21.
     * @param sum a sum to compare with Dealers Hand sum
     */
    void getCards(int sum) {
        if (sum > 21) return;

        while (sum > dealersHand.getSum()) {
            dealersHand.giveCard(deck.getCard());
        }
    }

    /**
     * Resets the deck and Dealers Hand
     */
    void reset() {
        deck.reset();
        deal();
    }

    /**
     * Returns Dealers Hand.
     * @return Dealers Hand
     */
    Hand showHand() {
        return dealersHand;
    }

    /**
     * Deals cards to specified Hand. If a Hand already have cards then nothing happens.
     * @param hand a Hand to which cards should be dealt
     */
    void dealCards(Hand hand) {
        if (hand.cardCount() == 0) {
            hand.giveCard(deck.getCard());
            hand.giveCard(deck.getCard());
        }
    }

    /**
     * Gives a card to specified Hand.
     * @param hand Hand to which card should be given
     */
    void giveCard(Hand hand) {
        hand.giveCard(deck.getCard());
    }

}
