package challenge2;

public class IntegerLinkedList {

    private IntegerNode head;
    private int size;

    public void addToFront(Integer value) {
        IntegerNode node = new IntegerNode(value);
        node.setNext(head);
        head = node;
        size++;
    }

    public IntegerNode removeFromFront() {
        if (isEmpty()) {
            return null;
        }

        IntegerNode removedNode = head;
        head = head.getNext();
        size--;
        removedNode.setNext(null);
        return removedNode;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void printList() {
        IntegerNode current = head;
        System.out.print("HEAD -> ");
        while (current != null) {
            System.out.print(current);
            System.out.print(" -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

    public void insertSorted(Integer value) {
        if (isEmpty()) {
            addToFront(value);
            return;
        }

        //since this is a singleLinkedList, 
        //it is easier to find the relative position of the node 
        //to be inserted after the head node
        //not before the head node. This will straight off cut the complexity to O(n) from O(n^2)
        IntegerNode currentNode = head;
        if (value < currentNode.getValue() && currentNode == head) {
            addToFront(value);
            return;
        }
        IntegerNode newNode = new IntegerNode(value);
        while (currentNode != null) {
            if (value < currentNode.getValue() && value > currentNode.getNext().getValue()) {
                newNode.setNext(currentNode.getNext());
                currentNode.setNext(newNode);
                size++;
                return;
            }
            if (currentNode.getNext() == null) {
                //add to the end
                currentNode.setNext(newNode);
                newNode.setNext(null);
                size++;
                return;
            }
            currentNode = currentNode.getNext();
        }

    }

}
