package com.elrast.datastructre;

import java.util.ArrayList;
import java.util.List;

public class MinHeap<T extends Comparable<T>> {


    List<T> heap = new ArrayList<>();
    int count;

    public MinHeap() {
        this.count = 0;
    }

    public void addValue(T value) {

        heap.add(count, value);
        count++;
        minHeapify();
    }

    private void minHeapify() {
        int i = count - 1;
        while (i > 0 && heap.get((i - 1) / 2).compareTo(heap.get(i)) > 0) {
            int parentIndex = (i - 1) / 2;
            swap(parentIndex, i);
            i = (i - 1) / 2;

        }
    }

    private void swap(int parentIndex, int currentIndex) {
        T temp = heap.get(parentIndex);
        heap.set(parentIndex, heap.get(currentIndex));
        heap.set(currentIndex, temp);
    }


    public boolean contains(T value) {

        int i = 0;
        while (i < count && heap.get(i) != value) {
            i = i + 1;
        }
        return i < count;
    }

    public int findIndex(T value) {

        int i = 0;
        while (i < count && heap.get(i) != value) {
            i++;
        }
        return i < count ? i : -1;
    }

    public boolean remove(T value) {

        int index = findIndex(value);
        if (index == -1) return false;
        count--;
        heap.set(index, heap.get(count));
        while (left(index) < count && heap.get(index).compareTo(heap.get(left(index))) > 0 || heap.get(index).compareTo(heap.get(right(index))) > 0) {
            if (heap.get(left(index)).compareTo(heap.get(right(index))) < 0) {
                swap(left(index), index);
            } else {
                swap(right(index), index);
            }
        }
        return true;
    }

    private int left(int index) {

        return (2 * index + 1);
    }

    private int right(int index) {
        return 2 * index + 2;
    }
}
