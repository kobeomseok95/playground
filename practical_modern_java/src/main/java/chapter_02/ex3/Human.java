package chapter_02.ex3;

public interface Human {

    public int getAge();

    public String getName();

    public String getSex();

    default String getInformation() {
        return "Human";
    }
}
