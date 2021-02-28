import java.io.PrintStream;
import java.util.*;

public class StringQueueWithOnePointer {
    private int ctr=0;
    private Node tail;
    private class Node {
        Node next;
        String str;
        Node() {
        }
        Node (String str) {
            this.str = str;
            next = null;
        }
    }
    
    public boolean isEmpty() {
        return tail == null;
    }

    public void put(String str) {
        if (ctr==0) {
            tail = new Node();
            tail.next = tail;
            tail.str = str;
            ctr++;
        }
        else{
			Node pointer = tail.next;
            Node temp = new Node (str);
            tail.next = temp;
			temp.next = pointer;
			tail = temp;
           ctr++;
        }
    }

    public String get() {
        if (isEmpty()) {
            throw new NoSuchElementException("The queue is empty!");
        }
        String oldS = tail.next.str;
		tail.next = tail.next.next;
        ctr--;
        return oldS;
    }

    public String peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("The queue is empty!");
        }
        return tail.next.str;
    }

    public void printQueue(PrintStream stream) {
        if (isEmpty()) {
            System.out.println("The queue is empty!");
        }
        Node temp = tail.next;
        for (int i=0; i<this.ctr; i++) {
            stream.println(temp.str);
            temp = temp.next;
        }
    }

    public int size() {
        return this.ctr;
    }
}