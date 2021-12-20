package com.example.effectivejava.chapter03.item13;

import lombok.Getter;

import java.util.Arrays;

@Getter
public class Stack implements Cloneable{

    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        System.out.println("생성자 실행");
        this.elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop() {
        if (size == 0)
            throw new IllegalStateException("에러");
        Object result = elements[size--];
        elements[size] = null;
        return result;
    }

    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        try {
            Stack stack = (Stack) super.clone();
            stack.elements = elements.clone();
            return stack;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
//        return super.clone();
    }
}
