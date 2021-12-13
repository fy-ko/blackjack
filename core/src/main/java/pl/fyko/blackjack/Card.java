package pl.fyko.blackjack;

import java.util.Objects;

/**
 * @author Filip Kołodziejczyk
 */
class Card {
    private final Figures figure;
    private final Suits suit;

    Card(Figures name, Suits suit) {
        this.figure = name;
        this.suit = suit;
    }

    int getValue(int currentValue) {
        if (figure.equals(Figures.ACE) && currentValue > 10) {
            return figure.value() - 10;
        } else {
            return figure.value();
        }
    }

    @Override
    public String toString() {
        return String.format("%s of %s", figure, suit);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return figure == card.figure && suit == card.suit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(figure, suit);
    }
}
