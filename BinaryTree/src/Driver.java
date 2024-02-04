public class Driver {

    public static void main (String[]args){

        BST bst = new BST();

        bst.insert(45);
        bst.insert(10);
        bst.insert(7);
        bst.insert(12);
        bst.insert(90);
        bst.insert(50);

        System.out.println("BST => PreOrder Traversal:");
        bst.preOrder_traversal();
        //InOrder Traversal
        System.out.println("\nBST => InOrder Traversal:");
        bst.inOrder_traversal();
        //PostOrder Traversal
        System.out.println("\nBST => PostOrder Traversal:");
        bst.postOrder_traversal();

    }

}
