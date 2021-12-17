package pl.fyko.blackjack.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Filip Kołodziejczyk
 */
class GameTest {

    @Test
    void game_OnlyDeal_ExpectPlayerHandSumLessOrEqual21() {
        Game game = new Game();

        assertTrue(game.getPlayerSum() <= 21);
    }

    @Test
    void game_GetCardsUntilFinished_ExpectPlayerHandGreaterOrEqual21() {
        Game game = new Game();

        while (!game.isFinished()) {
            game.getCard();
        }

        assertTrue(game.getPlayerSum() >= 21);
    }

    @Test
    void game_GetCardsIfHandLessOrEqual11_ExpectPlayerHandGreaterThan11AndLessOrEqual21() {
        Game game = new Game();

        while (game.getPlayerSum() <= 11) {
            game.getCard();
        }

        assertTrue(game.getPlayerSum() > 11 && game.getPlayerSum() <= 21);
    }
}