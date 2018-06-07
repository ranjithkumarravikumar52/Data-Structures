package hashtable.ArrayHashTable;

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
        
        //non-linear put
        hashTable.put("Jones", janeJones);
        hashTable.put("Doe", johnDoe);
        hashTable.put("Wilson", mikeWilson);
        
        
        //collision - avoidance (linear put)
        hashTable.put("Smith", marySmith);
        hashTable.put("End", billEnd);
        
        //size
//        System.out.println("Size: "+hashTable.size());
        
        
//        System.out.println("Retrieving JaneJones: " + hashTable.get("Jones"));
//        System.out.println("Retrieving JohnDoe: " + hashTable.get("Doe"));
//        System.out.println("Retrieving MikeWilson: " + hashTable.get("Wilson"));
//        //get Elements which was added through linear probing
//        System.out.println("Retrieving MarySmith: " + hashTable.get("Smith"));
//        System.out.println("Retrieving BillEnd: " + hashTable.get("End"));
//        
//        
        hashTable.remove("Doe");
        hashTable.remove("End");
        
        //print hashTable
        hashTable.printHashTable();
    }

}
