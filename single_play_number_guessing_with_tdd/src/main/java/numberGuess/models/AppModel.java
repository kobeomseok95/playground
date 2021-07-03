package numberGuess.models;

import numberGuess.PositiveIntegerGenerator;
import numberGuess.RandomGenerator;

import static numberGuess.models.AppMessage.*;

public class AppModel {

    private final PositiveIntegerGenerator generator;
    private boolean isCompleted;
    private boolean isSinglePlayMode;
    private String output;
    private int fails;

    interface Processor {
        Processor run(String input);
    }

    public AppModel(PositiveIntegerGenerator generator) {
        this.generator = generator;
        this.isCompleted = false;
        this.isSinglePlayMode = false;
        this.output = MODE_SELECT_MESSAGE.getMessage();
        this.fails = 0;
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
            ++fails;
            output = GUESS_IS_LOW_NUMBER.getMessage();
        } else if (answer < guess) {
            ++fails;
            output = GUESS_IS_HIGH_NUMBER.getMessage();
        } else {
            output = CORRECT_MESSAGE.getMessage() + NEW_LINE.getMessage() +
                    (fails + 1) + (fails == 0 ? " guess." : " guesses.") + NEW_LINE.getMessage();
            output += MODE_SELECT_MESSAGE.getMessage();
            isSinglePlayMode = false;
        }
    }

    private void selectGameMode(String input) {
        if (input.equals("1")) {
            output = SINGLE_PLAYER_GAME.getMessage();
            isSinglePlayMode = true;
        } else if (input.equals("3")) {
            isCompleted = true;
        }
    }
}
