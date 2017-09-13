package net.terzeron.linkedList;

/**
 * Created by terzeron on 2016. 11. 14..
 */
public class Node {
    int value;
    Node nextNode = null;

    public Node(int val) {
        value = val;
    }

    public Node next() {
        return nextNode;
    }

    public void setNext(Node nextNode) {
        this.nextNode = nextNode;
    }

    public String toString() {
        return "" + value;
    }
}
