package fr.lernejo.guessgame;

import java.security.SecureRandom;

public class ComputerPlayer implements Player {

    private long max =  Long.MAX_VALUE;;
    private long min =  Long.MIN_VALUE;;

    @Override
    public long askNextGuess() {
        long guess = (this.max + this.min) / 2;

        return guess;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if (lowerOrGreater)
            this.max = (this.max + this.min) / 2 - 1;
        else
            this.min = (this.max + this.min) / 2 + 1;

    }
}
