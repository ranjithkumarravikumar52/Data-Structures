/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QueueArray;

import java.util.NoSuchElementException;

/**
 *
 * @author Ranjith
 */
public class QueueArray {

    //ADT operations
    //add//remove//peek
    private Employee[] queue;
    private int front; //current available position to remove
    private int back; //next available position to add
    private int size;

    public QueueArray(int capacity) {
        queue = new Employee[capacity];
    }

    public void add(Employee newEmployee) {
        if (isFull()) {
            Employee[] newQueue = new Employee[queue.length * 2];
            System.arraycopy(queue, 0, newQueue, 0, queue.length);
            queue = newQueue;
        }
        queue[back++] = newEmployee;
        size++;
    }

    public Employee remove() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        size--;
        Employee removedEmployee = queue[front++];
//        queue[front] = null; 
//        front++; 
        if(isEmpty()){
            front = 0; 
            back = 0;
        }
        return removedEmployee;
    }

    public boolean isEmpty() {
//        return (front == 0 && back == 0) || (front == queue.length);
        return back - front == 0;
    }

    public boolean isFull() {
        return back == queue.length;
    }

    public int size() {
        return size;
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Empty queue");
            return;
        }
        for (int i = front; i < back; i++) {
            System.out.println(queue[i]);
        }
    }

    public int getFront() {
        return front;
    }

    public int getBack() {
        return back;
    }
    
    public Employee peek(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        return queue[front];
    }
    
    

}
