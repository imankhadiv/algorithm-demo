package com.elrast.datastructre;


public class BasicQueue<T> {

    private T[] data;
    private int front;
    private int end;

    public BasicQueue(int size) {
        front = -1;
        end = -1;
        data = (T[]) new Object[size];
    }

    public BasicQueue() {
        this(1000);
    }

    public int size() {

        if (front == -1 && end == -1) {
            return 0;
        } else {
            return end - front + 1;
        }
    }

    public void enQueue(T item) {

        if ((end + 1) % data.length == front) {
            throw new IllegalStateException("The Queue is full");
        } else if (size() == 0) {
            front++;
            end++;
            data[end] = item;
        } else {
            data[++end] = item;
        }
    }

    public T deQueue() {
        T item;
        if (size() == 0) {
            throw new IllegalStateException("Can not deque from empty queue");
        } else if (front == end) {
            item = data[front];
            front = -1;
            end = -1;
        } else {
            item = data[front++];
        }
        return item;
    }

    public boolean contains(T item) {

        for (int i = front; i < size(); i++) {
            if (data[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    public T access(int position) {
        if (position >= size() || size() == 0) {
            throw new IllegalStateException("Invalid position!");
        }
        int realPosition = 0;
        for (int i = front; i <= end; i++) {
            if (realPosition == position) {
                return data[i];
            }
            realPosition++;
        }
        throw new IllegalStateException("Could not get que item at position");
    }
}
