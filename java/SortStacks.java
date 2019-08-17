/*
 *   Title: Sort stacks.
 *
 *   Given a stack, sort the elements in the stack using one additional stack.
 * 
 *   Execution: javac SortStacks.java && java SortStacks
 * 
 *   For more details, check out http://www.byte-by-byte.com/sortstacks
 */

import java.util.Stack;

public class SortStacks {
    public static Stack<Integer> sort(Stack<Integer> stack) {
        if (stack == null || stack.isEmpty()) {
            return stack;
        }
        Stack<Integer> newStack = new Stack<Integer>();
        newStack.push(stack.pop());
        while (!stack.isEmpty()) {
            int temp = stack.pop();
            while (!newStack.isEmpty() && temp > newStack.peek()) {
                stack.push(newStack.pop());
            }
            newStack.push(temp);
        }
        return newStack;
    }

    public static void test_1() {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(5);
        stack.push(3);
        stack.push(100);
        stack.push(-10);
        
        SortStacks ss = new SortStacks();
        Stack<Integer> sorted_stack = ss.sort(stack);

        for(Integer i : sorted_stack) {
            System.out.println(i);
        }
    }
    
    public static void test_2() {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-10);
        stack.push(-5);
        stack.push(-20);
        stack.push(-50);
        
        SortStacks ss = new SortStacks();
        Stack<Integer> sorted_stack = ss.sort(stack);

        for(Integer i : sorted_stack) {
            System.out.println(i);
        }
    }

    public static void test_3() {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(0);
        
        SortStacks ss = new SortStacks();
        Stack<Integer> sorted_stack = ss.sort(stack);

        for(Integer i : sorted_stack) {
            System.out.println(i);
        }
    }
    // Sample test cases
    public static void main(String[] args) {
        System.out.println("Test 1");
        test_1();

        System.out.println("Test 2");
        test_2();

        System.out.println("Test 3brew install vifm");
        test_3();
        System.out.println("Passed all test cases");
    }
}
