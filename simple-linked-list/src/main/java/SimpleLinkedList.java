import java.io.*;
import java.util.NoSuchElementException;
import java.lang.reflect.Array;

class SimpleLinkedList<T> {

    private class Node{
        public T val;
        public Node next = null;
    }

    private Integer nodes;
    private Node head = null;
    
    SimpleLinkedList() {
        nodes = 0;
    }

    SimpleLinkedList(T[] values) {
        nodes = 0;
        for(int i = 0; i< values.length; i++){
            push(values[i]);
        }
    }

    void push(T value) {
        Node ptr = new Node();
        ptr.val = value;
        ptr.next = nodes++ == 0? null : head;
        head = ptr;
    }

    T pop() {
        if(nodes == 0){
            throw new NoSuchElementException("Empty list");
        }
        T value = head.val;
        head = nodes --> 1 ? head.next : null;
        return value;
    }

    void reverse() {
        if(nodes <= 1){
            return;
        }
        Node ptr = head.next, next, prev = head;
        while(ptr != null){
            next = ptr.next;
            ptr.next = prev;
            prev = ptr;
            ptr = next;
        }
        head = prev;
    }

    T[] asArray(Class<T> clazz) {
        T[] arr = (T[]) Array.newInstance(clazz,nodes);
        int index = 0;
        Node ptr = head;
        while(ptr != null){
            arr[index++] = ptr.val;
            ptr = ptr.next;
        }
        return arr;
    }

    int size() {
        return nodes;
    }
}
