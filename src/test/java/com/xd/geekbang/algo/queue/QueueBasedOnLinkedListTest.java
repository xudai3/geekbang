package com.xd.geekbang.algo.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueBasedOnLinkedListTest {

    @Test
    void dequeue() {
        QueueBasedOnLinkedList<String> queue = new QueueBasedOnLinkedList<>();
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        assertEquals("a", queue.dequeue());
        assertEquals("b", queue.dequeue());
        assertEquals("c", queue.dequeue());
        assertEquals(null, queue.dequeue());
    }
}