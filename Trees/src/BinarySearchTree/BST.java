package BinarySearchTree;

public class BST {

    private TreeNode root;

//    public BST(TreeNode root) {
//        this.root = root;
//    }

    public void insert(int newValue) {
        if (root == null) {
            root = new TreeNode(newValue);
            return;
        } else{
            root.insert(newValue);
        }
    }
}
