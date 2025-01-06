package br.com.gabxdev.datastructure;

import java.util.NoSuchElementException;

public class LinkedList<T> {
    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addLast(T element) {
        Node<T> newNode = new Node<>(element);
        if (this.isEmpty()) {
            this.head = this.tail = newNode;
        } else {
            this.tail.next = newNode;
            newNode.prev = this.tail;
            this.tail = newNode;
        }
        this.size++;
    }

    public void addFirst(T element) {
        Node<T> newNode = new Node<>(element);
        if (isEmpty()) {
            this.head = this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head.prev = newNode;
            this.head = newNode;
        }
        size++;
    }

    public void add(T element) {
        addLast(element);
    }

    public void add(int index, T element) {
        checkPositionIndex(index);

        if (index == this.size)
            this.addLast(element);
        else if (index == 0)
            this.addFirst(element);
        else
            linkBefore(element, node(index));
    }

    void linkBefore(T element, Node<T> succ) {
        Node pred = succ.prev;
        Node<T> newNode = new Node<>(element, succ, pred);
        succ.prev = newNode;
        pred.next = newNode;
        this.size++;
    }

    public T get(int index) {
        checkIndex(index);
        return node(index).data;
    }

    private Node<T> node(int index) {
        if (index < (size >> 1)) {
            Node<T> x = this.head;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<T> x = this.tail;
            for (int i = this.size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    public int indexOf(T object) {
        if (object == null) {
            Node<T> current = this.head;
            for (int i = 0; i < this.size; i++) {
                if (current.data == null)
                    return i;
                current = current.next;
            }
        } else {
            Node<T> current = this.head;
            for (int i = 0; i < this.size; i++) {
                if (object.equals(current.data))
                    return i;
                current = current.next;
            }
        }
        return -1;
    }

    public boolean contains(T element) {
        return this.indexOf(element) > -1;
    }

    public T remove() {
        return this.removeFirst();
    }

    public boolean remove (T element) {
        if (element == null) {
            Node<T> x = this.head;
            for (int i = 0; i < this.size; i++) {
                if (x.data == null) {
                    unlink(x);
                    return true;
                }
                x = x.next;
            }
        } else {
            Node<T> x = this.head;
            for (int i = 0; i < this.size; i++) {
                if (element.equals(x.data)) {
                    unlink(x);
                    return true;
                }
                x = x.next;
            }
        }
        return false;
    }

    public T remove(int index) {
       checkIndex(index);
       return unlink(node(index));
    }

    public T removeFirst() {
        if (this.isEmpty())
            throw new NoSuchElementException();
        T data = (T) this.head.data;
        if (this.head == this.tail)
            this.head = this.tail = null;
        else {
            this.head = head.next;
            this.head.prev = null;
        }
        size--;
        return data;
    }

    public T removeLast() {
        if (this.isEmpty())
            throw new NoSuchElementException();
        T data = (T) this.tail.data;
        if (this.head == this.tail)
            this.head = this.tail = null;
        else {
            this.tail = this.tail.prev;
            this.tail.next = null;
        }
        size--;
        return data;
    }

    T unlink(Node<T> x) {
        final T element = x.data;
        final Node<T> prev = x.prev;
        final Node<T> next = x.next;
        if (x == this.head)
            removeFirst();
        else if (x == this.tail)
            removeLast();
        else {
            x.prev.next = next;
            x.next.prev = prev;
            this.size--;
        }
        return element;
    }

    private void checkIndex(int index) {
        if (!(index >= 0 && index < this.size))
            throw new IndexOutOfBoundsException(
                    String.format("Index: %d, Size: %d", index, this.size));
    }

    private void checkPositionIndex(int index) {
        if (!(index >= 0 && index <= this.size))
            throw new IndexOutOfBoundsException(
                    String.format("Index: %d, Size: %d", index, this.size));
    }

    @Override
    public String toString() {
        if (this.isEmpty())
            return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> current = this.head;
        for (int i = 0; i < (this.size - 1); i++) {
            sb.append(current.data).append(", ");
            current = current.next;
        }
        if (this.size > 0)
            sb.append(current.data);
        return sb.append("]").toString();
    }
}
