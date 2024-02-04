package basel;

public class Node {

    public Object element;
    public int next;

    public Node(Object element) {
        this(element, 0);
    }
    public Node(Object element, int next) {
        this.element = element;
        this.next = next;
    }

}
