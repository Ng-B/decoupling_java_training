package fr.lernejo.guessgame;

import java.security.SecureRandom;

public class Launcher {
    public static void main(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Missing argument: [-interactive|-auto}");
        }

        long maxIterations = Long.MAX_VALUE;
        final Simulation simulation;

        if (args[0].equals("-interactive")) {
            simulation = new Simulation(new HumanPlayer());
            SecureRandom random = new SecureRandom();
            long randomNumber = random.nextInt(100);

            simulation.initialize(randomNumber);
        }
        else if (args[0].equals("-auto")) {
            if (args.length != 2) {
                throw new IllegalArgumentException("No number given");
            }

            simulation = new Simulation(new ComputerPlayer());
            maxIterations = 1000;
            simulation.initialize(Long.parseLong(args[1]));
        }
        else {
            throw new IllegalArgumentException("Invalid mode: " + args[0]);
        }

        simulation.loopUntilPlayerSucceed(maxIterations);
    }
}
