package basel;

class Queue {

    private int front, rear, capacity;
    private int queue[];
    Queue(int c)
    {
        front = rear = 0;
        capacity = c;
        queue = new int[capacity];
    }
    // queue is empty
    public boolean isEmpty()
    {
        if (front == rear)
            return true;
        else

            return false;

    }


    // queue is full
    public boolean isFull()
    {
        if (nextRear() == front)
            return true;
        else

            return false;

    }
    // return next rear
    public int nextRear()
    {
        if (rear == capacity - 1)
            return 0;
        else

            return rear + 1;

    }
    // return next front
    public int nextFront()
    {
        if (front == capacity - 1)
            return 0;
        else

            return front + 1;

    }
    // function to insert an element
// at the rear of the queue
    public void enqueue(int data)
    {
// check queue is full or not
        if (isFull()) {
            System.out.printf("\nQueue is full\n");
        }
// insert element at the rear
        else {

            rear = nextRear();
            queue[rear] = data;
        }
    }
    // function to delete an element
// from the front of the queue
    public int dequeue()
    {
// if queue is empty
        if (isEmpty()) {
            System.out.printf("\nQueue is empty\n");

            return 0;
        }
// insert element at the rear
        else {

            front = nextFront();
            return queue[front];
        }
    }
}
