public class Driver {

    public static void main (String []args){

        /*SLinkedList sl =new SLinkedList();

        sl.add("A");
        sl.addFirst("B");
        sl.add("E");
        sl.add(2,"S");
        sl.addLast("L");

        sl.printList();
        System.out.println();

        int x= sl.searchList("E");

        System.out.println(x);

        sl.remove(2);
        sl.removeFirst();
        sl.removeLast();

        sl.printList();*/

        DLinkedList dl = new DLinkedList();

        dl.addFirst("l");
        dl.addFirst("e");
        dl.addFirst("s");
        dl.addLast("D");
        dl.addFirst("a");
        dl.addFirst("b");
        dl.addLast("D");
        dl.add(2,"A");
        dl.add("M");
        dl.add(0,"K");

        dl.remove(8);


        dl.printList();
        System.out.println(dl.size());

    }
}
