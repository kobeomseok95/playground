package chapter_04.ex5;

import java.util.function.Predicate;

public class PredicateAndExample {
    public static Predicate<Person> isMale() {
        return (Person p) -> "male".equals(p.getSex());
    }

    public static Predicate<Person> isFemale() {
        return (Person p) -> "female".equals(p.getSex());
    }

    public static Predicate<Person> isAdult() {
        return (Person p) -> p.getAge() > 20;
    }
}
