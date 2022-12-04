package java_dsa;
public class BST {
    Node root;
    class Node {
        int value;
        Node left;
        Node right;
        public Node(int value) {
            this.value = value;
        }
    }
    public boolean insertBST (int value) {
        Node temp = root;
        Node insert = new Node(value);
        if (root == null) {
            root = insert;
            return true;
        }
        while (true) {
            if (insert.value == temp.value) {
                return false;
            }
            if (insert.value > temp.value) {
                if (temp.right == null) {
                    temp.right = insert;
                    return true;
                }
                temp = temp.right;
            } else {
                if (temp.left == null) {
                    temp.left = insert;
                    return true;
                }
                temp = temp.left;
            }
        }
    }
}