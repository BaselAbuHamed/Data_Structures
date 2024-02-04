package basel;

public class MaxHeap {
    // declare array and variables
    private int[] heapData;
    private int sizeOfHeap;
    private int heapMaxSize;

    private static final int FRONT = 1;

    public MaxHeap(int heapMaxSize)  {
        this.heapMaxSize = heapMaxSize;
        this.sizeOfHeap = 0;
        heapData = new int[this.heapMaxSize];
    }

    private int getParentPosition(int position)  {
        return (position - 1) / 2;
    }

    private int getLeftChildPosition(int position)  {
        return (2 * position);
    }

    private int getRightChildPosition(int position)  {
        return (2 * position) + 1;
    }

    private boolean checkLeaf(int position)  {
        if (position > (sizeOfHeap / 2) && position <= sizeOfHeap) {
            return true;
        }
        return false;
    }

    private void swap(int firstNode, int secondNode)  {
        int temp;
        temp = heapData[firstNode];
        heapData[firstNode] = heapData[secondNode];
        heapData[secondNode] = temp;
    }

    private void maxHeapify(int position)  {

        if (!checkLeaf(position)) {
            if (heapData[position] <heapData[getLeftChildPosition(position)] ||
                    heapData[position] <heapData[getRightChildPosition(position)]) {

                if (heapData[getLeftChildPosition(position)] >heapData[getRightChildPosition(position)]) {
                    swap(position, getLeftChildPosition(position));
                    maxHeapify(getLeftChildPosition(position));
                }
                else {
                    swap(position, getRightChildPosition(position));
                    maxHeapify(getRightChildPosition(position));
                }
            }
        }
    }

    public void insertNode(int data)  {
        heapData[sizeOfHeap] = data;
        int current = sizeOfHeap;

        while (heapData[current] >heapData[getParentPosition(current)]) {
            swap(current, getParentPosition(current));
            current = getParentPosition(current);
        }
        sizeOfHeap++;
    }

    public void displayHeap()  {
        System.out.println("PARENT NODE" + "\t" + "LEFT CHILD NODE" + "\t" + "RIGHT CHILD NODE");
        for (int k = 0; k <sizeOfHeap / 2; k++) {
            System.out.print(" " + heapData[k] + "\t\t" + heapData[2 * k + 1] + "\t\t" + heapData[2 * k + 2]);
            System.out.println();
        }
    }

    public void designMaxHeap()  {
        for (int position = 0;  position < (sizeOfHeap / 2); position++) {
            maxHeapify(position);
        }
    }

    public int removeRoot()  {
        int popElement = heapData[FRONT];
        heapData[FRONT] = heapData[sizeOfHeap--];
        maxHeapify(FRONT);
        return popElement;
    }
}
