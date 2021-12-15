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

    void reset() {
        playerHand.clear();
        dealer.reset();
        stand = false;
    }

    Hand getPlayerHand() {
        return playerHand;
    }

    Card getCard() {
        dealer.giveCard(playerHand);
        return playerHand.getLastCard();
    }

    void stand() {
        stand = true;
        finishGame();
    }

    boolean isFinished() {
        return stand || playerHand.isBust() || playerHand.isBlackjack();
    }

    private void finishGame() {
        dealer.getCards(playerHand.getSum());
    }

}
