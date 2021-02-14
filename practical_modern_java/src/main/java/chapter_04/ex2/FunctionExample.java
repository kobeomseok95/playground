package chapter_04.ex2;

import java.util.function.Function;

public class FunctionExample {

    public static int executeFunction(String context, Function<String, Integer> function) {
        return function.apply(context);
    }
}
