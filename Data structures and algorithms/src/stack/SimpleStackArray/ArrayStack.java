package stack.SimpleStackArray;

import java.util.EmptyStackException;

public class ArrayStack {

    private Employee[] stack;
    private int top; //next available position in the stack

    public ArrayStack(int capacity) {
        stack = new Employee[capacity];
//        this.top = 0; implicit
    }

    public void push(Employee newEmployee) {
        if (isStackFull()) {
            resizeStack();
        }
        stack[top++] = newEmployee;
    }

    public Employee pop() {
        if (isStackEmpty()) {
            throw new EmptyStackException();
        }

        //salvage remaining space?
        //add code here
//        return stack[top--]; //IMPORTANT: top points to next available position
//        return stack[--top]; //dereference the the value pointing to the top
        Employee popEmployee = stack[--top];
        stack[top] = null;
        return popEmployee;
    }

    public Employee peek() {
        if (isStackEmpty()) {
            throw new EmptyStackException();
        }
        return stack[top - 1];
    }

    public boolean isStackEmpty() {
        return top == 0;
    }

    private void resizeStack() {
        //resize array
        Employee[] newArray = new Employee[2 * stack.length];
        System.arraycopy(stack, 0, newArray, 0, stack.length);
        stack = newArray;
    }

    public boolean isStackFull() {
        return top == stack.length;
    }

    public int size() {
        return top;
    }

    public void printStack() {
//        System.out.println(Arrays.toString(stack)); //needs to be bound with top
        if (isStackEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        for (int i = top - 1; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }

}
