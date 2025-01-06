package br.com.gabxdev.datastructure;

public class Node<T> {
    protected T data;
    protected Node next;
    protected Node prev;

    public Node(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public Node(T data, Node next, Node prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    @Override
    public String toString() {
        return this.data.toString();
    }
}
