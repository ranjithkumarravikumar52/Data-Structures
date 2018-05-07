package heaps;

public class main {

    public static void main(String[] args) {
        Heaps heapTree = new Heaps(100); 
        heapTree.insert(80);
        heapTree.insert(75);
        heapTree.insert(60);
        heapTree.insert(68);
        heapTree.insert(55);
        heapTree.insert(40);
        heapTree.insert(52);
        heapTree.insert(67);
        
        heapTree.display();
        
        heapTree.delete(0);
        heapTree.display();
    }
}
