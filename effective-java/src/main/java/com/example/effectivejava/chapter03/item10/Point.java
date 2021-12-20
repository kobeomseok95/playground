package com.example.effectivejava.chapter03.item10;

public class Point {

    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (!(o instanceof Point))
//            return false;
//        Point p = (Point) o;
//        return p.x == x && p.y == y;
//    }
//    // 리스코프 치환 원칙 위배
    @Override
    public boolean equals(Object o) {
        if (o == null || o.getClass() != getClass()) {
            return false;
        }
        Point p = (Point) o;
        return p.x == x && p.y == y;
    }
}
