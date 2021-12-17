package pl.fyko.blackjack.core;

/**
 * Game class is an entry point for UIs and is responsible for monitoring the state of the game.
 *
 * @author Filip Kołodziejczyk
 */
public class Game {
    private final Dealer dealer = new Dealer();
    private final Hand playerHand = new Hand();
    private boolean stand = false;

    /**
     * Constructs an instance of Game class. It's ready to start first game - dealer and player hands are already dealt.
     * To start new game simply call {@link #reset()}.
     */
    public Game() {
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
    public Card[] getPlayerHand() {
        return playerHand.getCards();
    }

    /**
     * @return sum of cards on players hand
     */
    public int getPlayerSum() {
        return playerHand.getSum();
    }

    public boolean isPlayerBust() {
        return playerHand.isBust();
    }

    public boolean isPlayerBlackjack() {
        return playerHand.isBlackjack();
    }

    /**
     * @return array of cards on dealers hand
     */
    public Card[] getDealerHand() {
        return dealer.showHand().getCards();
    }

    /**
     * @return sum of cards on dealers hand
     */
    public int getDealerSum() {
        return dealer.showHand().getSum();
    }

    /**
     * Deals a new card for player hand and returns it.
     * @return new card on player hand
     */
    public Card getCard() {
        dealer.giveCard(playerHand);
        return playerHand.getLastCard();
    }

    /**
     * Ends the game
     * @see #finishGame()
     */
    public void stand() {
        stand = true;
        finishGame();
    }

    /**
     * @return true if player chose to stand or his cards causes bust or blackjack
     */
    public boolean isFinished() {
        return stand || playerHand.isBust() || playerHand.isBlackjack();
    }

    /**
     * @return true if dealer is bust or dealers sum is lower than players while player is not bust
     */
    public boolean isGameWon() {
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
