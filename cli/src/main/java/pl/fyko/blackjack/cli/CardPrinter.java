package pl.fyko.blackjack.cli;

import pl.fyko.blackjack.core.Card;
import pl.fyko.blackjack.core.Figures;
import pl.fyko.blackjack.core.Suits;

/**
 * CardPrinter class is responsible for printing Cards with ASCII characters.
 *
 * @see pl.fyko.blackjack.core.Card
 * @author Filip Kołodziejczyk
 */
class CardPrinter {
    private final static String HEART = "H";
    private final static String CLUB = "C";
    private final static String DIAMOND = "D";
    private final static String SPADE = "S";

    private final static String TL_CORNER = ".";
    private final static String TR_CORNER = ".";
    private final static String BL_CORNER = "'";
    private final static String BR_CORNER = "'";
    private final static String H_LINE = "-";
    private final static String V_LINE = "|";

    private final static int WIDTH = 13;
    private final static int HEIGHT = 9;

    /**
     * Prints specified array of cards in one line
     * @param cards array of Cards to print
     */
    void printCards(Card... cards) {
            for (int i = 0; i < HEIGHT; i++) {
                for (Card card: cards) {
                    drawLine(i,card);
                    System.out.print(" ");
                }
                System.out.println();
            }
    }

    private void drawLine(int line, Card card) {
        if (line == 0) {
            drawTopLine();
        } else if (line == (HEIGHT - 1)) {
            drawBottomLine();
        } else {
            drawMiddleLine(line, card);
        }
    }

    private void drawTopLine() {
        System.out.print(TL_CORNER);
        System.out.print(H_LINE.repeat(WIDTH - 2));
        System.out.print(TR_CORNER);
    }

    private void drawBottomLine() {
        System.out.print(BL_CORNER);
        System.out.print(H_LINE.repeat(WIDTH - 2));
        System.out.print(BR_CORNER);
    }

    private void drawMiddleLine(int line, Card card) {
        System.out.print(V_LINE);
        if (isTopFigureLine(line)) {
            drawFigureLine(false, getFigure(card.getFigure()));
        } else if (isBottomFigureLine(line)) {
            drawFigureLine(true, getFigure(card.getFigure()));
        } else if (isSuitLine(line)) {
            drawSuitLine(getSuit(card.getSuit()));
        } else {
            System.out.print(" ".repeat(WIDTH - 2));
        }
        System.out.print(V_LINE);
    }

    private void drawFigureLine(boolean right, String figure) {
        if (right) {
            System.out.print(" ".repeat(WIDTH - 2 - figure.length()));
            System.out.print(figure);
        } else {
            System.out.print(figure);
            System.out.print(" ".repeat(WIDTH - 2 - figure.length()));
        }
    }

    private void drawSuitLine(String suit) {
        int mid = (WIDTH - 2) / 2;
        System.out.print(" ".repeat(mid));
        System.out.print(suit);
        System.out.print(" ".repeat(mid));
    }

    private boolean isTopFigureLine(int line) {
        return line == 1;
    }

    private boolean isBottomFigureLine(int line) {
        return line == (HEIGHT - 2);
    }

    private boolean isSuitLine(int line) {
        return line == (HEIGHT / 2);
    }

    private String getFigure(Figures figure) {
        return switch (figure) {
            case TWO -> "2";
            case THREE -> "3";
            case FOUR -> "4";
            case FIVE -> "5";
            case SIX -> "6";
            case SEVEN -> "7";
            case EIGHT -> "8";
            case NINE -> "9";
            case TEN -> "10";
            case JACK -> "J";
            case QUEEN -> "Q";
            case KING -> "K";
            case ACE -> "A";
        };
    }

    private String getSuit(Suits suit) {
        return switch(suit) {
            case HEARTS -> HEART;
            case DIAMONDS -> DIAMOND;
            case CLUBS -> CLUB;
            case SPADES -> SPADE;
        };
    }
}
