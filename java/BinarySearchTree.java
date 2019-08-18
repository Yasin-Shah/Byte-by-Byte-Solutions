/*
 *   Title: Binary search tree
 *
 *   Given a binary tree, write a function to test if the tree is a binary
 *   search tree.
 *
 *   Execution: javac BinarySearchTree.java && java BinarySearchTree
 * 
 *   For more details, check out http://www.byte-by-byte.com/binarysearchtree/
 */

import java.util.Queue;
import java.util.LinkedList;

public class BinarySearchTree {

    private static class Node {
        private int value;
        private Node left;
        private Node right;
        
        private Node(int value) {
            this.value = value;
        }
    }
    
    public static boolean isBST(Node n) {
        return isBST(n, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isBST(Node n, int min, int max) {
        if (n == null) return true;
        if (n.value < min || n.value > max) return false;
        return isBST(n.left, min, n.value) && isBST(n.right, n.value + 1, max);
    }

    public static boolean valid_test() {
        Node n = new Node(5);
        n.left = new Node(2);
        n.right = new Node(7);
        n.left.left = new Node(1);
        n.left.right = new Node(3);
        n.right.left = new Node(6);
        n.right.right = new Node(8);

        return isBST(n);
    }

    public static boolean invalid_test() {
        Node n = new Node(5);
        n.left = new Node(2);
        n.right = new Node(7);
        n.left.left = new Node(1);
        n.left.right = new Node(3);
        n.right.left = new Node(6);
        n.right.right = new Node(4);

        return isBST(n);
    }

    // Sample test cases
    public static void main(String[] args) {

        // Test on valid BST.
        if (valid_test() == true) {
            System.out.println("Valid test passed.");
        } else {
            System.out.println("Valid test failed.");
        }

        // Test on invalid BST.
        if (invalid_test() == false) {
            System.out.println("Invalid test passed.");
        } else {
            System.out.println("Invalid test failed.");
        }
    }
}
