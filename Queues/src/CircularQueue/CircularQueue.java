/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CircularQueue;

import java.util.NoSuchElementException;

/**
 *
 * @author Ranjith
 */
public class CircularQueue {

    //ADT operations
    //add//remove//peek
    private Employee[] queue;
    private int front; //current available position to remove
    private int back; //next available position to add
    private int size;

    //The key to implement circular queue is to utilize only the front, back and size variables
    //One step at a time, try to implement all the ADT operations
    //------------------------
    //The circular queue is nothing but a simple queue array, but when a certain conditions are met, the back of the queue wraps around to the front
    //Two cases a circular queue involves: 
    //1. Simple Queue(unWrapped)
    //2. Circular Queue(wrapped)
    /* STATES
    * unWrapped state is when front <= back 
    * wrapped state is when back <= front
     */
 /* ---------------------------
    **Special case: When there is only one element at the end of the Simple Queue. 
    **[_, _, _, _, 5] ---> size == 1 && front == back == queue.length - 1
    **Should we resize the queue? OR Should we wrap the queue? HINT: WRAP
     */
    public CircularQueue(int capacity) {
        queue = new Employee[capacity];
    }

    public void add(Employee newEmployee) {
        if (checkForWrapCondition()) {
            //wrap the queue here
            back = 0; //GOOD
        }

        //when simple queue gets full
        //which means that size == queue.length && back == queue.length - 1
        if (isFull() && front < back) {
            System.out.println("UNWRAPPED STATE: Resizing the queue");
            Employee[] newQueue = new Employee[queue.length * 2];
            System.arraycopy(queue, 0, newQueue, 0, queue.length);
            queue = newQueue;
            queue[back++] = newEmployee;
            size++;
            return;
        }
        if (size < queue.length) {
            //fill up all the strangling spaces at the front of the queue
            //till there's only one space available between front and back pointers
            //[6, 7, 8, _, 5]
            queue[back++] = newEmployee;
            size++;
            //[6, 7, 8, 9, 5]
        } else {
            // back < front
            //unwrap first and then resize, however, while writing a code I think its easier to resize and then unwrap
            /*[6, 7, 8, 9, 5]
            *
            * RESIZE
            * [6, 7, 8, 9, 5, _, _, _, _, _]
            * 
            *new element to be added say 10
            * 
            * [5, 6, 7, 8, 9, 10, _, _, _, _, _]
             */
            //RESIZE
            System.out.println("WRAPPED STATE: Resizing the queue");
            Employee[] newQueue = new Employee[queue.length * 2];

            //UNWRAP
            System.out.println("WRAPPING STATE: unwrapping the queue");
            System.arraycopy(queue, front, newQueue, 0, 1);
            //[5,_, _, _, _, _, _, _,....]
            System.arraycopy(queue, 0, newQueue, 1, queue.length - 1);
            //[5, 6, 7, 8, 9, _, _, _, _, _, _]
            //reassigning front and back for the newQueue
            queue = newQueue;
            front = 0;
            back = size; //back always point to the next available position to add an element

            queue[back++] = newEmployee;
            //[5, 6, 7, 8, 9, 10, _, _, _, _, _]
            size++;

        }

    }

    public boolean checkForWrapCondition() {
        return size == 1 && front == queue.length - 1;
    }

    public Employee remove() {
        /*
        Check remove methods for both wrapped case and unwrapped case
         */
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Employee removedEmployee = queue[front];
        if (isWrapped()) {
            System.out.println("Removing element from a wrapped state");
            queue[front] = null;
            front = 0;
            size--;
        } //Not wrapped
        else {
            queue[front++] = null;
            size--;
        }
        //After removing the last element in a UNWRAPPED/WRAPPED state queue
        if (isEmpty()) {
            //Reassign the front and back to their defaults
            front = 0;
            back = 0;
        }

//        Employee removedEmployee = queue[front];
        return removedEmployee;
    }

    public boolean isEmpty() {
//        return (front == 0 && back == 0) || (front == queue.length);
        return size == 0;
    }

    public boolean isFull() {
        return size == queue.length;
    }

    public int size() {
        return size;
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Empty queue");
            return;
        }
        //when queue is wrapped
        if (isWrapped()) {
            //print wrap code goes here
            for (int i = front; i < queue.length; i++) {
                System.out.println(queue[i]);
            }
            for (int i = 0; i < back; i++) {
                System.out.println(queue[i]);
            }
        } //When the queue is not wrapped
        else {
            for (int i = front; i < back; i++) {
                System.out.println(queue[i]);
            }
        }

    }

    public int getFront() {
        return front;
    }

    public int getBack() {
        return back;
    }

    public Employee peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return queue[front];
    }

    private boolean isWrapped() {
        return back <= front;
    }

}
