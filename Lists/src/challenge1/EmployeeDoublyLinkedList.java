package challenge1;

public class EmployeeDoublyLinkedList {

    private EmployeeNode head;
    private EmployeeNode tail;
    private int size;

    public void addToFront(Employee employee) {
        EmployeeNode node = new EmployeeNode(employee);

        if (head == null) {
            tail = node;
        } else {
            head.setPrevious(node);
            node.setNext(head);
        }

        head = node;
        size++;
    }

    public void addToEnd(Employee employee) {
        EmployeeNode node = new EmployeeNode(employee);
        if (tail == null) {
            head = node;
        } else {
            tail.setNext(node);
            node.setPrevious(tail);
        }

        tail = node;
        size++;
    }

    public boolean addBefore(Employee newEmployee, Employee existingEmployee) {

        // return true if you were able to successfully add the employee
        // into the list before the existing employee. 
        //Return false if the existing employee doesn't exist in the list
        // add your code here
        //the node before the exisiting employee before adding is called PreviousEmployee
        //getting the head/pointer to the exisitingEmployee
        EmployeeNode currentNode = getIndexOf(existingEmployee);
        if (currentNode == null) {
            return false;
        }

        //4 steps to be done
        //changing the name of the currentEmployee to exisitingEmployee
        EmployeeNode exisitEmpNode = currentNode;
        EmployeeNode prevEmpNode = currentNode.getPrevious();
        if(prevEmpNode == null){
            addToFront(newEmployee);
            return true;
        }
        //creating a new employeeNode for the newEmployee
        EmployeeNode newEmpNode = new EmployeeNode(newEmployee);
        //4. prevEmp.next -> newEmp
        prevEmpNode.setNext(newEmpNode);
        //1. newEmp next -> exisitingEmp
        newEmpNode.setNext(exisitEmpNode);
        //2. existingEmp prev -> newEmp
        exisitEmpNode.setPrevious(newEmpNode);
        //3. newEmp prev -> prevEmp
        newEmpNode.setPrevious(prevEmpNode);
        //5. increase size
        size++;

        return true;

    }

    public EmployeeNode getIndexOf(Employee existingEmployee) {
        //empty list do nothing
        if (isEmpty()) {
            return null;
        }
        //single item is taken care of in the below 2 lines of code
        EmployeeNode currentNode = head;
        Employee currentEmployee = currentNode.getEmployee();
        //more than one item
        while (currentNode != null) {
            System.out.println("comparing " + existingEmployee + " and " + currentEmployee);
            if (existingEmployee.equals(currentEmployee)) {
                System.out.println("Match found: break");
                return currentNode;
            } else {
                currentNode = currentNode.getNext();
                currentEmployee = currentNode.getEmployee();
            }
        }
        return currentNode;
    }

    public EmployeeNode removeFromFront() {
        if (isEmpty()) {
            return null;
        }

        EmployeeNode removedNode = head;

        if (head.getNext() == null) {
            tail = null;
        } else {
            head.getNext().setPrevious(null);
        }

        head = head.getNext();
        size--;
        removedNode.setNext(null);
        return removedNode;
    }

    public EmployeeNode removeFromEnd() {
        if (isEmpty()) {
            return null;
        }

        EmployeeNode removedNode = tail;

        if (tail.getPrevious() == null) {
            head = null;
        } else {
            tail.getPrevious().setNext(null);
        }

        tail = tail.getPrevious();
        size--;
        removedNode.setPrevious(null);
        return removedNode;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void printList() {
        EmployeeNode current = head;
        System.out.print("HEAD -> ");
        while (current != null) {
            System.out.print(current);
            System.out.print(" <=> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

}
