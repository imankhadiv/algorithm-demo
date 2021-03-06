package com.elrast.datastructre;

import java.util.*;

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

    public Node getRoot() {
        return root;
    }

    class Node<T extends Comparable<T>> {
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

    public List<Integer> bFirst(Node root, List<Integer> list) {
        Queue<Node> queue = new LinkedList<>();
        while (root != null) {
            //list.add((Integer) root.getItem());
            if (root.left != null) {
                list.add((Integer) root.left.getItem());
                queue.add(root.getLeft());
            }
            if (root.right != null) {
                list.add((Integer) root.right.getItem());
                System.out.println("adding to queue ->" + root.getRight().getItem());
                queue.add(root.getRight());
            }
            if (!queue.isEmpty()) {
                root = queue.remove();
            } else {
                root = null;
            }
        }
        return list;
    }

    public int longestUnivaluePath(Node root) {
        int leftHeight = 0;
        int rightHeight = 0;
        if (root == null) {
            return 0;
        }
        if (root.left != null && root.left.getItem() != root.getItem()) {
            //return ;

        }
        leftHeight = longestUnivaluePath(root.left);
        rightHeight = longestUnivaluePath(root.right);
        return Integer.max(leftHeight, rightHeight) + 1;

    }

    public int longestConsecutiveSequence(Node root, int count) {
        int left = count;
        int right = count;
        if (root != null) {
            if (root.parent != null && (Integer) root.parent.getItem() + 1 == (Integer) root.getItem()) {
                count++;
            } else {
                //max = Integer.max(count, max);
                count = 1;
            }
            left = longestConsecutiveSequence(root.getLeft(), count);
            right = longestConsecutiveSequence(root.getRight(), count);
        }
        return Integer.max(left, right);
    }

    public int dfsHeight(Node root) {

        if (root == null) return 0;
        int leftHeight = dfsHeight(root.left);
        if (leftHeight == -1) return -1;
        int rightHeight = dfsHeight(root.right);
        if (rightHeight == -1) return -1;
        if (Math.abs(leftHeight - rightHeight) > 1) return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public boolean isBalanced(Node node) {
        return dfsHeight(node) != -1;
    }

    public List<Integer> findSecondGreatestNode(Node root, List<Integer> list) {

        if (root != null) {
            findSecondGreatestNode(root.getRight(), list);
            list.add((Integer) root.item);
        }
        return list;
    }

    public int longestConsecutiveSequence(Node root) {
        int left = 1;
        int right = 1;
        int count = 1;
        if (root != null) {
            System.out.println(root.item);
            if (root.parent != null && (Integer) root.parent.getItem() + 1 == (Integer) root.getItem()) {
                count++;
            } else {
                //max = Integer.max(count, max);
                count = 0;
            }
            left = count + longestConsecutiveSequence(root.getLeft(), count);
            right = count + longestConsecutiveSequence(root.getRight(), count);
        }
        return Integer.max(left, right);
    }

    public List<Integer> postO(Node root, List<Integer> list) {

        if (root == null) {
            return list;
        }
        postO(root.getLeft(), list);
        postO(root.getRight(), list);
        list.add((Integer) root.getItem());

        return list;
    }

    public int bfs(Node root) {

        int count = -1;
        Queue<Node> queue = new LinkedList<>();
        while (root != null) {
            System.out.println(root.getItem());
            if (root.getLeft() != null) {
                queue.add(root.getLeft());
            }
            if (root.getRight() != null) {
                queue.add(root.getRight());
            }
            if (!queue.isEmpty()) {
                root = queue.remove();
                count++;
            } else {
                root = null;
            }

        }
        return count;

    }

    public int fMax(Node root) {

        int left = -1;
        int right = -1;
        if (root != null) {
            left = 1 + fMax(root.getLeft());
            right = 1 + fMax(root.getRight());

        }
        return Integer.max(left, right);
    }

    public int fMax2(Node root) {

        int left = 0;
        int right = 0;
        if (root == null) {
            return -1;
        }
        left = 1 + fMax(root.getLeft());
        right = 1 + fMax(root.getRight());
        return Integer.max(left, right);
    }

    @Deprecated
    public Node convertSortedArrayToBinaryTreeWithMinHeight(Integer[] sortedArray) {

//        Node realRoot = root;
//        if (sortedArray.length == 1) {
//            if (realRoot == null) root = new Node((sortedArray[0]));
//            else if ((sortedArray[0]).compareTo((Integer) realRoot.getItem()) == 0)
//                realRoot.setRight(new Node(sortedArray[0]));
//            else realRoot.setLeft(new Node(sortedArray[0]));
//            return root;
//        } else {
//            realRoot = convertSortedArrayToBinaryTreeWithMinHeight(Arrays.copyOfRange(sortedArray, sortedArray.length / 2, sortedArray.length), realRoot);
//            convertSortedArrayToBinaryTreeWithMinHeight(Arrays.copyOfRange(sortedArray, 0, sortedArray.length / 2), realRoot);
//        }

        if (sortedArray.length == 1) {
            return new Node(sortedArray[0]);
        }
        Node node = new Node(sortedArray[sortedArray.length / 2]);
        node.left = convertSortedArrayToBinaryTree(Arrays.copyOfRange(sortedArray, 0, sortedArray.length / 2));
        node.right = convertSortedArrayToBinaryTree(Arrays.copyOfRange(sortedArray, sortedArray.length / 2 + 1, sortedArray.length));
        return node;
    }

    public Node convertSortedArrayToBinaryTree(Integer[] sortedArray) {
        return convertSortedArrayToBinaryTree(sortedArray, 0, sortedArray.length - 1);
    }

    private Node convertSortedArrayToBinaryTree(Integer[] sortedArray, int start, int end) {

        if (end < start) return null;
        int mid = (start + end) / 2;
        Node node = new Node(sortedArray[mid]);
        node.left = convertSortedArrayToBinaryTree(sortedArray, start, mid - 1);
        node.right = convertSortedArrayToBinaryTree(sortedArray, mid + 1, end);
        return node;
    }

    public List<LinkedList<Node>> putNodesInTheSameLevelToLinkedList(Node root) {
        List<LinkedList<Node>> list = new ArrayList<>();
        LinkedList<Node> current = new LinkedList<>();
        if (root != null) {
            current.push(root);
        }
        while (!current.isEmpty()) {
            list.add(current);
            LinkedList<Node> parents = current;
            current = new LinkedList<>();
            for (Node node : parents) {
                if (node.getLeft() != null) {
                    current.push(node.getLeft());
                }
                if (node.getRight() != null) {
                    current.push(node.getRight());
                }
            }
        }
        return list;
    }

    public boolean isBinaryTreeABinarySearchTree(Node<Integer> root) {

        return checkIfOrdered(isBinaryTreeABinarySearchTree(root, new ArrayList<Integer>()));
    }

    private boolean checkIfOrdered(List<Integer> list) {

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).compareTo(list.get(i + 1)) > 0) {
                return false;
            }
        }
        return true;
    }

    private List<Integer> isBinaryTreeABinarySearchTree(Node<Integer> root, List<Integer> list) {

        if (root != null) {
            isBinaryTreeABinarySearchTree(root.getLeft(), list);
            list.add(root.getItem());
            isBinaryTreeABinarySearchTree(root.getRight(), list);
        }
        return list;
    }

    public boolean checkIfValidBTreeSearch(Node root) {

        return checkIfValidBTreeSearch(root, null, null);
    }

    // min max approach!
    private boolean checkIfValidBTreeSearch(Node root, Integer min, Integer max) {

        if (root == null) return true;
        if ((min != null && 1 != root.getItem().compareTo(min)) || (max != null && root.getItem().compareTo(max) > 0))
            return false;
        if (checkIfValidBTreeSearch(root.getLeft(), min, (Integer) root.getItem()) || checkIfValidBTreeSearch(root.getRight(),
                (Integer) root.getItem(), max)) return false;
        return true;
    }
}

