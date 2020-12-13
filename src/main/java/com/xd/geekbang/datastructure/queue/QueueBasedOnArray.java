package com.xd.geekbang.datastructure.queue;

import java.util.ArrayList;

public class QueueBasedOnArray<T> {
    private ArrayList<T> data;
    private int capacity;
    private int front;
    private int end;

    public QueueBasedOnArray(int capacity) {
        this.data = new ArrayList<>(capacity);
        this.capacity = capacity;
        this.front = 0;
        this.end = 0;
    }

    public boolean enqueue(T t) {
        if (end == capacity) {
            if (front == 0) return false;

            for (int i = front; i < end; i++) {
                data.set(i-front, data.get(i));
            }
            end -= front;
            front = 0;
        }

        data.add(end, t);
        end++;
        return true;
    }

    public T dequeue() {
        if (front == end) return null;
        T val = data.get(front);
        front++;
        return val;
    }
}
