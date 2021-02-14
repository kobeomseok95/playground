package chapter_04.ex2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        3번 예제
        List<String> nameList = initNameList();
//        두번째 매개변수는 해당 함수형 인터페이스의 메서드를 람다로 구현한 부분이다.
        ConsumerExample.executeConsumer(nameList, name -> System.out.println("name = " + name));
        int lengths = FunctionExample.executeFunction("고범석짱짱", String::length);
        System.out.println("lengths = " + lengths);

        boolean b = PredicateExample.executePredicate("고범석", name -> name.equals("고dmq석"));
        System.out.println("b = " + b);

        String myname = "고범석";
        String s = SupplierExample.executeSupplier(() -> {
            return myname;
        });
        System.out.println("s = " + s);
    }

    private static List<String> initNameList() {
        List<String> list = new ArrayList<>();
        list.add("하재우");
        list.add("김기준");
        list.add("임성준");
        list.add("임지환");
        list.add("고범석");
        return list;
    }
}
