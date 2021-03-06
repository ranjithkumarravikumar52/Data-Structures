package queue.CircularQueue;

public class main {

    public static void main(String[] args) {
        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
        Employee billEnd = new Employee("Bill", "End", 78);
        Employee darrenSmith = new Employee("Darren", "Smith", 666);

        CircularQueue queue = new CircularQueue(5);

        /*
        Special case below:
            Where all the empty spaces at the front are available when following the below case
        Solution: To wrap the back of the queue to the front of the queue - DoubleEndedQueue
         */
        queue.add(janeJones);
        queue.add(johnDoe);
        System.out.println("Removing: " + queue.remove());

        queue.add(marySmith);
        System.out.println("Removing: " + queue.remove());

        queue.add(mikeWilson);
        System.out.println("Removing: " + queue.remove());

        queue.add(billEnd);
        System.out.println("Removing: " + queue.remove());

        queue.add(janeJones);
        System.out.println("Removing: " + queue.remove());
        System.out.println("Removing: " + queue.remove());
        System.out.println("Removing: " + queue.remove());

//        queue.add(johnDoe);
//        queue.add(marySmith);
//        queue.add(mikeWilson);
//        
//        queue.add(darrenSmith);
//        
//        queue.add(janeJones);
//        queue.add(johnDoe);
//        queue.add(marySmith);
//        queue.add(mikeWilson);
//        queue.add(darrenSmith);
//        queue.add(billEnd);
//        
        System.out.println("\nPrinting Queue....");
        queue.printQueue();
        System.out.println();
        System.out.println("Front: " + queue.getFront() + ", "
                + "Back(Next available position(0-based) to add): " + queue.getBack() + ", "
                + "Size of the queue: " + queue.size());

//        System.out.println("Peek: "+queue.peek());
    }
}
