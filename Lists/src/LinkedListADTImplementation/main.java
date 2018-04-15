package LinkedListADTImplementation;

public class main {

    public static void main(String[] args) {
        Employee janeDoe = new Employee("Jane", "Doe", 1);
        Employee janyDoy = new Employee("Jany", "Doy", 2);
        Employee randoDoer = new Employee("Rando", "Doer", 3);
        Employee djangoJohn = new Employee("Django", "John", 4);
        
        EmployeeLinkedList list = new EmployeeLinkedList();
        list.addToTheFront(janeDoe);
        list.addToTheFront(janyDoy);
        list.addToTheFront(randoDoer);
        list.addToTheFront(djangoJohn);
        
        list.printList();
        System.out.println(list.getSize());
    }
}
