package chapter_04.ex3;

import java.util.function.IntPredicate;

public class IntPredicateExample {
    public static boolean isPositive(int i, IntPredicate intPredicate) {
        return intPredicate.test(i);
    }
}
