package fr.lernejo.guessgame;

import fr.lernejo.logger.*;

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
        if (lowerOrGreater) {
            this.logger.log("answer is lower");
            System.out.println("answer is lower");
        }
        else{
            this.logger.log("answer is higher");
            System.out.println("answer is higher");
        }
    }
}
