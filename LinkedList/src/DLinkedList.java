public class DLinkedList implements LinkedList{

    private DNode Front, Back;
    private int Size;

    public DLinkedList() {
        Front = null;
        Back = null;
        Size = 0;
    }

    @Override
    public void add(Object data) {

        add(Size,data);
    }

    @Override
    public void add(int index, Object data) {

        if (index == 0) addFirst(data);

        else if (index >= Size) addLast(data);

        else {
            DNode current = Front;
            DNode temp = new DNode(data);

            for (int i = 0 ; i < index -1 ; i++)
                current = current.next;
                temp.next=current.next;
                temp.prev=current;
                current.next.prev=temp;
                current.next=temp;
        }
    }

    @Override
    public void addFirst(Object element) {

        DNode newDNode;
        newDNode= new DNode (element);

        if (Size==0)
            Front=Back=newDNode;
        else {
            newDNode.next=Front;
            Front.prev=newDNode;
            Front=newDNode;
        }
        Size++;
    }

    @Override
    public void addLast(Object element) {

        DNode temp = new DNode(element);

        if (Front.next == null) {
            Front.next=temp;
            temp.prev=Front;
        }
        else {
            temp.prev=Back;
            Back.next=temp;
        }
        Back = temp;
        Size++;
    }

    @Override
    public Object get(int index) {

        if (Size==0) return null; //empty list
        else if (index==0) return getFirst(); //first element
        else if (index==Size-1)return getLast(); //last element

        else if (index >0 && index<Size-1){
            DNode currentF = Front;
            DNode currentB = Back;

            for (int i = 0 ; i < (Size / 2) + 1; i++) {

                if (i == index)
                    return currentF.element;

                else if (index == Size - 1 - i)
                    return currentB.element;

                currentF = currentF.next;
                currentB = currentB.prev;

            }
        }
        return null;
    }

    @Override
    public Object getFirst() {
        if (Size == 0)
            return null;
        else
            return Front.element;
    }

    @Override
    public Object getLast() {
        if (Size==0)
            return null;
        else
            return Back.element;
    }

    @Override
    public boolean remove(int index) {
        if (Size==0)return false;//empty linked list

        else if (index==0)return removeFirst(); //remove first element

        else if (index==Size-1)return removeLast();//remove last element

        else if (index >0 && index<Size-1){
            DNode currentF = Front;
            DNode currentB = Back;

            for (int i = 0 ; i <= index; i++) { //i < (Size / 2) + 1

                if (i == index-1) {
                    currentF.next=currentF.next.next;
                    currentF.next.next.prev=currentF;
                    Size--;
                    return true;
                }

                /*else if ( index -1 == Size -i) {
                    System.out.println(",,,");
                    //currentB.prev.next=currentB.next;
                    //currentB.next.prev=currentB.prev;
                    currentB.getPrev().setNext(currentB.getNext());
                    currentB.getNext().setPrev(currentB.getPrev());
                    Size--;
                    return true;
                }*/
                currentF = currentF.next;
                currentB = currentB.prev;
            }
        }
        return false;
    }

    @Override
    public boolean removeFirst() {
        if (Size==0)
            return false; //empty list
        else if (Size==1) //one element inside list
            Front=Back=null;
        else
            Front=Front.next;
        Size--; //update size
        return true;
    }

    @Override
    public boolean removeLast() {
        return false;
    }

    @Override
    public void traverse(SNode Current) {

    }

    @Override
    public void printList() {

        DNode current = Front;
        while (current != null){
            System.out.print(current.element +" " );
            current = current.next;
        }
    }

    @Override
    public int searchList(Object x) {
        return 0;
    }

    public int size() {
        return Size;
    }
}
