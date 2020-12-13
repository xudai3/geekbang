package com.xd.geekbang.datastructure.stack;

import java.util.ArrayList;

public class StackBasedOnArray<T> {
    private ArrayList<T> data;
    private int capacity;
    private int n;

    public StackBasedOnArray(int capacity) {
        this.data = new ArrayList<>(capacity);
        this.capacity = capacity;
        this.n = 0;
    }

    public boolean push(T t) {
        if (n == capacity) {
            return false;
        } else {
            data.add(n, t);
            n++;
            return true;
        }
    }

    public T pop() {
        if (n == 0) {
            return null;
        } else {
            T t = data.get(n-1);
            data.remove(n-1);
            n--;
            return t;
        }
    }

}
