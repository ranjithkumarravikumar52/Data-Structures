/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedListHashTable;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 *
 * Implementing HashTable through an array of LinkedList in a process called
 * "chaining"
 */
public class LinkedListHashTable {

    private LinkedList<Employee>[] hashTable;
    //int[] array = new int[10]

    public LinkedListHashTable() {
        hashTable = new LinkedList[10];
        //init each array position with a linkedList
        for (int i = 0; i < hashTable.length; i++) {
            hashTable[i] = new LinkedList<>();
        }
    }

    private int getHashedKey(String rawKey) {
        return rawKey.length() % hashTable.length;
    }

    public void put(String rawKey, Employee newEmployee) {
        int hashedKey = getHashedKey(rawKey);
        hashTable[hashedKey].add(newEmployee);
    }

    public Employee get(String inputKey) {
        int hashedKey = getHashedKey(inputKey);
        //find the correct index of linked list array
        LinkedList<Employee> lt = hashTable[hashedKey];
        for (int index = 0; index < lt.size(); index++) {
            //can replace last name with raw key later
            if (lt.get(index).getLastName().equals(inputKey)) {
                return lt.get(index);
            }
        }
        //if the code reaches here, then there's no match found
        return null;

    }

    public void printHashTable() {
        for (int index = 0; index < hashTable.length; index++) {
            ListIterator listIteratorObject = hashTable[index].listIterator();
            while (listIteratorObject.hasNext()) {
                System.out.println(listIteratorObject.next());
            }
        }
    }

    public void remove(String rawKey) {
        int hashedKey = getHashedKey(rawKey);
        //find the correct index of linked list array
        LinkedList<Employee> lt = hashTable[hashedKey];
        for (int index = 0; index < lt.size(); index++) {
            //can replace last name with raw key later
            if (lt.get(index).getLastName().equals(rawKey)) {
                System.out.println("Removed " + lt.remove(index));
                return;
            }
        }
        //if the code reaches here, then there's no match found
        System.out.println("Employee not found");

    }
}
