package chapter_04.ex3;

import java.util.function.BiConsumer;

public class BiConsumerExample {
    public static void executeBiConsumer(String p1, String p2,
                                         BiConsumer<String, String> biConsumer) {
        biConsumer.accept(p1, p2);
    }
}
