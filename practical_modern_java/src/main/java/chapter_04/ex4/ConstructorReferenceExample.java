package chapter_04.ex4;

public class ConstructorReferenceExample {
    private String name;

    public ConstructorReferenceExample(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Laptop Brand Name :" + name;
    }
}
