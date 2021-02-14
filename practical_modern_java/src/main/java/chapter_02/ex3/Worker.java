package chapter_02.ex3;

public class Worker implements Female, Male {

//    public static final String MALE = "male";
//    public static final String FEMALE = "female";

    private int age;
    private String name;
    private String sex;

    public Worker(int age, String name, String sex) {
        this.age = age;
        this.name = name;
        this.sex = sex;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getInformation() {
        return "Name : " + name + " is " + age + " years old";
    }

    /**
     * getSex가 Male, Female에 작성되어있으므로 컴파일 에러 발생
     *
     * 극복방법
     * 1. 해당 클래스에서 getSex()를 Override
     * 2. super 키워드 사용
     *
     * 추상클래스, 인터페이스에 동일한 메서드가 있을 경우
     * 추상클래스가 우선권을 가진다.
     */

    //1. 해당 클래스에서 getSex()를 Override, 클래스에서 재정의
//    @Override
//    public String getSex() {
//        String returnValue = null;
//
//        if (sex != null && sex.equals("male")) {
//            returnValue = Worker.MALE;
//        } else if (sex != null && sex.equals("female")) {
//            returnValue = Worker.FEMALE;
//        } else {
//            returnValue = "N/A";
//        }
//
//        return returnValue;
//    }


    //2. super 키워드
    @Override
    public String getSex() {
        String returnValue = null;

        if (sex != null && sex.equals("male")) {
            returnValue = Male.super.getSex();
        } else if (sex != null && sex.equals("female")) {
            returnValue = Female.super.getSex();
        } else {
            returnValue = "N/A";
        }

        return returnValue;
    }
}
