package basel;

public class Main {

    public static void main(String[] args) {

        // Create a queue of capacity 4
        Queue q = new Queue(4);
// inserting elements in the queue
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        System.out.printf(String.valueOf(q.dequeue()));
        System.out.printf(String.valueOf(q.dequeue()));
    }
}
