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
        try {
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

//            tree.printTreeLevelOrderTraversal();
//            tree.levelOrderTraversal();
//            tree.inOrderTraversal();
//            tree.preOrderTraversal();
//            tree.postOrderTraversal();
//            System.out.println(tree.get(25));
//            System.out.println(tree.get(15));
//            System.out.println(tree.get(22));
//            System.out.println(tree.get(29));
//            //no element
//            System.out.println(tree.get(3211));
//            System.out.println("min value in tree " + tree.min());
//            System.out.println("min value in tree " + tree.max());
            tree.inOrderTraversal();
            tree.delete(15);
            tree.inOrderTraversal();
            tree.delete(20);
            tree.inOrderTraversal();
            tree.delete(25);
            tree.inOrderTraversal();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
