package Heap;


public class maxHeapUsingLinkedList1 {
    public static void main(String[] args) {
        maxHeap maxHeap = new maxHeap();
        maxHeap.insert(9);
        maxHeap.insert(10);
        maxHeap.insert(11);
        maxHeap.insert(12);
        maxHeap.insert(90);
        System.out.println(maxHeap.peek());
        maxHeap.remove();
        maxHeap.insert(200);
        maxHeap.remove();
        System.out.println(maxHeap.peek());
        maxHeap.print();
    }
}
