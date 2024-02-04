package basel;

public class Main {

    public static void main(String[] args) {
        Cursor cursor = new Cursor();

        cursor.initialization();

        //cursor.insertAtHead("Basel",3);
        cursor.insert("Basel",2,6);
        cursor.insert("Bilal",4,5);
        cursor.traversList(0);

        System.out.println(cursor.find("Basel",6));

        cursor.remove("Basel",6);
        cursor.traversList(0);


        cursor.cursorFree(0);
        cursor.traversList(0);

    }
}
