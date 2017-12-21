package top.pengcheng789.algorithms.dataStruct;

import top.pengcheng789.algorithms.dataStruct.stack.LinkedStack;
import top.pengcheng789.algorithms.dataStruct.stack.Stack;

/**
 * CreateDate:2017-08-19
 *
 * @author pen
 */
public class TestStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new LinkedStack<>();

        // Try to pop the empty stack.
        try {
            stack.pop();
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 10; i++) stack.push(i);
        System.out.println("Element: " + stack + ", size: " + stack.getSize());

        for (int i = 0; i < 5; i++) stack.pop();
        System.out.println("Element: " + stack + ", size: " + stack.getSize());

        for (int i = 10; i < 20; i++) stack.push(i);
        System.out.println("Element: " + stack + ", size: " + stack.getSize());

        stack.clean();
        System.out.println("Element: " + stack + ", size: " + stack.getSize());

        for (int i = 20; i < 30; i++) stack.push(i);
        System.out.println("Element: " + stack + ", size: " + stack.getSize());
    }
}
