package numberGuess.models;

import numberGuess.PositiveIntegerGenerator;
import numberGuess.PositiveIntegerGeneratorStub;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
}