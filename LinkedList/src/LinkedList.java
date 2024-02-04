public interface LinkedList {

     void add(Object data);
     void add(int index ,Object data) ;
     void addFirst(Object element);
     void addLast (Object element);
     Object get(int index);
     Object getFirst() ;
     Object getLast();
     boolean remove(int index);
     boolean removeFirst();
     boolean removeLast();
     void traverse (SNode Current);
     void printList();
     int searchList (Object x);
}
