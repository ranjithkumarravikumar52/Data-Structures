package LinkedListDoubleADTImplementation;

import LinkedListADTImplementation.*;

public class EmployeeDoublyLinkedList {

    private EmployeeNode head;
    private EmployeeNode tail;
    private int size;

    //no need of a constructor for initializing values to null (if that's what needed)
    public void addToTheFront(Employee newEmployee) {
        EmployeeNode newNode = new EmployeeNode(newEmployee);
        newNode.setNext(head); //even when the list is empty, this will set the newNode's next to null which is perfect!

        if (isEmpty()) {
            tail = newNode;

        } else {
//            avoid using multiple traversals
//            head.getNext().setPrevious(newNode); //BAD
            head.setPrevious(newNode);
        }
        head = newNode;
        size++;

    }

    public void addToTheEnd(Employee newEmployee) {
        if (isEmpty()) {
            EmployeeNode newNode = new EmployeeNode(newEmployee);
            head = newNode;
            tail = newNode;
            size++;
        } else {
            EmployeeNode newNode = new EmployeeNode(newEmployee);
            tail.setNext(newNode);
            newNode.setPrevious(tail);
            //no need to newNode.setnext(null)
            tail = newNode;
            size++;
        }
    }

    public EmployeeNode removeFromTheFront() {
        if (this.isEmpty()) {
            return null;
        }
        EmployeeNode removedNode = head;
        head = head.getNext();
        size--;
        removedNode = null;
        return removedNode;
    }

    public void printList() {
        EmployeeNode currentNode = head;
        System.out.print("null <- HEAD => ");
        while (currentNode != null) {
            if (currentNode.getNext() == null) {
                System.out.print(currentNode);
                System.out.print("<- null\n");
                break;
            } else {
                System.out.print(currentNode + " <=> ");
                currentNode = currentNode.getNext();
            }

        }
//        System.out.print("<- TAIL ");

    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

}
