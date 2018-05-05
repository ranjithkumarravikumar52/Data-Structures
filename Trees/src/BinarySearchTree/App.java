/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BinarySearchTree;

/**
 *
 * @author Ranjith
 */
public class App {
    public static void main(String[] args) {
        BST tree = new BST();
        tree.insert(25);
        tree.insert(20);
        tree.insert(27);
        tree.insert(15);
        tree.insert(22);
        tree.insert(26);
        tree.insert(30);
        tree.insert(29);
        tree.insert(32);
        
        tree.printTreeLevelOrderTraversal();
    }
}
