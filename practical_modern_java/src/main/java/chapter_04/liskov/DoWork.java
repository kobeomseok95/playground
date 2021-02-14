package chapter_04.liskov;

public class DoWork {
    public boolean work(Rectangle rectangle) {
        rectangle.setHeight(5);
        rectangle.setWidth(4);

        return rectangle.getArea() == 20;
    }

    public static void main(String[] args) {
        DoWork doWork = new DoWork();
        System.out.println("doWork.work(new Rectangle()) = " + doWork.work(new Rectangle()));
        System.out.println("doWork.work(new Square()) = " + doWork.work(new Square()));
    }
}
