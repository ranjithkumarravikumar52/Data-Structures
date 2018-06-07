package list.challenge2;

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
        if (isEmpty() || value <= head.getValue()) {
            addToFront(value);
            return;
        }

        //find the insertion point using only head pointer
//        IntegerNode currentNode = head;
        IntegerNode currentNode = head.getNext();
        IntegerNode previousNode = head;

//        while (currentNode != null) {
//            if (value < currentNode.getValue() && value > currentNode.getNext().getValue()) {
//                newNode.setNext(currentNode.getNext());
//                currentNode.setNext(newNode);
//                size++;
//                return;
//            }
//            if (currentNode.getNext() == null) {
//                //add to the end
//                currentNode.setNext(newNode);
//                newNode.setNext(null);
//                size++;
//                return;
//            }
//            currentNode = currentNode.getNext();
//        }
        while(currentNode != null && currentNode.getValue() < value){
            previousNode = currentNode;
            currentNode = currentNode.getNext();
        }
        IntegerNode newNode = new IntegerNode(value);
        newNode.setNext(currentNode);
        previousNode.setNext(newNode);
        size++;

    }

}
