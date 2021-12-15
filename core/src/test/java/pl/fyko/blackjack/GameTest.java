package pl.fyko.blackjack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Filip Kołodziejczyk
 */
class GameTest {

    @Test
    void game_OnlyDeal_ExpectPlayerHandSumLessOrEqual21() {
        Game game = new Game();

        assertTrue(game.getPlayerHand().getSum() <= 21);
    }

    @Test
    void game_GetCardsUntilFinished_ExpectPlayerHandGreaterOrEqual21() {
        Game game = new Game();

        while (!game.isFinished()) {
            game.getCard();
        }

        assertTrue(game.getPlayerHand().getSum() >= 21);
    }

    @Test
    void game_GetCardsIfHandLessOrEqual11_ExpectPlayerHandGreaterThan11AndLessOrEqual21() {
        Game game = new Game();

        while (game.getPlayerHand().getSum() <= 11) {
            game.getCard();
        }

        assertTrue(game.getPlayerHand().getSum() > 11 && game.getPlayerHand().getSum() <= 21);
    }
}