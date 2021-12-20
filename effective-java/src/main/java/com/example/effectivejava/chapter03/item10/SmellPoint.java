package com.example.effectivejava.chapter03.item10;

public class SmellPoint extends Point {

    private final Color color;

    public SmellPoint(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (!(o instanceof ColorPoint))
//            return false;
//        return super.equals(o) && ((ColorPoint) o).color == color;
//    }
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Point))
            return false;
        if (!(o instanceof SmellPoint))
            return o.equals(this);
        return super.equals(o) && ((SmellPoint) o).color == color;
    }
}
