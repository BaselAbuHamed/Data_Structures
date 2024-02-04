public class SNode {

    SNode next;
    Object data;

    public SNode(Object data){
        next=null;
        this.data=data;
    }

    public SNode(Object data, SNode next){
        this.next=next;
        this.data=data;
    }

    public SNode getNext() {
        return next;
    }
    public void setNext(SNode next) {
        this.next = next;
    }
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
}
