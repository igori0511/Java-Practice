import exception.TreeEmptyException;

public class BinaryTree {

    public static final String TREE_IS_EMPTY = "Tree is empty";
    private Node root;
    private int count = 0;

    private class Node {
        Node left;
        Integer item;
        Node right;

        private Node(Integer item) {
            this.item = item;
        }
    }

    // insert value into tree
    public void insert(Integer item) {
        if (root == null) {
            root = new Node(item);
        } else {
            final Node nodeToInsert = new Node(item);
            final Node foundNode = find(item, root);
            if (item.compareTo(foundNode.item) > 0) {
                foundNode.right = nodeToInsert;
            } else {
                foundNode.left = nodeToInsert;
            }
        }
        count++;
    }

    // find an item in the tree
    public Integer find(Integer item) {
        if (root == null) throw new TreeEmptyException(TREE_IS_EMPTY);
        Node foundNode = find(item, root);
        return foundNode.item;
    }

    private Node find(Integer item, Node root) {
        if (item.compareTo(root.item) == 0) {
            return root;
        } else if (item.compareTo(root.item) < 0) {
            if (root.left != null) {
                return find(item, root.left);
            }
            return root;
        } else {
            if (root.right != null) {
                return find(item, root.right);
            }
            return root;
        }
    }

    // get count of values stored
    public Integer getNodeCount() {
        return count;
    }

    // prints the values in the tree, from min to max
    public void printValues() {
        if (root == null) throw new TreeEmptyException(TREE_IS_EMPTY);
        print(root);
    }

    private void print(Node root) {
        if (root != null) {
            System.out.print(String.format("%s ", root.item));
            print(root.left);
            print(root.right);
        }
    }

    // delete tree
    public void deleteTree() {
        if (root == null) throw new TreeEmptyException(TREE_IS_EMPTY);
        deleteTreePostOrder(root);
        root = null;
    }

    public void deleteTreePostOrder(Node root) {
        if (root != null) {
            deleteTreePostOrder(root.left);
            deleteTreePostOrder(root.right);
            root.left = null;
            root.right = null;
        }
    }

    // returns true if given value exists in the tree
    public boolean isInTree(Integer item) {
        return find(item) != null;
    }

    // returns the height in nodes (single node's height is 1)
    public Integer getHeight() {
        return getHeight(root);
    }

    private Integer getHeight(Node root) {
        if (root == null)
            return 0;
        else {
            int lDepth = getHeight(root.left);
            int rDepth = getHeight(root.right);

            if (lDepth > rDepth)
                return (lDepth + 1);
            else
                return (rDepth + 1);
        }
    }

    // returns the minimum value stored in the tree
    public Integer getMin() {
        if (root == null) throw new TreeEmptyException(TREE_IS_EMPTY);
        Node min = getMin(root);
        return min.item;
    }

    private Node getMin(Node root) {
        if (root.left != null) {
            return getMin(root.left);
        }
        return root;
    }

    // returns the maximum value stored in the tree
    public Integer getMax() {
        if (root == null) throw new TreeEmptyException(TREE_IS_EMPTY);
        Node max = getMax(root);
        return max.item;
    }

    private Node getMax(Node root) {
        if (root.right != null) {
            return getMin(root.right);
        }
        return root;
    }

    // check if the constructed tree is a binary tree
    public boolean isBinarySearchTree() {
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBinarySearchTree(Node root, Integer minValue, Integer maxValue) {

        if (root == null) return true;

        if (root.item > minValue && root.item < maxValue
                && isBinarySearchTree(root.left, minValue, root.item)
                && isBinarySearchTree(root.right, root.item, maxValue)) {
            return true;
        }
        return false;

    }

    // delete specific value
    public void deleteValue(Integer item) {
        root = deleteValue(root, item);
        count--;
    }

    private Node deleteValue(Node root, int item) {

        // base case if node to delete is not found
        if (root == null) return null;

        // keep searching. Go to the left
        if (item < root.item) {
            root.left = deleteValue(root.left, item);
            // keep searching go to the right
        } else if (item > root.item) {
            root.right = deleteValue(root.right, item);
        } else {
            // node with only one child or no children
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // node with two children (get smallest value in the right subtree)
            root.item = getMin();
            // Delete the inorder successor
            root.right = deleteValue(root.right, root.item);
        }

        return root;
    }

}
