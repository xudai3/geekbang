package com.xd.geekbang.datastructure.queue;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class QueueBasedOnArrayTest {

    @Test
    void enqueue() {
        QueueBasedOnArray<String> queue = new QueueBasedOnArray<>(3);
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
        QueueBasedOnArray<String> queue = new QueueBasedOnArray<>(3);
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        assertEquals("a", queue.dequeue());
        assertEquals("b", queue.dequeue());
        assertEquals("c", queue.dequeue());
        assertEquals(null, queue.dequeue());
    }
}