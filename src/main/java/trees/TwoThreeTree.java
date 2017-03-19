package trees;

public class TwoThreeTree {

    private Node root;

    public Node find(String data) {
        if (root == null || data == null) {
            return null;
        }

        Node result = findNode(root, data);
        if (result.containsValue(data)) {
            return result;
        }
        return null;
    }

    //for find test
    public String getDataLeft(Node node){
        return node.dataLeft;
    }

    public boolean add(String data) {
        if (root == null) {
            root = new Node(null, data);
            return true;
        }
        if (data == null) {
            return false;
        }

        Node node = findNode(root, data);
        if (node == null || !node.isLeaf()) {
            return false;
        }

        if (node.isLeaf()) {
            node.addValue(data);
            if (node.isFourNode()) {
                splitFourNode(node);
            }
            return true;
        }
        return false;
    }

    // returns Node where data is, or (if not found) Node where it should be
    private Node findNode(Node currentNode, String data) {
        if (currentNode.containsValue(data)) {
            return currentNode;
        }
        if (currentNode.isLeaf()) {
            return currentNode;
        }

        if (data.compareTo(currentNode.dataLeft) < 0) {
            return findNode(currentNode.left, data);
        } else if (currentNode.dataRight != null && data.compareTo(currentNode.dataRight) < 0) {
            return findNode(currentNode.middle, data);
        } else {
            return findNode(currentNode.right, data);
        }
    }

    private void splitFourNode(Node fourNode) {
        Node node = fourNode;
        Node parent = node.parent;

        while (node.isFourNode()) {
            if (node.isLeaf()) {
                if (parent == null) {
                    node.left = new Node(node, node.dataLeft);
                    node.right = new Node(node, node.dataRight);
                    node.dataLeft = node.extraData;
                    node.dataRight = null;
                    node.extraData = null;
                    return;
                } else {
                    parent.addValue(node.extraData);
                    parent.addChild(new Node(parent, node.dataRight));
                    node.extraData = null;
                    node.dataRight = null;
                }
            } else {
                if (parent == null) {
                    Node newNode = new Node(null, node.dataRight, node.right, node.extraChild);
                    root = new Node(null, node.extraData, node, newNode);
                    node.right.parent = newNode;
                    node.extraChild.parent = newNode;
                    newNode.parent = root;

                    node.parent = root;
                    node.dataRight = null;
                    node.extraData = null;
                    node.right = node.middle;
                    node.middle = null;
                    node.extraChild = null;
                    return;
                } else {
                    Node newNode = new Node(root, node.dataRight, node.right, node.extraChild);
                    node.right.parent = newNode;
                    node.extraChild.parent = newNode;
                    node.right = node.middle;

                    parent.addValue(node.extraData);
                    parent.addChild(newNode);

                    node.middle = null;
                    node.dataRight = null;
                    node.extraChild = null;
                    node.extraData = null;
                }
            }
            node = parent;
            parent = parent.parent;
        }
    }

    public void printTree() {
        printTree(root, 0);
    }

    private void printTree(Node node, int level) {
        if (node == null) {
            return;
        }

        for (int i = 0; i < level; i++) {
            System.out.print("          ");
        }
        System.out.printf("[%s, %s]\n", node.dataLeft, node.dataRight != null ? node.dataRight : "");
        printTree(node.right, level + 1);
        printTree(node.middle, level + 1);
        printTree(node.left, level + 1);
    }

    public class Node {
        private Node parent;
        private Node left;
        private Node middle;
        private Node right;
        private Node extraChild;

        private String dataLeft;
        private String dataRight;
        private String extraData;

        public Node(Node parent, String data, Node left, Node right) {
            this.parent = parent;
            this.left = left;
            this.middle = null;
            this.right = right;

            this.dataLeft = data;
            this.dataRight = null;
            this.extraData = null;
        }

        public Node(Node parent, String data) {
        this(parent, data, null, null);
        }

        public boolean isLeaf() {
            if (left == null && right == null && middle == null) {
                return true;
            }
            return false;
        }

        public boolean hasOneValue() {
            if (dataLeft != null && dataRight == null) {
                return true;
            }
            return false;
        }

        public boolean hasTwoValues() {
            if (dataLeft != null && dataRight != null) {
                return true;
            }
            return false;
        }

        public boolean hasTwoChilds() {
            if (left != null && right != null && middle == null) {
                return true;
            }
            return false;
        }

        public boolean hasThreeChilds() {
            if (left != null && right != null && middle != null) {
                return true;
            }
            return false;
        }

        public boolean isFourNode() {
            if (dataLeft != null && dataRight != null && extraData != null) {
                return true;
            }
            return false;
        }

        public boolean containsValue(String data) {
            if (dataLeft.equals(data) || (dataRight != null && dataRight.equals(data))) {
                return true;
            }
            return false;
        }

        public void addValue(String data) {
            extraData = data;
            sortValues();
        }

        public void addChild(Node node) {
            extraChild = node;
            sortChilds();
        }

        // for four-Node extraData will be middle element
        private void sortValues() {
            String tmp;
            if (hasOneValue()) {
                if (dataLeft.compareTo(extraData) > 0) {
                    tmp = dataLeft;
                    dataLeft = extraData;
                    extraData = tmp;
                }
                dataRight = extraData;
                extraData = null;
            } else if (hasTwoValues()) {
                if (dataLeft.compareTo(extraData) > 0) {
                    tmp = dataLeft;
                    dataLeft = extraData;
                    extraData = tmp;
                }
                if (dataRight.compareTo(extraData) < 0) {
                    tmp = dataRight;
                    dataRight = extraData;
                    extraData = tmp;
                }
            }
        }

        // for four-Node extraChild will be middle element
        private void sortChilds() {
            if (left == null) {
                left = extraChild;
                extraChild = null;
            } else if ((isLeaf() && (hasOneValue()) || hasTwoChilds())) {
                Node tmp;
                if (left.dataLeft.compareTo(extraChild.dataLeft) > 0) {
                    tmp = left;
                    left = extraChild;
                    extraChild = tmp;
                }
                if (right.dataLeft.compareTo(extraChild.dataLeft) < 0) {
                    tmp = right;
                    right = extraChild;
                    extraChild = tmp;
                }
                middle = extraChild;
                extraChild = null;
            } else if (isLeaf() && (hasTwoValues()) || hasThreeChilds()) {
                Node tmp;
                if (left.dataLeft.compareTo(extraChild.dataLeft) > 0) {
                    tmp = left;
                    left = extraChild;
                    extraChild = tmp;
                }
                if (middle != null && middle.dataLeft.compareTo(extraChild.dataLeft) > 0) {
                    tmp = middle;
                    middle = extraChild;
                    extraChild = tmp;
                }
                if (right.dataLeft.compareTo(extraChild.dataLeft) > 0) {
                    tmp = right;
                    right = extraChild;
                    extraChild = tmp;
                }
                if (middle == null) {
                    middle = right;
                    right = extraChild;
                    extraChild = null;
                }
            }
        }
    }
}
