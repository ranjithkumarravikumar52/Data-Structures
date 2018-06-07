/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashtable.ArrayHashTable;

/**
 *
 * @author Ranjith
 */
public class ArrayHashTable {

    private Employee[] hashTable;
    private int size;

    public ArrayHashTable() {
        hashTable = new Employee[10];
    }

    //while inserting the elements we put using the key
    //key here is done using the last name of the employee
    public void put(String key, Employee employeeValue) {

        //get a hash ket value based on lastName of the employee
        int hashedKey = hashedString(key);

        //if an element exists at the key position
        if (occupied(hashedKey)) {
            int probeValue = linearProbing(hashedKey);
//            System.out.println("probeValue = " + probeValue);
            if (probeValue == -1) {
                //no available index to put
                System.out.println("No available slot to add");
            } else {
                //insert at the nextAvailableIndex
                hashTable[probeValue] = employeeValue;
                employeeValue.setKey(key);
                size++;
            }
        } else {
            hashTable[hashedKey] = employeeValue;
            employeeValue.setKey(key);
            size++;
        }
    }

    /*
        using only one loop to check till the end of hashtable and then wrap
     */
    private int linearProbing(int hashedKey) {
        int countScan = 1;
        for (int loopIndex = hashedKey + 1; loopIndex < hashTable.length; loopIndex++) {
            if (!occupied(loopIndex)) {
                return loopIndex;
            }
            //wrap around
            if (loopIndex == hashTable.length - 1 && countScan > 0) {
                loopIndex = 0;
                countScan--;
                System.out.println("Inside Linear Probing: Wrapping....");
            }
        }
        //no available position
        return -1;
    }

    private boolean occupied(int hashedKey) {
        boolean isOccupied = hashTable[hashedKey] != null;
        return isOccupied;
    }

    private int findKeyLinearProbing(String key) {
        int hashedKey = hashedString(key);
        int stopIndex = hashedKey;
        for (int loopIndex = stopIndex + 1; loopIndex < hashTable.length; loopIndex++) {
            if ( hashTable[loopIndex].getKey().equals(key)) {
                return loopIndex;
            }
        }
        //wrap around
        for (int loopIndex = 0; loopIndex < stopIndex; loopIndex++) {
            if (hashTable[loopIndex].getKey().equals(key)) {
                return loopIndex;
            }
        }
        return -1;
    }

    public Employee get(String key) {

        //if no elements present
        if (isEmpty()) {
            return null;
        }

        //get hashed value of the key
        int hashedKey = hashedString(key);

        if (hashTable[hashedKey].getKey().equals(key)) {
            //matching key found
            Employee returnValue = hashTable[hashedKey];
            return returnValue;
        }

        //how do we get an element which was put through linear probing? - find the key of the employee and check whether it matches with the given key
        int keyIndex = findKeyLinearProbing(key);
        if (keyIndex != -1) {
            Employee returnValue = hashTable[keyIndex];
            return returnValue;
        }

        //if no element exists - 
        //what happens? when
        //1. when two elements of same keys values are added - one puts through nonLP method and other through LP method
        //2. now, remove nonLP element
        //3. try to get LP element - BUG?!
        return null;
    }

    public void remove(String givenKey) {

        if (isEmpty()) {
            return;
        }

        //get hashed value of the key
        int hashedKey = hashedString(givenKey);
        if ( hashTable[hashedKey].getKey().equals(givenKey)) {
            //matching key found
            hashTable[hashedKey] = null;
            size--;
            return;
        }

        //how do we get an element which was put through linear probing? - find the key of the employee and check whether it matches with the given key
        int keyIndex = findKeyLinearProbing(givenKey);
        if (keyIndex != -1) {
            hashTable[keyIndex] = null;
            size--;
        }

        //if no element exists - 
        //what happens? when
        //1. when two elements of same keys values are added - one puts through nonLP method and other through LP method
        //2. now, remove nonLP element
        //3. try to get LP element - BUG?!
        System.out.println("Element not found to delete");

    }

    private int hashedString(String key) {
        //to get the indices in the range of 0-9
        //since hashtable's length is 10
        return key.length() % hashTable.length;
    }

    public void printHashTable() {
        System.out.println("\nPrinting HashTable...");
        for (int i = 0; i < hashTable.length; i++) {
            System.out.println(i + "-->" + hashTable[i]);
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }
    
    public int size(){
        return size;
    }

}
