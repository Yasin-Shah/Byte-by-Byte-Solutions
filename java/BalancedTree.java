/*
 *   Title: Balanced tree
 *
 *   Given a binary tree, write a function to determine whether the tree is
 *   balanced.
 *
 *   Execution: javac BalancedTree.java && java BalancedTree
 * 
 *   For more details, check out http://www.byte-by-byte.com/balancedtree/
 */

import java.util.Queue;
import java.util.LinkedList;

public class BalancedTree {

    private static class Node {
        private int value;
        private Node left;
        private Node right;
        
        private Node(int value) {
            this.value = value;
        }
    }
    
    public static boolean isBalanced(Node n) {
        if (balancedHeight(n) > -1) return true;
        return false;
    }

    public static int balancedHeight(Node n) {
        if (n == null) return 0;
        int h1 = balancedHeight(n.right);
        int h2 = balancedHeight(n.left);

        if (h1 == -1 || h2 == -1) return -1;
        if (Math.abs(h1 - h2) > 1) return -1;
        if (h1 > h2) return h1 + 1;
        return h2 + 1;
    }

    public static boolean test_1() {
        Node n = new Node(1);
        n.left = new Node(2);
        n.right = new Node(3);
        n.left.left = new Node(4);
        n.left.right = new Node(5);
        n.right.left = new Node(6);

        return isBalanced(n);
    }

    public static boolean test_2() {
        Node n = new Node(1);
        n.left = new Node(2);
        n.right = new Node(3);
        n.left.left = new Node(4);
        n.left.right = new Node(5);
        n.right.left = new Node(6);
        n.right.right = new Node(7);

        return isBalanced(n);
    }

    // Sample test cases
    public static void main(String[] args) {
        assert test_1() == true;
        assert test_2() == true;

        System.out.println("Passed all test cases");
    }
}
