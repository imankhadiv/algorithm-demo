package com.elrast.datastructre;

public class BasicStack<T> {

    private T[] data;
    private int stackPointer;

    public BasicStack() {
        data = (T[]) new Object[100];
    }

    public void push(T item) {
        if (stackPointer > data.length) {
            throw new IllegalStateException("Stack has no empty room");
        }
        data[stackPointer++] = item;

    }

    public T pop() {
        if (stackPointer <= 0) {
            throw new IllegalStateException("No more items on the stack!");
        }
        return data[--stackPointer];
    }

    public boolean contains(T item) {

        for (int i = 0; i < stackPointer; i++) {
            if (data[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    public T access(T item) {

        while (stackPointer > 0) {
            T tempItem = pop();
            if (tempItem.equals(item)) {
                return tempItem;
            }
        }
        throw new IllegalArgumentException("Can not find item on the stack" + item);
    }

    public int size() {
        return stackPointer;
    }

    public T peek() {
        if (stackPointer <= 0) {
            throw new IllegalStateException("No more items on the stack!");
        }
        return data[stackPointer];
    }
}
