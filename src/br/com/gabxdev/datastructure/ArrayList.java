package br.com.gabxdev.datastructure;

import java.util.Arrays;
import java.util.Objects;

public class ArrayList<E> {
    private E[] elementData;
    private int size;
    private final int DEFAULT_CAPACITY = 10;

    public ArrayList() {
        this.elementData = (E[]) new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public ArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = (E[]) new Object[initialCapacity];
            this.size = 0;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
    }

    public E get(int index) {
        checkIndex(index);
        return this.elementData[index];
    }

    public E getFirst() {
        return this.elementData[0];
    }

    public E getLast() {
        return this.elementData[this.size - 1];
    }

    public int indexOf(Object element) {
        if (element == null) {
            for (int i = 0; i < this.size; i++) {
                if (elementData[i] == null)
                    return i;
            }
        } else {
            for (int i = 0; i < this.size; i++) {
                if (element.equals(this.elementData[i]))
                    return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(Object element) {
        if (element == null) {
            for (int i = this.size - 1; i >= 0; i--) {
                if (elementData[i] == null)
                    return i;
            }
        } else {
            for (int i = this.size - 1; i >= 0; i--) {
                if (element.equals(this.elementData[i]))
                    return i;
            }
        }
        return -1;
    }

    public boolean contains(Object element) {
        return this.indexOf(element) >= 0;
    }

    public int size() {
        return this.size;
    }

    public boolean add(E e) {
        if (this.size == this.elementData.length)
            this.resize();
        this.elementData[size] = e;
        this.size += 1;
        return true;
    }

    public void add(int index, E e) {
        checkIndex(index);
        if (this.size == this.elementData.length)
            resize();
        System.arraycopy(this.elementData, index,
                this.elementData,
                index + 1,
                this.size - index);
        this.elementData[index] = e;
        this.size += 1;
    }

    public void addFirst(E e) {
        this.add(0, e);
    }

    public void addLast(E e) {
        this.add(e);
    }

    public E remove(int index) {
        checkIndex(index);
        int newSize;
        if ((newSize = this.size - 1) > index)
            System.arraycopy(this.elementData, index + 1, this.elementData, index, newSize - index);
        E oldValue = this.elementData[index];
        this.elementData[this.size = newSize] = null;
        return oldValue;
    }

    public boolean remove(Object element) {
        final int index;
        if ((index = this.indexOf(element)) < 0) return false;
        return this.remove(index) != null;
    }

    public E removeFirst() {
        return this.remove(0);
    }

    public E removeLast() {
        return this.remove(this.size - 1);
    }

    public E set(int index, E e) {
        checkIndex(index);
        E oldElement = get(index);
        this.elementData[index] = e;
        return oldElement;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    private void resize() {
        int newCapacity;
        if (this.size == 1) newCapacity = (int) (this.elementData.length * 2);
        else newCapacity = (int) (this.elementData.length * 1.5);
        this.elementData = Arrays.copyOf(this.elementData, newCapacity);
    }

    private void checkIndex(int index) {
        if (!(index >= 0 && index < this.size))
            throw new IndexOutOfBoundsException(String.format(
                    "Index %d out of bounds for length %d", index, this.size));
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        for (int i = 0; i < this.size - 1; i++) {
            stringBuilder.append(elementData[i]).append(", ");
        }

        if (this.size > 0)
            stringBuilder.append(this.elementData[this.size - 1]);
        return stringBuilder.append("]").toString();
    }

    public void clear() {
        for (int i = 0; i < this.size; i++) {
            this.elementData[i] = null;
        }
        this.size = 0;
    }

    public ArrayList<E> subList(int fromIndex, int toIndex) {
        checkIndex(toIndex);
        if (!(fromIndex <= toIndex)) throw new IllegalArgumentException("fromIndex cannot be greater than toIndex");
        int newSize = (toIndex - fromIndex) + 1;
        ArrayList<E> newArrayList = new ArrayList<>(newSize);
        newArrayList.size = newSize;
        System.arraycopy(this.elementData, fromIndex, newArrayList.elementData, 0, newSize);
        return newArrayList;
    }

    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ArrayList<?> arrayList = (ArrayList<?>) o;
        return size == arrayList.size && Objects.deepEquals(elementData, arrayList.elementData);
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), Arrays.hashCode(elementData), size);
    }
}