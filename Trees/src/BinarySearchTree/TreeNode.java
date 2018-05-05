package BinarySearchTree;

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

}
