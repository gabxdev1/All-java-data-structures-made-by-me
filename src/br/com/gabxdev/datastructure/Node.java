package br.com.gabxdev.datastructure;

public class Node<T> {
    protected T data;
    protected Node<T> next;
    protected Node<T> prev;

    public Node(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public Node(T data, Node<T> next, Node<T> prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    @Override
    public String toString() {
        return this.data.toString();
    }
}
