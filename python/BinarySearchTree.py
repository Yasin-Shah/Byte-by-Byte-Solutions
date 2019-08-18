"""
Title: Binary search tree

Given a binary tree, write a function to test if the tree is a binary
search tree.

Execution: python BinarySearchTree.py

For more details, check out http://www.byte-by-byte.com/binarysearchtree/
"""
import unittest


class Node:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None


def is_bst(n):
    return is_bst_helper(n, float("-inf"), float("inf"))


def is_bst_helper(n, min_val, max_val):
    if n is None:
        return True
    if n.value < min_val or n.value > max_val:
        return False
    return is_bst_helper(n.left, min_val, n.value) and is_bst_helper(n.right, n.value + 1, max_val)


class TestBinarySearchTree(unittest.TestCase):
    def test_valid_bst(self):
        n = Node(5)
        n.left = Node(2)
        n.right = Node(7)
        n.left.left = Node(1)
        n.left.right = Node(3)
        n.right.left = Node(6)
        n.right.right = Node(8)
        self.assertEqual(is_bst(n), True)

    def test_invalid_bst(self):
        n = Node(5)
        n.left = Node(2)
        n.right = Node(7)
        n.left.left = Node(1)
        n.left.right = Node(3)
        n.right.left = Node(6)
        n.right.right = Node(4)
        self.assertEqual(is_bst(n), False)


if __name__ == '__main__':
    unittest.main()
