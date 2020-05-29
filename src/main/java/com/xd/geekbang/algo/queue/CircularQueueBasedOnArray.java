package com.xd.geekbang.algo.queue;

import java.util.ArrayList;

public class CircularQueueBasedOnArray<T> {
    private T[] data;
    private int capacity;
    private int front;
    private int end;

    public CircularQueueBasedOnArray(int capacity) {
        this.data = (T[])new Object[capacity+1];
        this.capacity = capacity+1;
        this.front = 0;
        this.end = 0;
    }

    public boolean enqueue(T t) {
       if ((end + 1) % capacity == front) return false;
       data[end] = t;
       end = (end + 1) % capacity;
       return true;
    }

    public T dequeue() {
        if (front == end) return null;
        T val = data[front];
        front = (front + 1) % capacity;
        return val;
    }
}

