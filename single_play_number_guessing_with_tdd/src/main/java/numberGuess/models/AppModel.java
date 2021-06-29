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
    private static final String GUESS_IS_HIGH_NUMBER = "Your guess is too high." + NEW_LINE + "Enter your guess: ";
    private static final String CORRECT_MESSAGE = "Correct! ";

    private final PositiveIntegerGenerator generator;
    private boolean isCompleted;
    private boolean isSinglePlayMode;
    private String output;

    public AppModel(PositiveIntegerGenerator generator) {
        this.generator = generator;
        this.isCompleted = false;
        this.isSinglePlayMode = false;
        this.output = MODE_SELECT_MESSAGE;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public String flushOutput() {
        return output;
    }

    public void processInput(String input) {
        if (!isSinglePlayMode) {
            selectGameMode(input);
        } else {
            guessingAnswer(input);
        }
    }

    private void guessingAnswer(String input) {
        int guess = Integer.parseInt(input);
        int answer = generator.generateLessThanOrEqualToHundread();

        if (answer > guess) {
            output = GUESS_IS_LOW_NUMBER;
        } else if (answer < guess) {
            output = GUESS_IS_HIGH_NUMBER;
        } else {
            output = CORRECT_MESSAGE;
        }
    }

    private void selectGameMode(String input) {
        if (input.equals("1")) {
            output = SINGLE_PLAYER_GAME;
            isSinglePlayMode = true;
        } else if (input.equals("3")) {
            isCompleted = true;
        }
    }
}
