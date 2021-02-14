package chapter_02.ex3;

public interface Male extends Human {

    public static String SEX = "Male";

    @Override
    default String getSex(){
        return Male.SEX;
    }
}


