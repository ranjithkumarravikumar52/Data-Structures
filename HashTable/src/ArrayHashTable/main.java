package ArrayHashTable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ranjith
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
        Employee billEnd = new Employee("Bill", "End", 78);

        ArrayHashTable hashTable = new ArrayHashTable();
        hashTable.put("Jones", janeJones);
        hashTable.put("Doe", johnDoe);
        
        
        //collision - avoidance
        hashTable.put("Smith", marySmith);
        hashTable.put("End", billEnd);
        
        System.out.println("Retrieving BillEnd: " + hashTable.get("End"));
        System.out.println("Retrieving Smith: " + hashTable.get("Smith"));
        


        
        

        hashTable.printHashTable();
    }

}
