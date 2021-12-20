package com.example.effectivejava.chapter03.item10;

public class ColorPoint {

    private final Point point;
    private final Color color;

    public ColorPoint(int x, int y, Color color) {
        this.point = new Point(x, y);
        this.color = color;
    }
//  // 동치성 위배
//    @Override
//    public boolean equals(Object o) {
//        if (!(o instanceof ColorPoint))
//            return false;
//        return super.equals(o) && ((ColorPoint) o).color == color;
//    }
//    // 추이성 위배
//    @Override
//    public boolean equals(Object o) {
//        if (!(o instanceof Point))
//            return false;
//        if (!(o instanceof ColorPoint))
//            return o.equals(this);
//        return super.equals(o) && ((ColorPoint) o).color == color;
//    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ColorPoint)) return false;
        ColorPoint that = (ColorPoint) o;
        return that.point.equals(point) && that.color.equals(color);
    }
}
