package basel;

public class Cursor {

    private Node[] cursorArray;
    private final static int MAX_SIZE = 10;

    public void initialization() {
        cursorArray = new Node[MAX_SIZE];
        for (int i = 0; i < MAX_SIZE; i++)
            cursorArray[i] = new Node(null, i + 1);
        cursorArray[MAX_SIZE - 1].next = 0;
    }

    public int cursorAlloc() {
        int p = cursorArray[0].next;
        cursorArray[0].next = cursorArray[p].next;
        return p;// return the index of the available node (most likely empty node)
    }

    public int createList(){
        /*create new empty list*/
        int l= cursorAlloc();
        if (l==0)
            System.out.println ("Error:out of space");
        else
            cursorArray[l]=new Node("-",0);//Empty Linked List
        return l; /*Head of the list*/
    }

    public void cursorFree(int p) {
        cursorArray[p].element = null; // free the content
        cursorArray[p].next = cursorArray[0].next;
        cursorArray[0].next = p;
    }

    public boolean isNull (int l){
        /*return true if the list not created*/
        return cursorArray[l]==null;
    }

    public boolean isEmpty (int l){
        //return true if the list is empty
        return cursorArray[l].next== 0;
    }

    public boolean isLast(int p){
        //check if the node p is last or not
        return cursorArray[p].next==0;
    }

    public void insertAtHead (Object data,int l){
        if (isNull(l)) //list not created
            return ;
        int p=cursorAlloc();
        if (p!=0){
            cursorArray[p]=new Node (data,cursorArray[l].next);
            cursorArray[l].next=p;
        }
        else
            System.out.println("Out Of Space");
    }

    public int find (Object data,int l) {

        int p = cursorArray[l].next;
        while((p != 0 )&& !cursorArray[p].element.equals(data))
            p = cursorArray[p].next;
        return p;
    }

    public void insert( Object data,int l,int p ){// l: list, p:pos
        int tmp = cursorAlloc();
        if(tmp != 0) {
            cursorArray[tmp].element = data;
            cursorArray[tmp].next = cursorArray[p].next;
            cursorArray[p].next = tmp; }
    }

    public void traversList (int l){
        System.out.print("list_"+l+"-->");
        while (!isNull(l) && !isEmpty(l)){
            //l is the head of the list
            l=cursorArray[l].next;
            System.out.print(cursorArray[l].element+"|"+"-->");
        }
        System.out.println("null"); //end of the list
    }

    public int findPrevious( Object x , int header) {
        int itr = header;
        while( cursorArray[ itr ].next != 0 &&
                !cursorArray[ cursorArray[ itr ].next ].element.equals( x ) )

            itr = cursorArray[ itr ].next;
        return itr;
    }

    public void remove(Object data,int l ) {
        int pos = findPrevious( data,l );//Implementation left as
        //an exercise
        if( cursorArray[pos].next != 0 ){//!isLast (pos)
            int tmp = cursorArray[pos].next;
            cursorArray[pos].next = cursorArray[tmp].next;
            cursorFree( tmp );
        }
    }
}
