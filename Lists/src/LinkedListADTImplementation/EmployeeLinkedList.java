package LinkedListADTImplementation;

public class EmployeeLinkedList {

    private EmployeeNode head;
    private int size; 
    
    

    public void addToTheFront(Employee employee) {
        EmployeeNode employeeNode = new EmployeeNode(employee);
        //link this new node to next node (which is currently head pointing to)
        employeeNode.setNext(head);
        //link the head to the current node
        head = employeeNode;
        size++;
    }
    
    public void printList(){
        EmployeeNode currentNode = head;
        System.out.print("HEAD -> ");
        while(currentNode != null){
            System.out.print(currentNode+" -> ");
            currentNode = currentNode.getNext();
        }
        System.out.print("null\n");
        
    }

    public int getSize() {
        return size;
    }
    
    
}
