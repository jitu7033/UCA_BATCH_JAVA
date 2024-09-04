package Heap;


public class maxHeapUsingLinkedList1 {
    public static void main(String[] args) {

        // max heap are int top

        maxHeap maxHeap = new maxHeap();
        maxHeap.insert(11);
        maxHeap.insert(1000);
        maxHeap.insert(-110);
        System.out.println(maxHeap.peek());
        maxHeap.remove();
        maxHeap.print();
        System.out.println();

        // min heap are in bottom

        minHeap minHeap = new minHeap();
        minHeap.insert(11);
        minHeap.insert(10);
        minHeap.insert(0);
        minHeap.insert(-110000);
        minHeap.insert(10000);
        minHeap.remove();
        minHeap.remove();
        System.out.println(minHeap.peek());
        minHeap.print();

        // testing completed it is working now finally good
    }
}
