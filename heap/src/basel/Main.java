package basel;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        LinkedList L = new LinkedList<Integer>();
        
        int heapSize;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of Max Heap");
        heapSize = sc.nextInt();

        MaxHeap heapObj = new MaxHeap(50);

        for(int i = 1; i<= heapSize; i++) {
            System.out.print("Enter "+i+" element: ");
            int data = sc.nextInt();
            heapObj.insertNode(data);
        }

        heapObj.designMaxHeap();

        System.out.println("The Max Heap is ");
        heapObj.displayHeap();

        //removing the root node from the heap
        System.out.println("After removing the maximum element(Root Node) "+heapObj.removeRoot()+", Max heap is:");
        heapObj.displayHeap();

    }
}
