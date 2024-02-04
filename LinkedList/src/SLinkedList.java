public class SLinkedList implements LinkedList{

    private SNode Front=null ,Back=null;
    private int listCounter=0;

    @Override
    public void add(Object data) {

        add(getListCounter(),data);
    }

    @Override
    public void add(int index ,Object data) {

        if (index==0) addFirst(data);

        else if (index>=getListCounter())addLast(data);

        else{
            SNode newNode= new SNode(data);
            SNode current=Front; //used to advance to proper position

            for (int i=0;i<index-1;i++)
                current=current.next;
                newNode.next=current.next;
                current.next=newNode;
                listCounter++;// update size
        }

    }

    @Override
    public void addFirst(Object element){
        SNode newNode;
        newNode=new SNode(element);
        if (listCounter==0) {// Empty List
            Front=Back=newNode;
        }
        else{
            newNode.next=Front;
            Front=newNode;
        }
        listCounter++;// update Size

    }

    @Override
    public void addLast (Object element){
        SNode newNode;
        newNode=new SNode(element);
        if (listCounter==0){// Empty List
            Front=Back=newNode;
        }
        else{
            Back.next=newNode;
            Back=newNode; // Or Back=Back.next;
        }
        listCounter++;// update Size
    }

    @Override
    public Object get(int index){

        if (listCounter==0) return null; //empty list
        else if (index==0) return getFirst(); //first element
        else if (index==listCounter-1)return getLast(); //last element

        else if (index >0 && index<listCounter-1){
            SNode current=Front;
            for (int i=0;i<index;i++)
                current=current.next;
                return current.data;
        }
        else
            return null; //out of boundary
    }

    @Override
    public Object getFirst() {
        if (listCounter == 0)
            return null;
        else
            return Front.data;
    }

    @Override
    public Object getLast(){
        if (listCounter==0)
            return null;
        else
            return Back.data;
    }

    @Override
    public boolean remove(int index){

        if (listCounter==0)return false;//empty linked list

        else if (index==0)return removeFirst(); //remove first element

        else if (index==listCounter-1)return removeLast();//remove last element

        else if (index >0 && index<listCounter-1){

            SNode current=Front;

            for (int i=0;i<index-1;i++)
                current=current.next;
                current.next= current.next.next;
                listCounter--;
                return true;
        }
        else return false; // out of boundary(invalid index)
    }

    @Override
    public boolean removeFirst(){
        if (listCounter==0)
            return false; //empty list
        else if (listCounter==1) //one element inside list
            Front=Back=null;
        else
            Front=Front.next;
        listCounter--; //update size
        return true;
    }

    @Override
    public boolean removeLast(){
        if (listCounter==0)
            return false; //empty list
        else if (listCounter==1) // one element inside the list
            Front=Back=null;
        else{
            SNode current= Front;
            for (int i=0;i<listCounter-2;i++)
                current=current.next;
            current.next=null;
            Back=current;
        }
        listCounter--; //update size
        return true;
    }

    @Override
    public void traverse (SNode Current){
        if(Current != null){
            System.out.println(Current.data);
            traverse(Current.next);
        }
    }

    @Override
    public void printList(){
        SNode current = Front;
        while (current != null){
            System.out.print(current.data +" " );
            current = current.next;
        }
    }

    @Override
    public int searchList (Object x){
        SNode current =Front;
        int i=0;
        while ((current != null)&&(!current.data.equals(x))){
            current=current.next;
            i++;
        }
        return i;
    }

    public void setListCounter(int listCounter) {
        this.listCounter = listCounter;
    }

    public int getListCounter() {
        return listCounter;
    }
}
