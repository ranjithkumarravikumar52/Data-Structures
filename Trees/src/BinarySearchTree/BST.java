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

    public TreeNode get(int value) {
        if (root == null) {
            System.out.println("Empty tree");
            return null;
        }
        return root.get(value);

    }

    public int min() {
        if (root != null) {
            return root.getMin();
        } else {
            return Integer.MIN_VALUE;
        }
    }

    public int max(){
        if (root != null) {
            return root.getMax();
        } else {
            return Integer.MAX_VALUE;
        }
    }

    public void delete(int value) {
        //how do we pass the entire tree to some method? By sending the root pointer
        root = delete(root, value);
    }

    //this method returns the replacement node
    private TreeNode delete(TreeNode subTreeRoot, int value) {
        if (subTreeRoot == null) {
            //empty tree //return null; can also be used
            return subTreeRoot;
        }
        /*
            at this point, there are three possibilities
            we have to delete the subTreeRoot OR
            have to go down on either left subTree OR 
            right subTree
         */
 /*
                            subTreeRoot
        leftsubtree                     rightsubtree
         */
        //leftsubtree
        if (value < subTreeRoot.getData()) {
            //visualize the below method as shown in the above block comment
            TreeNode deleteResult = delete(subTreeRoot.getLeftChild(), value);
            //REPLACE the subTreeChild with whatever the result from the method even if there's no change - which is completely FINE
            //We are not physically rewiring all the connections
            subTreeRoot.setLeftChild(deleteResult);
        } //rightSubtree
        else if (value > subTreeRoot.getData()) {
            //visualize the below method as shown in the above block comment
            TreeNode deleteResult = delete(subTreeRoot.getRightChild(), value);
            //REPLACE the subTreeChild with whatever the result from the method even if there's no change - which is completely FINE
            //We are not physically rewiring all the connections
            subTreeRoot.setRightChild(deleteResult);
        } //if we reach to this point of the code that mean value is equal to the root here
        //which means that we have found the value that we want to delete
        //this is where the "delete" operations takes place
        else //DELETE CASE 0: no children - which has no replacement node
        //DELETE CASE 1: 1 child - child node is the replacement node
        {
            if (subTreeRoot.getLeftChild() == null) {
                //satisfies both the case 0 and 1
                //if rightchild is present - send rightchild as a replacement node for the subTreeRoot
                //if not present then send null, eventually replacing the subTreeRoot with null
                return subTreeRoot.getRightChild();
            } else if (subTreeRoot.getRightChild() == null) {
                //satisfies both the case 0 and 1
                //if rightchild is present - send rightchild as a replacement node for the subTreeRoot
                //if not present then send null, eventually replacing the subTreeRoot with null
                return subTreeRoot.getLeftChild();
            } /*
            * Figure out what the replacement node will be
            * MUST have minimial disruption to the tree
            * can take the replacement node from either leftSubTree or rightSubTree
            * * for left subtree, find the max element for replacement node also serves to maintain minimial disruption 
            * * for right subtree, find the min element for replacement node also serves to maintain minimial disruption 
             */ else {
                //if we reach here
                //DELETE CASE 2: two children
                //Replace the value in the subtreeroot node with the smallest value
                //from the right subtree
                subTreeRoot.setData(subTreeRoot.getRightChild().getMin());
                
                //Delete the node by passing the same value from where we got the min
                subTreeRoot.setRightChild(delete(subTreeRoot.getRightChild(), subTreeRoot.getData()));
            }
        }

        //if we reach here that means that we haven't found the value AND this subTreeRoot is not the tree we wanna delete
        return subTreeRoot;

    }
}
