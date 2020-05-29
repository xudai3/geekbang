package com.xd.geekbang.algo.stack;

public class StackBasedOnLinkedList<T> {
    private ListNode top;

    public StackBasedOnLinkedList() {
        this.top = null;
    }

    public void push(T t) {
        ListNode node = new ListNode(t, null);
        if (top == null) {
           top = node;
        } else {
            node.next = top;
            top = node;
        }
    }

    public T pop() {
        if (top == null) return null;
        T val = top.getVal();
        top = top.next;
        return val;
    }

    private class ListNode {
        private T val;
        private ListNode next;

        public ListNode(T val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public T getVal() {
            return val;
        }
    }
}

