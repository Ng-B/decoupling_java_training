
package fr.lernejo.guessgame;

import fr.lernejo.logger.*;
import java.text.SimpleDateFormat;

public class Simulation {

    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;
    private long numberGuess;

    public Simulation(Player player) {
        this.player = player;
    }

    public void initialize(long numberToGuess) {
        this.numberGuess = numberToGuess;
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {
        long guess = player.askNextGuess();

        if (guess == numberGuess) {
            logger.log("Number found !");
            return true;
        }

        if (guess > numberGuess)
            player.respond(true);
        else
            player.respond(false);

        return false;
    }

    public void loopUntilPlayerSucceed(long maxIterations) {
        long counter = System.currentTimeMillis();

        while (maxIterations > 0 && nextRound() == false)
            maxIterations--;

        if (maxIterations == 0)
            logger.log("No more available tries. Try again ");
        else
            logger.log("You found the number!");

        long timeEnd = System.currentTimeMillis();
        SimpleDateFormat form = new SimpleDateFormat("mm:ss:SSS");
        String time = form.format(timeEnd-counter);

        logger.log("Fin de partie, completé en " + time);    }
}
