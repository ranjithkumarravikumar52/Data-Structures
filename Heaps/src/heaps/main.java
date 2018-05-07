package heaps;

public class main {

    public static void main(String[] args) {
        Heaps heapTree = new Heaps(100); 
//        heapTree.insert(10);
//        System.out.println(heapTree);//10
//        
//        heapTree.insert(11);//10 11
//        System.out.println(heapTree);//11 10
//        
//        heapTree.insert(12);// 11 10 12
//        System.out.println(heapTree);// 12 10 11
//        
//        heapTree.insert(13);//12 10 11 13
//        System.out.println(heapTree);//13 12 11 10
        for(int i = 0; i < 100; i++){
            heapTree.insert(i);
        }
        System.out.println(heapTree);
    }
}
