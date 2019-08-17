"""
Title: Sort stacks

Given a stack, sort the elements in the stack using one additional stack.

Execution: python SortStacks.py

For more details, check out http://www.byte-by-byte.com/sortstacks/
"""
import unittest


def sort_stacks(stack):
    if stack is None or stack == []:
        return stack
    new_stack = []
    new_stack.append(stack.pop())
    while stack != []:
        temp = stack.pop()
        while new_stack != [] and temp > new_stack[-1]:
            stack.append(new_stack.pop())
        new_stack.append(temp)
    return new_stack


class TestSortStacks(unittest.TestCase):
    def test_1(self):
        s = [1, 2, 3, 4, 5]
        s = sort_stacks(s)
        self.assertEqual(s, [5, 4, 3, 2, 1])

    def test_2(self):
        s = [5, 4, 3, 2, 1]
        s = sort_stacks(s)
        self.assertEqual(s, [5, 4, 3, 2, 1])

    def test_3(self):
        s = [-5, 4, 2, 1, 9]
        s = sort_stacks(s)
        self.assertEqual(s, [9, 4, 2, 1, -5])


if __name__ == '__main__':
    unittest.main()

