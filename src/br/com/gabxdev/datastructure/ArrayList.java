package br.com.gabxdev.datastructure;

public class ArrayList {
    private String[] elementData;
    private int size;
    private final int DEFAULT_CAPACITY = 10;

    public ArrayList() {
        this.elementData = new String[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public ArrayList(int initialCapacity) {
        this.elementData = new String[initialCapacity];
        this.size = 0;
    }

    public String get(int index) {
        checkIndex(index);
        return this.elementData[index];
    }

    public int get(String element) {
        for (int i = 0; i < this.size; i++) {
            if (elementData[i].equals(element))
                return i;
        }
        return -1;
    }

    public int size() {
        return this.size;
    }

    public void add(String e) {
        if (this.size == this.elementData.length)
            this.resize();
        this.elementData[size] = e;
        this.size += 1;
    }

    public void add(int index, String e) {
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

    public String remove(int index) {
        checkIndex(index);
        if ((this.size - 1) > index)
            System.arraycopy(this.elementData, index + 1, this.elementData, index, this.size - 1);
        String oldValue = this.elementData[index];
        this.elementData[this.size -= 1] = null;
        return oldValue;
    }

    public boolean remove(String element) {
        final int index;
        if ((index = this.get(element)) < 0) return false;
        this.remove(index);
        return true;
    }

    public void set(int index, String e) {
        checkIndex(index);
        this.elementData[index] = e;
    }

    private void resize() {
        int newCapacity;
        if (this.size == 1) newCapacity = (int) (this.elementData.length * 2);
        else newCapacity = (int) (this.elementData.length * 1.5);
        System.arraycopy(this.elementData, 0,
                this.elementData = new String[newCapacity],
                0, this.size);
    }

    private void checkIndex(int index) {
        if (!(index >= 0 && index < this.size))
            throw new IndexOutOfBoundsException(String.format(
                    "Index %d out of bounds for length %d", index, this.size));
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        for (int i = 0; i < this.size - 1; i++) {
            stringBuilder.append(elementData[i]).append(", ");
        }
        if (this.size > 0)
            stringBuilder.append(this.elementData[this.size - 1]);
        return stringBuilder.append("]").toString();
    }

    public void teste() {
        System.out.println("size " + this.size);
        System.out.println("length " + this.elementData.length);
    }
}