package chapter_04.ex4;

public class MethodReferenceExample {
    public static MethodReferenceExample of() {
        return new MethodReferenceExample();
    }

    public static void executeMethod(String entity) {
        if (entity != null && !entity.equals("")) {
            System.out.println("entity = " + entity);
            System.out.println("entity.length() = " + entity.length());
        }
    }

    public void toUpperCase(String entity) {
        System.out.println("entity.toUpperCase() = " + entity.toUpperCase());
    }
}
