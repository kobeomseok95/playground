package chapter_04.liskov;

public class Rectangle {
    protected double width;
    protected double height;

    public double getArea() {
        return this.getWidth() * this.getHeight();
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
