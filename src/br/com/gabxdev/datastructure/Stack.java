//package br.com.gabxdev.datastructure;
//
//public class Stack<E> {
//    private ArrayList<E> elementData;
//
//    public Stack() {
//        this.elementData = new ArrayList<>();
//    }
//
//    public Stack(int initialCapacity) {
//        this.elementData = new ArrayList<>(initialCapacity);
//    }
//
//    public void push(E e) {
//        this.elementData.add(e);
//    }
//
//    public E pop() {
//        return this.elementData.removeLast();
//    }
//
//    public E peek() {
//        return this.elementData.getLast();
//    }
//
//    public boolean empty() {
//        return this.elementData.size == 0;
//    }
//
//    public E search(int index) {
//        return this.elementData.get(index);
//    }
//
//    public int size() {
//        return this.elementData.size;
//    }
//
//    public String toString() {
//        return this.elementData.toString();
//    }
//}