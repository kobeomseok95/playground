package chapter_04.liskov;

public class Main {
    public static void main(String[] args) {
        DoWork doWork = new DoWork();
        System.out.println("doWork.work(new Rectangle()) = " + doWork.work(new Rectangle()));
        System.out.println("doWork.work(new Square()) = " + doWork.work(new Square()));
    }
}
