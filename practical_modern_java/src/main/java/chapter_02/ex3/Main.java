package chapter_02.ex3;

public class Main {
    public static void main(String[] args) {

//        Worker worker = new Worker(26, "범석", Worker.MALE);
//        System.out.println(worker.getSex());
//        System.out.println(worker.getInformation());

        Worker worker = new Worker(26, "범석", "female");
        System.out.println(worker.getInformation() + ", " + worker.getSex());
    }
}
