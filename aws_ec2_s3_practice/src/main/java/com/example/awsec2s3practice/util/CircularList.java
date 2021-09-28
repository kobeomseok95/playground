package com.example.awsec2s3practice.util;

import java.util.List;

public class CircularList<T> {

    private List<T> list;
    private static Integer counter = 0;

    public CircularList(List<T> list) {
        this.list = list;
    }

    public T getOne() {
        int circularSize = list.size();
        if (counter + 1 > circularSize) {
            counter = 0;
        }
        return list.get(counter++ % circularSize);
    }
}
