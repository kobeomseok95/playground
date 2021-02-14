package chapter_04.ex2;

import java.util.function.Predicate;

public class PredicateExample {
    public static boolean executePredicate(String name, Predicate<String> predicate) {
        return predicate.test(name);
    }
}
