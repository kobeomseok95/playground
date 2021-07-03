package numberGuess.models;

import numberGuess.PositiveIntegerGenerator;
import numberGuess.PositiveIntegerGeneratorStub;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class AppModelTest {

    private static String NEW_LINE = System.lineSeparator();

    @Test
    @DisplayName("게임이 시작될 때, 종료되지 않음")
    void sut_is_incompleted_when_it_is_initialized() {

        // given
        AppModel model = new AppModel(new PositiveIntegerGeneratorStub(50));

        // when
        boolean actual = model.isCompleted();

        // then
        assertFalse(actual);
    }

    @Test
    @DisplayName("게임이 시작될 때, 메세지 출력")
    void sut_correctly_prints_select_mode_message() {

        // given
        AppModel model = new AppModel(new PositiveIntegerGeneratorStub(50));

        // when
        String actual = model.flushOutput();

        // then
        assertTrue(actual.equals("1: Single player game" + NEW_LINE + "2: Multiplayer game" + NEW_LINE + "3: Exit"
                + NEW_LINE + "Enter selection: "));
    }

    @Test
    @DisplayName("게임 종료")
    void game_exit() {

        // given
        AppModel model = new AppModel(new PositiveIntegerGeneratorStub(50));

        // when
        model.processInput("3");

        // then
        assertTrue(model.isCompleted());
    }

    @Test
    @DisplayName("싱글플레이 start 메세지 확인")
    void sut_correctly_prints_single_player_game_start_message() {

        // given
        AppModel model = new AppModel(new PositiveIntegerGeneratorStub(50));
        model.flushOutput();
        model.processInput("1");

        // when
        String actual = model.flushOutput();

        // then
        assertTrue(actual.equals("Single player game" + NEW_LINE + "I'm thinking of a number between 1 and 100."
                + NEW_LINE + "Enter your guess: "));
    }
    
    @ParameterizedTest
    @CsvSource({ "50, 40", "30, 29", "89, 9" })
    @DisplayName("정답보다 낮은 숫자를 추측했을 때 메세지 출력")
    void sut_correctly_prints_too_low_message_in_single_player_game(int answer, int guess) {

        // given
        AppModel model = new AppModel(new PositiveIntegerGeneratorStub(answer));
        model.processInput("1");
        model.flushOutput();
        model.processInput(Integer.toString(guess));

        // when
        String actual = model.flushOutput();

        // then
        assertTrue(actual.equals("Your guess is too low." + NEW_LINE + "Enter your guess: "));
    }

    @ParameterizedTest
    @CsvSource({"50, 60", "80, 81"})
    @DisplayName("정답보다 높은 경우 메세지 출력")
    void sut_correctly_prints_too_high_message_in_single_player_game(int answer, int guess) {

        // given
        AppModel model = new AppModel(new PositiveIntegerGeneratorStub(answer));
        model.processInput("1");
        model.flushOutput();

        // when
        model.processInput(Integer.toString(guess));
        String actual = model.flushOutput();

        // then
        assertTrue(actual.equals("Your guess is too high." + NEW_LINE + "Enter your guess: "));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 10, 100})
    @DisplayName("정답을 맞췄을 경우 맞았다는 메세지 출력")
    void sut_correctly_prints_correct_message_in_single_player_game(int answer) {

        // given
        AppModel model = new AppModel(new PositiveIntegerGeneratorStub(answer));
        model.processInput("1");
        model.flushOutput();
        int guess = answer;

        // when
        model.processInput(Integer.toString(guess));
        String actual = model.flushOutput();

        // then
        assertTrue(actual.startsWith("Correct! "));
    }

    @DisplayName("게임이 끝날 때, 시도한 횟수 출력")
    @ParameterizedTest
    @ValueSource(ints = { 1, 10, 100 })
    void sut_correctly_prints_guess_count_if_single_player_game_finished(int fails) {

        // given
        AppModel model = new AppModel(new PositiveIntegerGeneratorStub(50));
        model.processInput("1");
        for (int i = 0; i < fails; i++) {
            model.processInput("30");
        }
        model.flushOutput();
        model.processInput("50");

        // when
        String actual = model.flushOutput();

        // then
        System.out.println("actual = " + actual);
        assertTrue(actual.contains((fails + 1) + " guesses." + NEW_LINE));
    }

    @Test
    @DisplayName("한 번에 맞췄을 경우, guess 출력")
    void sut_correctly_prints_one_guess_if_single_player_game_finished() {

        // given
        AppModel model = new AppModel(new PositiveIntegerGeneratorStub(50));
        model.processInput("1");
        model.flushOutput();
        model.processInput("50");

        // when
        String actual = model.flushOutput();

        // then
        assertTrue(actual.contains("1 guess."));
    }

    @Test
    @DisplayName("게임이 종료되었을 경우, 게임을 다시 고르는 메세지를 출력해야 한다.")
    void sut_prints_select_mode_message_if_single_player_game_finished() {

        // given
        AppModel model = new AppModel(new PositiveIntegerGeneratorStub(50));
        model.processInput("1");
        model.flushOutput();


        // when
        model.processInput("50");
        String actual = model.flushOutput();

        // then
        assertTrue(actual.endsWith("1: Single player game" + NEW_LINE + "2: Multiplayer game" + NEW_LINE + "3: Exit"
                + NEW_LINE + "Enter selection: "));
    }
}
