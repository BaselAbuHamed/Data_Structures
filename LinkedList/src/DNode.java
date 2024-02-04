public class DNode {

    Object element;
    DNode prev, next;

    DNode(Object element) {
        this(element, null, null);
    }

    public DNode(Object element, DNode prev, DNode next){
        this.element = element;
        this.prev = prev;
        this.next = next;
    }

    public DNode getNext() {
        return next;
    }

    public void setNext(DNode next) {
        this.next = next;
    }

    public DNode getPrev() {
        return prev;
    }

    public void setPrev(DNode prev) {
        this.prev = prev;
    }
}
