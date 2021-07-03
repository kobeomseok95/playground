package numberGuess.models;

public enum AppMessage {

    NEW_LINE(System.lineSeparator()),
    MODE_SELECT_MESSAGE("1: Single player game" + NEW_LINE.getMessage() + "2: Multiplayer game" + NEW_LINE.getMessage() + "3: Exit"
            + NEW_LINE.getMessage() + "Enter selection: "),
    SINGLE_PLAYER_GAME("Single player game" + NEW_LINE.getMessage() + "I'm thinking of a number between 1 and 100."
            + NEW_LINE.getMessage() + "Enter your guess: "),
    GUESS_IS_LOW_NUMBER("Your guess is too low." + NEW_LINE.getMessage() + "Enter your guess: "),
    GUESS_IS_HIGH_NUMBER("Your guess is too high." + NEW_LINE.getMessage() + "Enter your guess: "),
    CORRECT_MESSAGE("Correct! ");

    private final String message;

    AppMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
