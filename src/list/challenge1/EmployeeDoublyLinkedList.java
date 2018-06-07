package list.challenge1;

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
        if (isEmpty()) {
            return false;
        }
        
        //the node before the exisiting employee before adding is called PreviousEmployee
        //getting the head/pointer to the exisitingEmployee
        EmployeeNode exisitEmpNode = getIndexOf(existingEmployee);
        if (exisitEmpNode == null) {//no match 
            return false;
        }
        
        //checking if the existing node is head node
        if (exisitEmpNode == head) {
            addToFront(newEmployee);
            return true;
        }
        
        //4 steps to be done
        //creating a new employeeNode for the newEmployee
        EmployeeNode newEmpNode = new EmployeeNode(newEmployee);
        //for readability
        EmployeeNode prevEmpNode = exisitEmpNode.getPrevious();
        //1. newEmp prev -> prevEmp
        newEmpNode.setPrevious(prevEmpNode);
        //2. newEmp next -> exisitingEmp
        newEmpNode.setNext(exisitEmpNode);
        //3. prevEmp.next -> newEmp
        prevEmpNode.setNext(newEmpNode);
        //4. existingEmp prev -> newEmp
        exisitEmpNode.setPrevious(newEmpNode);
        
        //5. increase size
        size++;

        return true;

    }

    public EmployeeNode getIndexOf(Employee existingEmployee) {
        if (isEmpty()) {
            return null;
        }
        EmployeeNode currentNode = head;
        while (currentNode != null && !currentNode.getEmployee().equals(existingEmployee)) {
            currentNode = currentNode.getNext();
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
