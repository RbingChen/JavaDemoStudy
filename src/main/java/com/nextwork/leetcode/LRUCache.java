package com.nextwork.leetcode;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    int capacity;
    int size;
    class DListNode{
        int key;
        int value;
        DListNode pre;
        DListNode next;
        public DListNode (){}
        public DListNode(int key,int value){
            this.key = key;
            this.value = value;
        }
    }
    private DListNode head,tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new DListNode();
        tail = new DListNode();
        head.next = tail;
        tail.pre = head;

    }
    Map<Integer,DListNode> map = new HashMap();
    public int get(int key) {
        if(capacity==0) return -1;
        DListNode t = map.get(key);
        if(t==null) return -1;
        moveToHead(t);
        return t.value;
    }

    public void put(int key, int value) {
        DListNode t = map.get(key);
        if(t!=null){
            t.value = value;
            moveToHead(t);
            return;
        }
        if(size==this.capacity){
            removeTail();
            addHead(key,value);
            return ;
        }
        addHead(key,value);
        size++;
    }
    public void removeTail(){
        int k = tail.pre.key;
        map.remove(k);
        tail.pre = tail.pre.pre;
        tail.pre.next = tail;
    }
    public void moveToHead(DListNode t){
        t.pre.next = t.next;
        t.next.pre = t.pre;
        t.next = head.next;
        t.pre = head;
        head.next.pre = t;
        head.next = t;
    }
    public void addHead(int key,int value){
        DListNode t = new DListNode(key,value);
        map.put(key,t);
        t.pre = head;
        t.next = head.next;
        head.next =t ;
        t.next.pre = t;
    }

}
