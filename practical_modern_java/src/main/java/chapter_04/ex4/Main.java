package chapter_04.ex4;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        example1();
        example2();
    }

    private static void example2() {
        List<String> list = new ArrayList<>();
        list.add("Applet");
        list.add("Samsung");
        list.add("LG");
        list.add("Lenovo");

        System.out.println("Lambda Expression");
        list.stream()
                .map((String name) -> new ConstructorReferenceExample(name))
                .forEach((ConstructorReferenceExample data) -> System.out.println(data));


        System.out.println("Constructor Reference");
        list.stream()
                .map(ConstructorReferenceExample::new)
                .forEach((ConstructorReferenceExample data) -> System.out.println(data));

        System.out.println("Method Reference");
        list.stream()
                .map(ConstructorReferenceExample::new)  //생성자       Function<T, R>
                .forEach(System.out::println);          //toString     Consumer<T>
    }

    private static void example1() {
        List<String> list = new ArrayList<>();
        list.add("hihi");
        list.add("asdf");
        list.add("lorem");
        list.add("ipsum");

        // 정적 메서드 참조
        list.stream().forEach(MethodReferenceExample::executeMethod);
        /**
         *      한정적 메서드 참조
         *      메서드가 특정 객체의 변수로 제한되기 때문이다.
         *
         *      Calendar cal = Calendar.getTime()
         *      cal::getTime
         *          람다 표현식으로 정의할 경우 새 객체를 계속 생성.
         *          하지만 메서드 참조 방식으로 정의하면 객체를 새롭게
         *          생성하지 않아도됨
          */
        list.stream().forEach(MethodReferenceExample.of()::toUpperCase);
        /**
         * 비한정적 메서드 참조
         * 비한정적 : 작성하는 구문 자체가 특정한 객체를 참조하기 위한
         *           변수를 지정하지 않는다는 의미
         */
        list.stream().map(String::toUpperCase).forEach(System.out::println);
    }


}
