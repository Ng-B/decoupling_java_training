package fr.lernejo.guessgame;

import java.security.SecureRandom;

public class Launcher {
    public static void main() {
        Simulation simulation = new Simulation(new HumanPlayer());
        SecureRandom random = new SecureRandom();
        long randomNumber = random.nextLong();

        simulation.initialize(randomNumber);
        simulation.loopUntilPlayerSucceed();
    }
}
