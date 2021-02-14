package chapter_02.ex1;

public class InputImpl implements Input {

    int count = 10;

    @Override
    public int getTest() {
        return count;
    }

    public void nestedClassOutput() {
        System.out.println("TouchEvent.TOUCH_DOWN : " + TouchEvent.TOUCH_DOWN);
        System.out.println("TouchEvent.TOUCH_UP = " + TouchEvent.TOUCH_UP);

        // 중첩 클래스를 구현가능
        TouchEvent t = new TouchEvent();

    }

}
