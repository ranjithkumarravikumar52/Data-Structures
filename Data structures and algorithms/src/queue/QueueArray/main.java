package queue.QueueArray;

public class main {

    public static void main(String[] args) {
        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
        Employee billEnd = new Employee("Bill", "End", 78);

        QueueArray queue = new QueueArray(5);
        
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

//        System.out.println("Removing: "+queue.remove());
//        System.out.println("Removing: "+queue.remove());
//        System.out.println("Removing: "+queue.remove());
//        System.out.println("Removing: "+queue.remove());
//        System.out.println("Removing: "+queue.remove());
//        queue.add(janeJones);
//        queue.add(johnDoe);
//        queue.add(marySmith);
//        queue.add(mikeWilson);
//        queue.add(billEnd);
//        
//        System.out.println(queue.remove());
//        System.out.println(queue.remove());
//        System.out.println(queue.remove());
//        System.out.println(queue.remove());
//        System.out.println(queue.remove());
//        
//        queue.add(janeJones);
//        queue.add(johnDoe);
//        queue.add(marySmith);
//        queue.add(mikeWilson);
//        queue.add(billEnd);
        System.out.println("Size of the queue: " + queue.size());
        System.out.println("Front: " + queue.getFront());
        System.out.println("Back: " + queue.getBack());
        queue.printQueue();

//        System.out.println("Peek: "+queue.peek());
    }
}
