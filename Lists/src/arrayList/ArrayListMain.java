package arrayList;

import java.util.ArrayList;
import java.util.List;

public class ArrayListMain {

    public static void main(String[] args) {

        // Implementing List interface using ArrayList datastructure
        // Below polymorphism will only allow methods that are visible to the List
        // interface
        // This below line of code could be later used to implement List interface using
        // any data structure
        List<Employee> employeeList = new ArrayList<>();

        // adding 4 employee objects
        Employee janeDoe = new Employee("Jane", "Doe", 1);
        Employee janyDoy = new Employee("Jany", "Doy", 2);
        Employee randoDoer = new Employee("Rando", "Doer", 3);
        Employee djangoJohn = new Employee("Django", "John", 4);

        employeeList.add(janeDoe);
        employeeList.add(janyDoy);
        employeeList.add(randoDoer);
        employeeList.add(djangoJohn);

        // ArrayList is backed by arrays
        // Similar operations of arrays can be used on ArrayLists too
        System.out.println(employeeList.get(1));

        // checking if the list is empty
        System.out.println(employeeList.isEmpty());

        // replacing an item in the list with a new item
        employeeList.set(1, new Employee("New John", "New Doe", 123));

        // using lambda expression
        System.out.println("Printing elements using lambda expression");
        employeeList.forEach(employeeVariable -> System.out.println(employeeVariable));

        // using toArrays to print out all the objects in the employeeList
        Employee[] employeeArray = employeeList.toArray(new Employee[employeeList.size()]);
        System.out.println("\nPrinting elements using toArray() method");
        for (Employee employeeIndex : employeeArray) {
            System.out.println(employeeIndex);
        }

        // contains method
        System.out.println(employeeList.contains(new Employee("Django", "John", 4))); // contains checks for the reference of an object UNLESS equals and hashcode are overridden
        System.out.println(employeeList.indexOf(new Employee("Django", "John", 4)));

        //removing an item
        System.out.println("Removing..." + "\n" + employeeList.remove(1) + "\n");
        employeeList.forEach(employeeVariable -> System.out.println(employeeVariable));

    }
}
