package chapter_04.ex5;

import chapter_04.ex2.PredicateExample;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
//        execute1();
//        execute2();
        execute3();

    }

    private static void execute3() {
        Function<String, Integer> parseIntFunction = (String s) -> Integer.parseInt(s) + 10;
        Function<Integer, String> intToStringFunction = (Integer i) -> Integer.toString(i);

        System.out.println("parseIntFunction(\"1000\") = " + parseIntFunction.apply("1000"));
        System.out.println("intToStringFunction = " + intToStringFunction.apply(1000));

        //function 조합
        System.out.println("intToStringFunction.andThen(parseIntFunction).apply(1000) = " + intToStringFunction.andThen(parseIntFunction).apply(1000));
    }

    private static void execute2() {
        Predicate<Person> maleReturn = PredicateAndExample.isMale();
        Predicate<Person> femaleReturn = PredicateAndExample.isFemale();
        Predicate<Person> adultReturn = PredicateAndExample.isAdult();

        Predicate<Person> maleAndAdult = maleReturn.and(adultReturn);

        List<Person> people = initPeople();
        people.stream().filter(maleAndAdult).forEach(System.out::println);

    }

    private static List<Person> initPeople() {
        List<Person> people = new ArrayList<>();
        people.add(new Person("고범석", "male", 26));
        people.add(new Person("김기준", "female", 26));
        people.add(new Person("하재우", "male", 26));
        people.add(new Person("김기윤", "female", 26));
        people.add(new Person("김진우", "male", 26));
        return people;
    }

    private static void execute1() {
        Consumer<String> consumer = (String name) -> System.out.println("Hello, " + name);
        Consumer<String> consumerAndThen = (String text) -> System.out.println("length = " + text.length());
        /**
         *  consumer.andThen(consumerAndThen) : 조합했다. 이때 리턴은 Consumer<T>
         *
         *  accept : 반환형이 void 라서 마무리
         *
         *  원리 : consumer.andThen(consumerAndThen) > 조합한 인터페이스
         *  여기에 accept(str)을 넣어주어 매개변수를 설정해준다읍 조합된 인터페이스를 실행시킨다.
         */
        consumer.andThen(consumerAndThen).accept("고범석");
    }
}
