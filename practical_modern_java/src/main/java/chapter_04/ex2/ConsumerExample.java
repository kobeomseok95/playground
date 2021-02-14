package chapter_04.ex2;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {

    public static void executeConsumer(List<String> nameList, Consumer<String> consumer) {
        for (String s : nameList) {
            consumer.accept(s);
        }
    }
}
