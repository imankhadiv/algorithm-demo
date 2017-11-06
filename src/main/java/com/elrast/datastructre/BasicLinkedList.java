package com.elrast.datastructre;

public class BasicLinkedList<T> {

    Node first;
    Node last;
    int nodeCount;

    public BasicLinkedList() {

        first = null;
        last = null;
        //nodeCount = 0;
    }

    public int size() {
        return nodeCount;
    }

    public void add(T item) {
        Node newNode = new Node(item);
        if (first == null) {
            first = newNode;
            last = first;
        } else {
            last.setNextNode(newNode);
            last = newNode;
        }
        nodeCount++;
    }

    public T remove() {

        if (nodeCount == 0) {
            throw new IllegalStateException("Can't remove from the empty list");
        }
        Node node = first;
        first = first.nextNode;
        if (first == null) { // if list had only one element
            last = null;
        }
        nodeCount--;
        return node.value;
    }

    public void insert(final T item, final int position) {

        if (position > nodeCount) {
            throw new IllegalStateException("Position can not be greater than list size");
        }
        Node newNode = new Node(item);
        Node currentNode = first;
        for (int i = 1; i < position; i++) {
            currentNode = currentNode.getNextNode();
        }
        if (position == 0) {
            newNode.setNextNode(currentNode);
            first = newNode;
        } else if (position == nodeCount) {
            currentNode.setNextNode(newNode);
            last = newNode;
        } else {
            Node next = currentNode.getNextNode();
            currentNode.setNextNode(newNode);
            newNode.setNextNode(next);
        }
        nodeCount++;
    }

    public T removeAt(final int position) {
        if (position >= nodeCount) {
            throw new IllegalStateException("Position can not be greater than list size");
        }
        T value;
        Node currentNode = first;
        for (int i = 1; i < position; i++) {
            currentNode = first.getNextNode();
        }
        if (position == 0) {
            first = currentNode.getNextNode();
            value = currentNode.getValue();
        } else if (position == nodeCount - 1) {
            value = currentNode.getNextNode().getValue();
            currentNode.setNextNode(null);
            last = currentNode;
        } else {
            Node removedNode = currentNode.getNextNode();
            value = removedNode.getValue();
            currentNode.setNextNode(removedNode.getNextNode());

        }
        nodeCount--;
        return value;
    }


    @Deprecated
    public T removeAt2(int position) {
        if (first == null) {
            throw new IllegalStateException("not valid");
        }
        Node currentNode = first;
        Node previousNode = first;
        for (int i = 1; i < position && currentNode != null; i++) {
            previousNode = currentNode;
            currentNode = currentNode.getNextNode();
        }
        T nodeItem = currentNode.getValue();
        previousNode.setNextNode(currentNode.getNextNode());
        nodeCount--;
        return nodeItem;

    }

    public T get(int position) {

        if (position >= nodeCount) {
            throw new IllegalStateException("not valid");
        }
        Node selectedNode = first;
        for (int i = 1; i <= position; i++) {
            selectedNode = selectedNode.getNextNode();
        }
        return selectedNode.getValue();
    }

    @Deprecated
    public int findItem(T item) {
        if (nodeCount == 0) {
            throw new IllegalStateException("List is empty!");
        }
        Node currentNode = first;
        int val = 0;
        for (int i = 0; i < nodeCount; i++) {
            if (currentNode.getValue().equals(item)) {
                return val;
            }
            currentNode = currentNode.getNextNode();
            val++;

        }
        return -1;
    }

    public int find(T item) {
        if (item == null || nodeCount == 0) {
            throw new IllegalStateException("Invalid!");
        }
        int idx = 0;
        for (Node node = first; node != null; node = node.getNextNode()) {

            if (node.getValue().equals(item)) {
                return idx;
            }
            idx++;
        }
        return -1;
    }

    public class Node {

        T value;
        Node nextNode;

        public Node(T t) {
            this.value = t;
            nextNode = null;
        }

        public T getValue() {
            return value;
        }

        public Node getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node node) {
            this.nextNode = node;
        }
    }


}