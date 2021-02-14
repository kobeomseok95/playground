package chapter_02.ex2;

public class Main {
    public static void main(String[] args) {
        // 인터페이스 내에 디폴트 메서드 사용
        CountryAddress c = new CountryAddress(0, "123", "123", "123-123");
        CountryAddress a = new CountryAddress(3, "123", "123", "123-123");
        CountryAddress b = new CountryAddress(1, "123", "123", "123-123");

        System.out.println("c.getCountry() = " + c.getCountry());
        System.out.println("a.getCountry() = " + a.getCountry());
        System.out.println("b.getCountry() = " + b.getCountry());

        // 해당 국가에서 코드를 반환하는 경우
        CountryAddress d = new CountryAddress(0, "123", "123", "123-123");
        System.out.println(d.getDefaultCountry().equals("Korea"));
    }
}
