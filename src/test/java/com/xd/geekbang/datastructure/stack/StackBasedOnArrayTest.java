package com.xd.geekbang.datastructure.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StackBasedOnArrayTest {

    @Test
    void push() {
        StackBasedOnArray<String> stack = new StackBasedOnArray<>(2);
        Assertions.assertEquals(true, stack.push("a"));
        Assertions.assertEquals(true, stack.push("b"));
        Assertions.assertEquals(false, stack.push("c"));
    }

    @Test
    void pop() {
        StackBasedOnArray<String> stack = new StackBasedOnArray<>(2);
        stack.push("a");
        assertEquals("a",stack.pop());
        stack.push("b");
        stack.push("c");
        assertEquals("c",stack.pop());
        assertEquals("b",stack.pop());
        assertEquals(null,stack.pop());
    }

}