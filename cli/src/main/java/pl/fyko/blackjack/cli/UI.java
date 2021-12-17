package pl.fyko.blackjack.cli;

import pl.fyko.blackjack.core.Game;

import java.util.Scanner;

/**
 * UI class is responsible for interaction with user - displaying game information and getting users input.
 * @author Filip Kołodziejczyk
 */
class UI {
    private final Scanner scanner = new Scanner(System.in);
    private final Game game = new Game();
    private final CardPrinter cardPrinter = new CardPrinter();

    void start() {
        System.out.println("Welcome to Blackjack!");
        System.out.println();

        System.out.println("Dealing cards...");
        sleep(4000);
        printPlayerCards();
        game();

    }

    void game() {
        do {
            if (game.getPlayerSum() != 21) {
                printPlayOptions();
                userDecision();
            }
        } while (!game.isFinished());
        finishGame();
    }

    void userDecision() {
        String option = scanner.next();
        switch (option) {
            case "1" -> {
                game.getCard();
                printPlayerCards();
            }
            case "2" -> game.stand();
            case "3" -> System.exit(0);
            default -> userDecision();
        }
    }

    void finishGame() {
        sleep(2000);
        cardPrinter.printCards(game.getDealerHand());
        System.out.println("DEALERS SCORE: " + game.getDealerSum());
        System.out.println();
        if (game.isGameWon()) {
            System.out.println("You have won!");
        } else {
            System.out.println("You have lost!");
        }

    }

    void sleep(long milis) {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void printPlayerCards() {
        cardPrinter.printCards(game.getPlayerHand());
        int sum = game.getPlayerSum();
        System.out.println("SCORE: " + sum);
        if (game.isPlayerBust()) System.out.println("BUST !");
        else if(game.isPlayerBlackjack()) System.out.println("BLACKJACK !");
        System.out.println();
    }

    private void printPlayOptions() {
        System.out.print("1: Hit\t2: Stand\t3:Exit Game\n");
    }
}
