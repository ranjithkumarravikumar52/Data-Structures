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
    
    //while inserting the elements we add using the key
    public void add(String key, Employee value){
       int hashedKey = hashedString(key);
       if(hashTable[hashedKey] == null){
           hashTable[hashedKey] = value;
       }else{
           //collision
           System.out.println("Collision occured at "+hashedKey);
       }
    }
    
    public Employee get(String key){
        //get hashed value of the key
        int hashedKey = hashedString(key);
        Employee value = hashTable[hashedKey];
        return value;
    }

    private int hashedString(String key) {
        return key.length() % hashTable.length;
    }
    
    public void printHashTable(){
        for(int i = 0 ; i < hashTable.length; i++){
            System.out.println(hashTable[i]);
        }
    }
    
    
}
