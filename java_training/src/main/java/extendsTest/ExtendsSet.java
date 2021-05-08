package extendsTest;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class ExtendsSet<E> extends HashSet<E> {

    private int addCount = 0;

    @Override
    public boolean add(E e) {
        addCount++;
        System.out.println("호출!!");
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }

    public int getAddCount() {
        return this.addCount;
    }

    public static void main(String[] args) {
        ExtendsSet<String> customSet = new ExtendsSet<>();
        customSet.addAll(Arrays.asList("고", "범", "석"));
        System.out.println(customSet.getAddCount());
    }
}
