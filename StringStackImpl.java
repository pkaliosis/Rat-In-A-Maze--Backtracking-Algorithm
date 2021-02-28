import java.io.PrintStream;
import java.util.*;


public class StringStackImpl implements StringStack {

    public int counter=0;
    public Node head;
    private class Node {
        private String str;
        private Node nxt;
        private Node(String str, Node nxt) {
            this.str = str;
            this.nxt = nxt;
        }
    }
    public boolean isEmpty() {
        return head==null;
    }

    public void push(String item) {
        head = new Node(item, head);
		counter ++;
    }

    public String pop() {
        if (isEmpty()) {
           throw new NoSuchElementException("The stack is empty!");
        }
        String oldS = head.str;
        Node pointer = head.nxt;
        head = pointer;
		counter--;
        return oldS;
    }

    public String peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("The stack is empty!");
        }
        return head.str;
    }

    public void printStack(PrintStream stream) {
        if (isEmpty()) {
            System.out.println("The stack is empty!");
        }
        Node temp = head;
        while (temp != null) {
            stream.println(temp.str);
            temp = temp.nxt;
        }
    }

    public int size() {
       return counter;
    }

    public boolean search(String s) {
        Node temp = head;
        while (temp != null) {
            if (s.equals(temp.str)) return true;
			temp = temp.nxt;
        }
		return false;
    }
}