package vectorList;

import ArrayListADT.Employee;
import java.util.List;
import java.util.Vector;

public class VectorMain {
    public static void main(String[] args){
        
        //notice how easy it is to create an List interface and implement its methods using Vector
        //can also double check it using "open declaration"
        //Vector is thread-safe -> synchronized; arrayList doens't have synchronized methods
        List<Employee> employeeList = new Vector<>();
        
        // adding 4 employee objects
        Employee obj1 = new Employee("Jane", "Doe", 1);
        Employee obj2 = new Employee("Jany", "Doy", 2);
        Employee obj3 = new Employee("Rando", "Doer", 3);
        Employee obj4 = new Employee("Django", "John", 4);

        employeeList.add(obj1);
        employeeList.add(obj2);
        employeeList.add(obj3);
        employeeList.add(obj4);
        
    }
}
