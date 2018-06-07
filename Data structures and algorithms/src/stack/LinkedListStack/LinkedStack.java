/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack.LinkedListStack;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Ranjith
 */
public class LinkedStack {
    
    //can limit the type of operations that can be performed by LinkedList class 
    //by wrapping the DS in here and exposing the needed methods

    private LinkedList<Employee> stack;

    public LinkedStack() {
        stack = new LinkedList<>();
    }

    public void push(Employee e) {
        stack.push(e);
    }

    public Employee peek() {
        return stack.peek();
    }

    public Employee pop() {
        return stack.pop();
    }
    
    public boolean isStackEmpty(){
        return stack.isEmpty();
    }
    
    public void printStack(){
        Iterator<Employee> iter = stack.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
    }

}
