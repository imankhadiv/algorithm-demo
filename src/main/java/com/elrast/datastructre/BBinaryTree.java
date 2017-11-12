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


        List<Integer> postOrderList = new ArrayList<>();
        // System.out.println(b.postOrder(b.root, list, 0));
        System.out.println("Printing postOrder...");
        System.out.println(b.postOrder(b.root, postOrderList));
        //System.out.println(b.postOrder(b.root, list));
        System.out.println("Printing preorder...");
        List<Integer> preOrderList = new ArrayList<>();
        System.out.println(b.preOrder(b.root, preOrderList));
        List<Integer> inOrderList = new ArrayList<>();
        System.out.println(b.inOrder(b.root, inOrderList));


    }

    public List postOrder(Node root, List<Integer> list) {
        if (root != null) {
            postOrder(root.left, list);
            postOrder(root.right, list);
            list.add((Integer) root.item);
        }
        return list;
    }

    public List preOrder(Node root, List<Integer> list) {

        if (root != null) {
            list.add((Integer) root.item);
            preOrder(root.getLeft(), list);
            preOrder(root.getRight(), list);
        }
        return list;
    }

    public List inOrder(Node root, List<Integer> list) {
        if (root != null) {
            inOrder(root.getLeft(), list);
            list.add((Integer) root.getItem());
            inOrder(root.getRight(), list);
        }
        return list;
    }

    public int findHeight(Node root) {
        int leftHeight = -1;
        int rightHeight = -1;
        int height = 0;
        if (root == null) {
            return -1;
        }
        leftHeight = findHeight(root.getLeft());
        rightHeight = findHeight(root.getRight());
        return Integer.max(leftHeight, rightHeight) + 1;
    }

}
