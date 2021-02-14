package chapter_04.ex3;

import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {
//        example1();
//        example2();
//        example3();
        example4();
    }

    private static void example4() {
        BinaryOperator<Integer> bo = (Integer a, Integer b) -> a + b;
        System.out.println("bo.apply(10, 20) = " + bo.apply(10, 20));

    }

    private static void example3() {
        UnaryOperator<Integer> opA = (Integer t) -> t * 2;
        System.out.println("opA.apply(10) = " + opA.apply(10));
        System.out.println("opA.apply(20) = " + opA.apply(20));
        System.out.println("opA.apply(30) = " + opA.apply(30));

    }

    private static void example2() {
        BiConsumer<String, String> biConsumer = (String param1, String param2) -> {
            System.out.println(param1 + param2);
        };
        BiConsumerExample.executeBiConsumer("안녕, ", "내 이름은 고범석", biConsumer);
    }

    private static void example1() {
//        1번 예제
        for (int i = 0; i < 10; i++) {
            boolean positive = IntPredicateExample.isPositive(i, (int x) -> x % 2 == 0);
            System.out.println("결과 = " + positive);
        }
    }


}
