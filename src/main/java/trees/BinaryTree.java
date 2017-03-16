package trees;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Egor on 08-Mar-17.
 */
public class BinaryTree {

    private Node root;
    private int size;
    private int height;

    public BinaryTree() {
        root = null;
        size = 0;
        height = 0;
    }

    public boolean add(String data) {
        if (root == null) {
            root = new Node(data, 0);
            size++;
            return true;
        }
        return add(root, data, 1);
    }

    public Node find(String searchData) {
        if (root == null) {
            return null;
        }
        return find(root, searchData);
    }

    public void dfsPreOrderRead() {
        dfsPreOrderRead(root);
        System.out.println();
    }

    public void dfsInOrderRead() {
        dfsInOrderRead(root);
        System.out.println();
    }

    public void dfsPostOrderRead() {
        dfsPostOrderRead(root);
        System.out.println();
    }

    public void bfsRead() {
        if (root == null) {
            return;
        }
        Deque<Node> stack = new LinkedList<>();
        Node currentNode;
        stack.add(root);

        while (!stack.isEmpty()) {
            currentNode = stack.poll();
            System.out.print(currentNode.data + " ");
            if (currentNode.left != null) {
                stack.add(currentNode.left);
            }
            if (currentNode.right != null) {
                stack.add(currentNode.right);
            }
        }
        System.out.println();
    }

    public int size() {
        return size;
    }

    public static int rank(Node node) {
        return node.rank;
    }

    public int height() {
        return height;
    }

    public static int depth(Node node) {
        return node.depth;
    }

    private Node find(Node currentRoot, String searchData) {
        if (currentRoot == null) {
            return null;
        }
        if (currentRoot.data.equals(searchData)) {
            return currentRoot;
        }
        if (currentRoot.data.compareTo(searchData) > 0) {
            return find(currentRoot.left, searchData);
        } else {
            return find(currentRoot.right, searchData);
        }
    }

    private boolean add(Node currentRoot, String data, int currentLevel) {
        currentRoot.rank++;
        if (currentRoot.data.compareTo(data) > 0) {
            if (currentRoot.left != null) {
                add(currentRoot.left, data, currentLevel + 1);
            } else {
                currentRoot.left = new Node(data, currentLevel);
                if (currentLevel > height) {
                    height = currentLevel;
                }
                size++;
                return true;
            }
        } else {
            if (currentRoot.right != null) {
                add(currentRoot.right, data, currentLevel + 1);
            } else {
                currentRoot.right = new Node(data, currentLevel);
                if (currentLevel > height) {
                    height = currentLevel;
                }
                size++;
                return true;
            }
        }
        return false;
    }

    private void dfsPreOrderRead(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        dfsPreOrderRead(node.left);
        dfsPreOrderRead(node.right);
    }

    private void dfsInOrderRead(Node node) {
        if (node == null) {
            return;
        }
        dfsInOrderRead(node.left);
        System.out.print(node.data + " ");
        dfsInOrderRead(node.right);
    }

    private void dfsPostOrderRead(Node node) {
        if (node == null) {
            return;
        }
        dfsPostOrderRead(node.left);
        dfsPostOrderRead(node.right);
        System.out.print(node.data + " ");
    }

    private class Node {
        private String data;
        private Node left;
        private Node right;
        private int rank;
        private int depth;

        public Node(String data, Node left, Node right, int depth) {
            this.data = data;
            this.left = left;
            this.right = right;
            this.depth = depth;
            rank = 0;
        }

        public Node(String data, int depth) {
            this(data, null, null, depth);
        }
    }
}
