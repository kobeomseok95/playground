package com.example.effectivejava.chapter03.item10;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

class CaseInsensitiveStringTest {

    static Point p1 = new Point(1, 0);
    static Point p2 = new Point(0, 1);
    static Point p3 = new Point(-1, 0);
    static Point p4 = new Point(0, -1);

    private static final Set<Point> unitCircle = Set.of(
            p1, p2, p3, p4, new CounterPoint(1, 1));

    public static boolean onUnitCircle(Point p) {
        return unitCircle.contains(p);
    }

    /**
     *  대칭성 > null을 제외하고 x.equals(y) 가 성립되면 y.equals(x)가 성립되어야 한다.
     *
     *  String은 CaseInsensitiveString을 모르기 때문에 애초에 이 둘을 비교해서는 안된다.
     * @throws Exception
     */
    @Test
    @DisplayName("동치 관계 - 대칭성1")
    void ex1() throws Exception {
        CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
        String s = "polish";
        assertNotEquals(cis, s);
//        assertEquals(s, cis); // s.equals(cis) 호출

//        List<CaseInsensitiveString> list = new ArrayList<>();
//        list.add(cis);
//        assertTrue(list.contains(s)); // s.equals(cis) 호출
    }

    /**
     *  추이성 > null이 아닌 모든 참조 값에 대해 x.equals(y), y.equals(z)라면,
     *      x.equals(z)이다.
     *  1. 부모타입과 자식의 컬러를 && 할 경우 동치성이 어긋난다.
     *  2. 부모 / 자식 타입에 따라 좌표만 / 좌표와 색상 모두 비교할 경우 추이성에 어긋난다.
     * @throws Exception
     */
    @Test
    @DisplayName("동치 관계 - 대칭성과 추이성")
    void ex2()throws Exception {
//        ColorPoint p1 = new ColorPoint(2, 1, Color.RED);
//        Point p2 = new Point(2, 1);
//        ColorPoint p3 = new ColorPoint(2, 1, Color.BLUE);
//
//        assertEquals(p1, p2);
//        assertEquals(p2, p3);
//        assertEquals(p1, p3);

        // stack over flow 발생
//        ColorPoint myColorPoint = new ColorPoint(1, 1, Color.BLUE);
//        SmellPoint mySmellPoint = new SmellPoint(1, 1, Color.BLUE);
//        myColorPoint.equals(mySmellPoint);

//        assertTrue(onUnitCircle(p1));

//        CounterPoint p4 = new CounterPoint(1, 1);
//        assertTrue(onUnitCircle(p4));
    }
}