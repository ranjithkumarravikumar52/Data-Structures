package LinkedListDoubleADTImplementation;

import LinkedListADTImplementation.*;

public class EmployeeDoublyLinkedList {

    private EmployeeNode head;
    private EmployeeNode tail;
    private int size;

    //no need of a constructor for initializing values to null (if that's what needed)
    public void addToTheFront(Employee newEmployee) {
        if (isEmpty()) {
            EmployeeNode newNode = new EmployeeNode(newEmployee);
            head = newNode;
            tail = newNode;
            size++;
        } else {
            EmployeeNode newNode = new EmployeeNode(newEmployee);
            newNode.setNext(head);
            head = newNode;
            head.getNext().setPrevious(newNode);
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
        System.out.print("HEAD -> ");
        while (currentNode != null) {
            System.out.print(currentNode + " -> ");
            currentNode = currentNode.getNext();
        }
        System.out.print("<- TAIL ");
        System.out.print("<- null\n");

    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

}
