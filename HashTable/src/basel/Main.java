package basel;
import java.util.*;
public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Hash Table Test\n\n");
        System.out.println("Enter size");
        int size = scan.nextInt();
        HashMap hashTable = new HashMap(size);
        char ch;
        do
        {
            System.out.println("\nHash Table Operations\n");
            System.out.println("1. insert ");
            System.out.println("2. remove");
            System.out.println("3. get");
            System.out.println("4. clear");
            System.out.println("5. size");
            int choice = scan.nextInt();
            switch (choice){
                case 1 :
                    System.out.println("Enter key and value");
                    hashTable.insert(scan.next(), scan.next());

                    break;
                case 2 :
                    System.out.println("Enter key");
                    hashTable.remove(scan.next());

                    break;
                case 3 :
                    System.out.println("Enter key");
                    System.out.println("Value = "+ hashTable.find(
                            scan.next()));
                    break;
                case 4 :
                    hashTable.makeEmpty();
                    System.out.println("Hash Table Cleared\n");
                    break;
                case 5 :
                    System.out.println("Size = "+ hashTable.getTableSize() );
                    break;
                default :
                    System.out.println("Wrong Entry \n ");
                    break;
            }
/** Display hash table **/
            hashTable.printHashTable();
            System.out.println("\nDo you want to continue (Type y or n)\n");
                    ch = scan.next().charAt(0);
        } while (ch == 'Y'|| ch == 'y');
    }
    }

