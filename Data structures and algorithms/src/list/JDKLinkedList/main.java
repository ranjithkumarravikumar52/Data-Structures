package list.JDKLinkedList;

import java.util.Iterator;
import java.util.LinkedList;

public class main {

    public static void main(String[] args) {
        Employee janeDoe = new Employee("Jane", "Doe", 1);
        Employee janyDoy = new Employee("Jany", "Doy", 2);
        Employee randoDoer = new Employee("Rando", "Doer", 3);
        Employee djangoJohn = new Employee("Django", "John", 4);
        
        //Implementing "LinkedList" implementations using "LinkedList" datastructure
        LinkedList<Employee> list = new LinkedList<>();

        list.addFirst(janeDoe);
        list.addFirst(janyDoy);
        list.addFirst(randoDoer);
        list.addFirst(djangoJohn);

        //how to print using iterator
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        //how to print using for-each
//        System.out.println();
//        for(Employee employeeIndex: list){
//            System.out.println(employeeIndex);
//        }
        //add elements at the end 
//        list.add(new Employee("Bill", "End", 0));
        list.addLast(new Employee("Bill", "End", 0));
        System.out.println();
        iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
