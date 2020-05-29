package com.xd.geekbang.algo.queue;

import java.util.List;

public class QueueBasedOnLinkedList<T> {
    private ListNode head;

    public QueueBasedOnLinkedList() {
        head = new ListNode(null);
        head.next = head;
        head.prev = head;
    }

    public void enqueue(T t) {
        ListNode newNode = new ListNode(t);
        newNode.next = head;
        newNode.prev = head.prev;
        head.prev.next = newNode;
        head.prev = newNode;
    }

    public T dequeue() {
        if (head.next == head) return null;

        ListNode frontNode = head.next;
        T val = frontNode.val;
        head.next.prev = head;
        head.next = head.next.next;
        frontNode.val = null;
        frontNode.prev = null;
        frontNode.next = null;
        return val;
    }

    private class ListNode {
        private T val;
        private ListNode prev;
        private ListNode next;

        public ListNode(T val) {
            this.val = val;
        }
    }
}
