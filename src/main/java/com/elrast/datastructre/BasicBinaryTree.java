package com.elrast.datastructre;


public class BasicBinaryTree<T extends Comparable<T>> {

    private Node root;
    private int size;

    public BasicBinaryTree(Node root) {
        this.root = null;
    }

    public int size() {
        return size;
    }

    public void add(T item) {

        Node node = new Node(item);
        if (root == null) {
            root = node;
            size++;
        } else {
            insert(root, node);
        }
    }

    public boolean contains(T item) {

        if (root == null) {
            throw new IllegalStateException("Tree is empty!");
        } else
            return item == root.item || contains(root, item);
    }

    public boolean delete(T item) {

        boolean deleted = false;
        if (root == null) {
            return false;
        }
        Node currentNode = getNode(item);
        if (currentNode != null) {
            if (currentNode.getLeft() == null && currentNode.getRight() == null) {
                unlink(currentNode, null);
            } else if (currentNode.getLeft() == null) {
                unlink(currentNode, currentNode.getRight());
            } else if (currentNode.getRight() == null) {
                unlink(currentNode, currentNode.getLeft());
            } else {
                Node child = currentNode.getLeft();
                while (child.getRight() != null && child.getLeft() != null) {
                    child = child.getRight();
                }
                child.getParent().setRight(null);
                child.setLeft(currentNode.getLeft());
                child.setRight(currentNode.getRight());
                unlink(currentNode, child); // change the location of current node with child
            }
            deleted = true;
            size--;
        }

        return deleted;
    }

    private void unlink(Node currentNode, Node newNode) {
        if (currentNode == root) {
            newNode.setLeft(currentNode.getLeft());
            newNode.setRight(currentNode.getRight());
            this.root = newNode;
        } else if (currentNode.getParent().getRight() == currentNode) {
            currentNode.getParent().setRight(newNode);
        } else {
            currentNode.getParent().setLeft(newNode);
        }
    }

    private Node getNode(T item) {
        Node currentNode = root;
        while (currentNode != null) {
            int value = item.compareTo(currentNode.item);
            if (value == 0) {
                return currentNode;
            } else if (value < 0) {
                currentNode = currentNode.getLeft();
            } else {
                currentNode = currentNode.getRight();
            }
        }
        return null;
    }

    private boolean contains(Node parent, T item) {

        if (parent.getLeft() != null && item.compareTo(parent.item) < 0) {
            if (item == parent.getLeft().item) {
                return true;
            } else {
                contains(parent.getLeft(), item);
            }
        } else if (parent.getRight() != null && item.compareTo(parent.item) > 0) {
            if (item == parent.getRight().item) {
                return true;
            } else {
                contains(parent.getRight(), item);
            }
        }
        return false;
    }

    private void insert(Node parent, Node child) {

        if (child.item.compareTo(parent.item) < 0) {

            if (parent.getLeft() == null) {
                parent.setLeft(child);
                child.setParent(parent);
                size++;
            } else {
                insert(parent.getLeft(), child);
            }

        } else if (child.item.compareTo(parent.item) > 0) {
            if (parent.getRight() == null) {
                parent.setRight(child);
                child.setParent(parent);
                size++;
            } else {
                insert(parent.getRight(), child);
            }
        } else {
            throw new IllegalStateException("Duplicate Node!");
        }
    }

    private class Node {
        private T item;
        private Node parent;
        private Node left;
        private Node right;

        public Node(T item) {
            this.item = item;
            parent = null;
            left = null;
            right = null;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
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
    }
}
