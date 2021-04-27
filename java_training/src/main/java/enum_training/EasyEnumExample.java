package enum_training;

import java.util.Arrays;

public class EasyEnumExample {

    public static final String PROCEEDING = "진행중";
    public static final String COMPLETE = "실행완료";

    enum Status {
        // 클래스라고 이해하면 쉬움!
        PROCEEDING(1, "진행중"), COMPLETE(2, "실행완료");

        private final int value;
        private final String name;

        Status(int value, String name) {
            this.value = value;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public int getValue() {
            return value;
        }
    }

    public static void main(String[] args) {
        String status1;
        Status status2;

        status1 = EasyEnumExample.COMPLETE;
        status1 = EasyEnumExample.PROCEEDING;
        status1 = "준비중";
        System.out.println("line 38 ======" + status1);
        
        status2 = Status.COMPLETE;
        status2 = Status.PROCEEDING;
        // status2 = "준비중"; 클래스 타입을 Enum으로 정의하여 컴파일 오류가 직접 발생하도록 함

        System.out.println("line 44 ======" + status2);
        System.out.println("line 45 ======");
        System.out.println(Status.valueOf("PROCEEDING"));
        System.out.println("line 47 ======");
        Arrays.stream(Status.values())
                .forEach(s -> System.out.println(s.name()));
        System.out.println("line 50 ======");
        Arrays.stream(Status.values())
                .forEach(s -> System.out.println(s.getName() + ", " + s.getValue()));
        System.out.println("line 53 ======");
        Status proceeding = Status.valueOf("PROCEEDING");
        System.out.println(proceeding.getName());
        System.out.println(proceeding.getValue());
    }
}
