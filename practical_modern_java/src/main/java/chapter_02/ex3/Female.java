package chapter_02.ex3;

public interface Female extends Human {

    public static String SEX = "Female";

    @Override
    default String getSex(){
        return Female.SEX;
    }
}
