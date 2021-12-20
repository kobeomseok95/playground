package com.example.effectivejava.chapter03.item10;

import lombok.ToString;

import java.util.Comparator;
import java.util.Objects;

@ToString
public class PhoneNumber implements Comparable<PhoneNumber>{
    private final short areaCode, prefix, lineNum;
    private static final Comparator<PhoneNumber> COMPARATOR =
            Comparator.comparingInt((PhoneNumber pn) -> pn.areaCode)
                    .thenComparingInt(pn -> pn.prefix)
                    .thenComparingInt(pn -> pn.lineNum);

    public PhoneNumber(int areaCode, int prefix, int lineNum) {
        this.areaCode = rangeCheck(areaCode, 999, "지역코드");
        this.prefix = rangeCheck(prefix, 999, "프리픽스");
        this.lineNum = rangeCheck(lineNum, 9999, "가입자 번호");
    }

    private static short rangeCheck(int val, int max, String arg) {
        if (val < 0 || val > max)
            throw new IllegalArgumentException(arg + ": " + val);
        return (short) val;
    }

    // equals를 비교할 때는 필드들의 동치성만 검사해도 충분
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PhoneNumber)) return false;
        PhoneNumber that = (PhoneNumber) o;
        return areaCode == that.areaCode && prefix == that.prefix && lineNum == that.lineNum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(areaCode, prefix, lineNum);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public int compareTo(PhoneNumber o) {
//        int result = Short.compare(areaCode, o.areaCode);
//        if (result == 0) {
//            result = Short.compare(prefix, o.prefix);
//            if (result == 0) {
//                result = Short.compare(lineNum, o.lineNum);
//            }
//        }
//        return result;
        return COMPARATOR.compare(this, o);
    }
}
