package com.elrast.datastructre;

import java.util.ArrayList;
import java.util.List;

public class BBinaryTree<T extends Comparable<T>> {

    private Node root;
    private int size;


    public int size() {
        return size;
    }

    public void add(T item) {
        Node newNode = new Node(item);
        if (root == null) {
            root = newNode;
            size++;
        } else {
            insert(root, newNode);
        }
    }

    public boolean contains(T item) {
        return root != null && findNode(root, item) != null;
    }

    public boolean delete(T item) {
        boolean deleted = false;
        Node node = findNode(root, item);
        if (root == null || node == null) {
            deleted = false;
        } else if (node.getLeft() == null && node.getRight() == null) {

            unlinkNode(node, null);
            deleted = true;
        } else if (node.getLeft() != null && node.getRight() == null) {
            unlinkNode(node, node.getLeft());
            deleted = true;
        } else if (node.getRight() != null && node.getLeft() == null) {
            unlinkNode(node, node.getRight());
            deleted = true;
        } else {

            Node largestNde = node.getLeft();
            while (largestNde.getRight() != null) {
                largestNde = largestNde.getRight();
            }
            largestNde.getParent().setRight(null);
            unlinkNode(node, largestNde);
            largestNde.setRight(node.getRight());
            largestNde.setLeft(node.getLeft());
            deleted = true;

        }
        if (deleted) {
            size--;
        }
        return deleted;

    }

    private void unlinkNode(Node currentNode, Node newNode) {

        if (currentNode == root) {
            if (newNode == null) {
                currentNode = null;
            } else {
                newNode.setLeft(root.getLeft());
                newNode.setRight(root.getRight());
                this.root = newNode;
            }
        } else if (currentNode.getParent().getRight() == currentNode) {
            newNode.getParent().setRight(newNode);
        } else {
            currentNode.getParent().setLeft(newNode);
        }

    }

    private Node findNode(Node parent, T item) {

        if (parent.item.compareTo(item) == 0) {
            return parent;
        } else if (parent.getItem().compareTo(item) > 0) {
            if (parent.getLeft() == null) {
                return null;
            } else {
                return findNode(parent.getLeft(), item);
            }
        } else if (parent.getItem().compareTo(item) < 0) {
            if (parent.getRight() == null) {
                return null;
            } else {
                return findNode(parent.getRight(), item);
            }
        }

        return null;
    }

    private void insert(Node currentNode, Node newNode) {

        if (currentNode.getItem().compareTo(newNode.getItem()) < 0) {
            if (currentNode.getRight() == null) {
                currentNode.setRight(newNode);
                newNode.setParent(currentNode);
                size++;
            } else {
                insert(currentNode.getRight(), newNode);
            }
        } else if (currentNode.getItem().compareTo(newNode.getItem()) > 0) {
            if (currentNode.getLeft() == null) {
                currentNode.setLeft(newNode);
                newNode.setParent(currentNode);
                size++;
            } else {
                insert(currentNode.getLeft(), newNode);
            }
        } else {
            // duplicate values
        }
    }


    class Node {
        private Node left;
        private Node right;
        private Node parent;
        private T item;

        public Node(T item) {
            this.item = item;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public T getItem() {
            return item;
        }

        public void setItem(T item) {
            this.item = item;
        }
    }

    public static void main(String[] args) {

        BBinaryTree<Integer> b = new BBinaryTree<>();
        b.add(23);
        b.add(14);
        b.add(7);
        b.add(17);
        b.add(31);
        b.add(9);

        List<Integer> list = new ArrayList<>();
        System.out.println(b.postOrder(b.root, list, 0));
    }

    public List postOrder(Node root, List<Integer> list, int ca) {
        if (root != null) {
            postOrder(root.left, list, ++ca);
            postOrder(root.right, list, ++ca);
            list.add((Integer) root.item);
            return list;
        }
        return list;
    }

    public int depthCounter(Node root, Integer ca) {
        if (root != null) {
            depthCounter(root.left, ca++);
            depthCounter(root.right, ca++);
            return --ca;
        }
        return ca;
    }
}
