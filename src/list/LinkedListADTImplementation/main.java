package list.LinkedListADTImplementation;

public class main {

    public static void main(String[] args) {
        Employee janeDoe = new Employee("Jane", "Doe", 1);
        Employee janyDoy = new Employee("Jany", "Doy", 2);
        Employee randoDoer = new Employee("Rando", "Doer", 3);
        Employee djangoJohn = new Employee("Django", "John", 4);

        EmployeeLinkedList list = new EmployeeLinkedList();

//        System.out.println("Is list empty: "+list.isEmpty());
        list.addToTheFront(janeDoe);
        list.addToTheFront(janyDoy);
        list.addToTheFront(randoDoer);
        list.addToTheFront(djangoJohn);

//        System.out.println("Is list empty: "+list.isEmpty());
        list.printList();
        System.out.println(list.getSize());

        list.removeFromTheFront();
        list.removeFromTheFront();
        
        list.printList();
        System.out.println(list.getSize());
        
    }
}
