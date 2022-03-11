package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.util.Scanner;

public class HumanPlayer implements Player {

    private final Logger logger = LoggerFactory.getLogger("player");

    @Override
    public long askNextGuess() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your guess number ;");
        long guess = Long.parseLong(scanner.nextLine());
        this.logger.log("Player guess : " + guess);
        return guess;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if (lowerOrGreater)
            logger.log("Solution is lower");
        else
            logger.log("Solution is higher");
    }
}
