package LinkedListDoubleADTImplementation;

import LinkedListADTImplementation.*;

public class main {

    public static void main(String[] args) {
        Employee janeDoe = new Employee("Jane", "Doe", 1);
        Employee janyDoy = new Employee("Jany", "Doy", 2);
        Employee randoDoer = new Employee("Rando", "Doer", 3);
        Employee djangoJohn = new Employee("Django", "John", 4);

        EmployeeDoublyLinkedList list = new EmployeeDoublyLinkedList();

//        System.out.println("Is list empty: "+list.isEmpty());
//        list.addToTheFront(janeDoe);
//        list.addToTheFront(janyDoy);
//        list.addToTheFront(randoDoer);
//        list.addToTheFront(djangoJohn);

        list.addToTheEnd(janeDoe);
        list.addToTheEnd(janyDoy);
        list.addToTheEnd(randoDoer);
        list.addToTheEnd(djangoJohn);
        
        list.printList();
        System.out.println("Elements in the list "+list.getSize());
        
        


        
    }
}
