package BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class BST {

    private TreeNode root;

//    public BST(TreeNode root) {
//        this.root = root;
//    }
    public void insert(int newValue) {
        if (root == null) {
            root = new TreeNode(newValue);
            return;
        } else {
//            System.out.println();
            root.insert(newValue);
        }
    }

    public void levelOrderTraversal() {
        if (root == null) {
            System.out.println("Empty tree");
            return;
        } else {
            System.out.println("\nLevel order");
            root.levelOrderTraversal();
        }
    }

    public void inOrderTraversal() {
        if (root == null) {
            System.out.println("Empty tree");
            return;
        } else {
            System.out.println("\nIn order");
            root.inOrderTraversal();
        }
    }

    public void preOrderTraversal() {
        if (root == null) {
            System.out.println("Empty tree");
            return;
        } else {
            System.out.println("\npre order");
            root.preOrderTraversal();
        }
    }

    public void postOrderTraversal() {
        if (root == null) {
            System.out.println("Empty tree");
            return;
        } else {
            System.out.println("\npost order");
            root.postOrderTraversal();
        }
    }

    public void printTreeLevelOrderTraversal() {
        //Implementing BFS
        //add root to the queue
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        //remove the queue and print
        while (!queue.isEmpty()) {
            TreeNode removedNode = queue.remove();
            System.out.println(removedNode);
            //if the removed has (left and then right) children then add to the queue
            if (removedNode.getLeftChild() != null) {
                queue.add(removedNode.getLeftChild());
            }
            if (removedNode.getRightChild() != null) {
                queue.add(removedNode.getRightChild());
            }
            //repeat till the queue is empty
        }

        /*
        level 0 : node1
        Level 1: node 2, node 3
         */
    }
    
    public TreeNode get(int value){
        if(root == null){
            System.out.println("Empty tree");
            return null; 
        }
            return root.get(value);
        
    }
    
    public int getMin() throws Exception{
        if ( root != null){
            return root.getMin();
        }else{
            throw new Exception();
        } 
    }
    public int getMax() throws Exception{
        if ( root != null){
            return root.getMax();
        }else{
            throw new Exception();
        } 
    }
}
