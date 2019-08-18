"""
Title: Balanced tree

Given a binary tree, write a function to determine whether the tree is
balanced.

Execution: python BalancedTree.py

For more details, check out http://www.byte-by-byte.com/balancedtree/
"""
import unittest


class Node:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None


def is_balanced(n):
    if balanced_height(n) > 0:
        return True
    return False


def balanced_height(n):
    if n is None:
        return 0
    h1 = balanced_height(n.right)
    h2 = balanced_height(n.left)

    if h1 == -1 or h2 == -1:
        return -1
    if abs(h1 - h2) > 1:
        return -1
    if h1 > h2:
        return h1 + 1
    return h2 + 1


class TestBalancedTree(unittest.TestCase):
    def test_1(self):
        n = Node(1)
        n.left = Node(2)
        n.right = Node(3)
        n.left.left = Node(4)
        n.left.right = Node(5)
        n.right.left = Node(6)
        self.assertEqual(is_balanced(n), True)

    def test_2(self):
        n = Node(1)
        n.left = Node(2)
        n.right = Node(3)
        n.left.left = Node(4)
        n.left.right = Node(5)
        n.left.left.left = Node(8)
        n.right.left = Node(6)
        n.right.right = Node(7)
        n.right.left.left = Node(9)
        n.right.left.right = Node(10)
        n.right.left.left.right = Node(13)
        n.right.right.left = Node(11)
        n.right.right.right = Node(12)
        self.assertEqual(is_balanced(n), True)


if __name__ == '__main__':
    unittest.main()
