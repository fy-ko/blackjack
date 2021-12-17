package pl.fyko.blackjack.cli;

import pl.fyko.blackjack.core.Game;

/**
 * Main class is responsible for starting the application via {@link UI} class.
 *
 * It's separated like that in case I would want to handle some arguments. If that ever happens varargs
 * are going to be handled here.
 *
 * @author Filip Kołodziejczyk
 */
class Main {

    public static void main(String[] args) {
        UI ui = new UI();
        ui.start();
    }

}
