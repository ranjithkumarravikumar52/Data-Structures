/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArrayHashTable;

/**
 *
 * @author Ranjith
 */
public class ArrayHashTable {

    private Employee[] hashTable;

    public ArrayHashTable() {
        hashTable = new Employee[10];
    }

    //while inserting the elements we put using the key
    //key here is done using the last name of the employee
    public void put(String key, Employee employeeValue) {
        int hashedKey = hashedString(key);
        if (hashTable[hashedKey] != null) {
            //collision
            System.out.println("Collision occured at " + hashedKey);
        } else {
            hashTable[hashedKey] = employeeValue;
        }
    }

    //complexity - constant time :)
    public Employee get(String key) {
        //get hashed value of the key
        int hashedKey = hashedString(key);
        Employee value = hashTable[hashedKey];
        return value;
    }

    //to get the indices in the range of 0-9
    //since hashtable's length is 10
    private int hashedString(String key) {
        return key.length() % hashTable.length;
    }

    public void printHashTable() {
        for (int i = 0; i < hashTable.length; i++) {
            System.out.println(hashTable[i]);
        }
    }

}
