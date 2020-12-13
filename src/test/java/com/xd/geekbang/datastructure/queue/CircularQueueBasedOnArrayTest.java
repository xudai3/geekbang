package com.xd.geekbang.datastructure.queue;

import org.junit.jupiter.api.Test;

class CircularQueueBasedOnArrayTest {

    @Test
    void enqueue() {
        CircularQueueBasedOnArray<String> queue = new CircularQueueBasedOnArray<>(3);
        assertEquals(true, queue.enqueue("a"));
        assertEquals(true, queue.enqueue("b"));
        assertEquals(true, queue.enqueue("c"));
        assertEquals(false, queue.enqueue("d"));
        assertEquals("a", queue.dequeue());
        assertEquals(true, queue.enqueue("d"));
        assertEquals("b", queue.dequeue());
        assertEquals("c", queue.dequeue());
        assertEquals("d", queue.dequeue());
        assertEquals(null, queue.dequeue());
    }

    @Test
    void dequeue() {
    }
}