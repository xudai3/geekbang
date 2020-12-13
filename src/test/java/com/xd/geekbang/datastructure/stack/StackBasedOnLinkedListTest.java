package com.xd.geekbang.datastructure.stack;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StackBasedOnLinkedListTest {

    @Test
    void pop() {
        StackBasedOnLinkedList<String> stack = new StackBasedOnLinkedList<>();
        stack.push("a");
        stack.push("b");
        assertEquals("b", stack.pop());
        assertEquals("a", stack.pop());
        assertEquals(null, stack.pop());
    }
}