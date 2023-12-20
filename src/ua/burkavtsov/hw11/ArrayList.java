package ua.burkavtsov.hw11;

import java.util.Objects;

public class ArrayList<T> {
    private Object[] array;
    private int size;

    public ArrayList() {
        size = 0;
        array = new Object[10];
    }

    public ArrayList(int size) {
        this.size = size;
        array = new Object[size];
    }

    // New constructor added
    public ArrayList(T[] elements) {
        this.size = elements.length;
        this.array = new Object[size];
        System.arraycopy(elements, 0, array, 0, size);
    }

    public void add(T element) {
        if (size == array.length) {
            resizeArray();
        }
        array[size++] = element;
    }

    public void add(T element, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }

        if (size == array.length) {
            resizeArray();
        }

        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = element;
        size++;
    }

    public int indexOf(T element) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(array[i], element)) {
                return i;
            }
        }
        return -1;
    }

    public boolean isContains(T element) {
        return indexOf(element) != -1;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        return (T) array[index];
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        T removedElement = (T) array[index];
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        array[--size] = null;
        return removedElement;
    }

    private void resizeArray() {
        Object[] newArray = new Object[size * 2];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }
}