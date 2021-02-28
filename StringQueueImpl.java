import java.io.PrintStream;
import java.util.*;

public class StringQueueImpl implements StringQueue {

    private Node head, tail;
	private int ctr = 0;
    private class Node {
        String str;
        Node nxt;
        private Node(String str) {
            this.str = str;
            nxt = null;
        }
    }
    public boolean isEmpty() {
        return head==null;
    }

    public void put(String str) {
        Node oldT = tail;
        tail = new Node(str);
        if (isEmpty()){
            head = tail;
        }
        else {
            oldT.nxt = tail;
        }
		ctr++;
    }

    public String get() {
        if (isEmpty()) {
            throw new NoSuchElementException("The queue is empty!");
        }
        String oldS = head.str;
        Node pointer = head.nxt;
        head = pointer;
		ctr--;
        return oldS;
    }

    public String peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("The queue is empty!");
        }
        return head.str;
    }

    public void printQueue(PrintStream stream) {
        if (isEmpty()) {
            System.out.println("The queue is empty!");
        }
        Node temp = head;
        while (temp != tail) {
            stream.println(temp.str);
            temp = temp.nxt;
        }
        stream.println(temp.str);
    }


    public int size() {
        return ctr;
    }
}
