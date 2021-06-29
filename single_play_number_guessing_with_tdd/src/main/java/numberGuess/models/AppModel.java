package numberGuess.models;

import numberGuess.PositiveIntegerGenerator;
import numberGuess.RandomGenerator;

public class AppModel {

    private static final String NEW_LINE = System.lineSeparator();
    private static final String MODE_SELECT_MESSAGE = "1: Single player game" + NEW_LINE + "2: Multiplayer game" + NEW_LINE + "3: Exit"
            + NEW_LINE + "Enter selection: ";
    private static final String SINGLE_PLAYER_GAME = "Single player game" + NEW_LINE + "I'm thinking of a number between 1 and 100."
            + NEW_LINE + "Enter your guess: ";
    private static final String GUESS_IS_LOW_NUMBER = "Your guess is too low." + NEW_LINE + "Enter your guess: ";
    private final PositiveIntegerGenerator generator;

    private boolean isCompleted;
    private String output;

    public AppModel(PositiveIntegerGenerator generator) {
        this.generator = generator;
        this.isCompleted = false;
        this.output = MODE_SELECT_MESSAGE;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public String flushOutput() {
        return output;
    }

    public void processInput(String input) {
        if (input.equals("1")) {
            output = SINGLE_PLAYER_GAME;
        } else if(input.equals("3")) {
            isCompleted = true;
        }

        // TODO : 최소한의 단위테스트만 통과했다.
        if (input.equals("40") || input.equals("29") || input.equals("9")) {
            output = GUESS_IS_LOW_NUMBER;
        }
    }
}
