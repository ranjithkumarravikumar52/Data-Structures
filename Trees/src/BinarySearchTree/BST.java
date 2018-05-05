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
            root.insert(newValue);
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
}
