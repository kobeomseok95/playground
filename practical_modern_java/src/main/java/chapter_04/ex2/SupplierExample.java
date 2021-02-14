package chapter_04.ex2;

import java.util.function.Supplier;

public class SupplierExample {
    public static String executeSupplier(Supplier<String> supplier) {
        return supplier.get();
    }
}
