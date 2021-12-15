package pl.fyko.blackjack;

/**
 * Game class is an entry point for UIs and is responsible for monitoring the state of the game.
 *
 * @author Filip Kołodziejczyk
 */
class Game {
    private final Dealer dealer = new Dealer();
    private final Hand playerHand = new Hand();
    private boolean stand = false;

    /**
     * Constructs an instance of Game class. It's ready to start first game - dealer and player hands are already dealt.
     * To start new game simply call {@link #reset()}.
     */
    Game() {
        dealer.dealCards(playerHand);
    }

    /**
     * Clears players and dealers hand, resets the dealers deck, deals first two cards for player and resets
     * a "stand" flag.
     * @see Hand#clear()
     * @see Dealer#reset()
     * @see Dealer#dealCards(Hand)
     */
    void reset() {
        playerHand.clear();
        dealer.reset();
        dealer.dealCards(playerHand);
        stand = false;
    }

    /**
     * @return array of cards on players hand
     */
    Card[] getPlayerHand() {
        return playerHand.getCards();
    }

    /**
     * @return sum of cards on players hand
     */
    int getPlayerSum() {
        return playerHand.getSum();
    }

    /**
     * @return array of cards on dealers hand
     */
    Card[] getDealerHand() {
        return dealer.showHand().getCards();
    }

    /**
     * @return sum of cards on dealers hand
     */
    int getDealerSum() {
        return dealer.showHand().getSum();
    }

    /**
     * Deals a new card for player hand and returns it.
     * @return new card on player hand
     */
    Card getCard() {
        dealer.giveCard(playerHand);
        return playerHand.getLastCard();
    }

    /**
     * Ends the game
     * @see #finishGame()
     */
    void stand() {
        stand = true;
        finishGame();
    }

    /**
     * @return true if player chose to stand or his cards causes bust or blackjack
     */
    boolean isFinished() {
        return stand || playerHand.isBust() || playerHand.isBlackjack();
    }

    /**
     * @return true if dealer is bust or dealers sum is lower than players while player is not bust
     */
    boolean isGameWon() {
        return (dealer.showHand().isBust() || getDealerSum() < getPlayerSum())
                && !playerHand.isBust();
    }

    /**
     * Makes the dealer pick cards until he's won or is bust.
     * @see Dealer#getCards(int)
     */
    private void finishGame() {
        dealer.getCards(playerHand.getSum());
    }

}
