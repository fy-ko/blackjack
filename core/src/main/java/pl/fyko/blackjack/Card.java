package pl.fyko.blackjack;

import java.util.Objects;

/**
 * Represents a single card and its value.
 *
 * @author Filip Kołodziejczyk
 */
class Card {
    private final Figures figure;
    private final Suits suit;

    Card(Figures name, Suits suit) {
        this.figure = name;
        this.suit = suit;
    }

    /**
     * Returns the value of the card (set in {@link Figures}) while taking into account the ability of ACE card
     * to have two different values depending on current cards value.
     *
     * @param currentValue value to take into account if the card is ACE
     * @return value of the card
     */
    int getValue(int currentValue) {
        if (figure.equals(Figures.ACE) && currentValue > 10) {
            return figure.value() - 10;
        } else {
            return figure.value();
        }
    }

    @Override
    public String toString() {
        // TODO: change it to use ResourceBundle
        return String.format("%s of %s", figure, suit);
    }

    /**
     * Card is equal only to another card if both have the same figure and suit.
     * @param o Object to check for equality
     * @return true if cards have the same figure and suit
     */
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
