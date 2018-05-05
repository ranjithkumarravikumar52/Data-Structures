package BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {

    /*
        Every node contains data and a left child and right child
     */
    private int data;
    private TreeNode leftChild;
    private TreeNode rightChild;

    public TreeNode(int data) {
        //when this object(tree node) is created, consider it as ghost leaf node which is not assigned to any tree yet
        this.data = data;
    }

//    public void insert(TreeNode newNode) { -- NOT A GOOD IDEA
//    always better to take parameters of the primitive type rather node object, 
//    cos we can't expect user to insert a object of node, but he would rather insert a integer value
    public void insert(int newValue) {

        //no duplicates
        if (newValue == this.getData()) {
            System.out.println("No duplicates allowed");
            return;
        }

        //if newNode < parent add to left child (no-duplicates)
        if (newValue < this.getData()) {
            //no nodes on the left sub tree
            if (this.leftChild == null) {
                TreeNode newNode = new TreeNode(newValue);
                this.setLeftChild(newNode);
                return;
            } else {
                this.leftChild.insert(newValue);
            }
        } //else add to right child
        else if (this.rightChild == null) {
            TreeNode newNode = new TreeNode(newValue);
            this.setRightChild(newNode);
            return;
        } else {
            this.rightChild.insert(newValue);
        }
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "" + data;
    }

    public void levelOrderTraversal() {
        //Implementing BFS
        //add root to the queue
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(this);
        //remove the queue and print
        while (!queue.isEmpty()) {
            TreeNode removedNode = queue.remove();
            System.out.print(removedNode + " ");
            //if the removed has (left and then right) children then add to the queue
            if (removedNode.getLeftChild() != null) {
                queue.add(removedNode.getLeftChild());
            }
            if (removedNode.getRightChild() != null) {
                queue.add(removedNode.getRightChild());
            }
            //repeat till the queue is empty
        }

    }

    public void inOrderTraversal() {
        if (leftChild != null) {
            leftChild.inOrderTraversal();
        }
        System.out.print(data + " ");
        if (rightChild != null) {
            rightChild.inOrderTraversal();
        }
    }

    public void preOrderTraversal() {
        System.out.print(data + " ");
        if (leftChild != null) {
            leftChild.preOrderTraversal();
        }
        if (rightChild != null) {
            rightChild.preOrderTraversal();
        }
    }

    public void postOrderTraversal() {
        if (leftChild != null) {
            leftChild.postOrderTraversal();
        }
        if (rightChild != null) {
            rightChild.postOrderTraversal();
        }
        System.out.print(data + " ");
    }

    public TreeNode get(int value) {
        if (data == value) {
            return this;
        } else if (value < data) {
            //rabbit hole into left subtree
            if (leftChild != null) {
                return leftChild.get(value);
            }
        } else if (value > data) {
            if (rightChild != null) {
                return rightChild.get(value);
            }
        }
        return null;
    }

}
