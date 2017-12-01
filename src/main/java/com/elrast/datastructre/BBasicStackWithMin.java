package com.elrast.datastructre;

public class BBasicStackWithMin<T extends Comparable<T>> extends BasicStack<T> {

    BasicStack<T> minStack;

    public BBasicStackWithMin() {
        super();
        minStack = new BasicStack();
    }

    @Override
    public void push(T item) {
        T val = min();
        if (val == null || item.compareTo(val) < 0) {
            minStack.push(item);
        }
        super.push(item);
    }

    @Override
    public T pop() {
        T val = super.pop();
        if (min().compareTo(val) == 0) {
            minStack.pop();
        }
        return val;

    }

    public T min() {

        if (minStack.size() == 0) {
            return null;
        }
        return minStack.peek();
    }
}
