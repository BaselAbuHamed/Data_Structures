package basel;

public class Main {

    public static void main(String[] args) {
        AVLTree bst = new AVLTree();

        bst.insertElement(45);
        bst.insertElement(10);
        bst.insertElement(7);
        bst.insertElement(12);
        bst.insertElement(90);
        bst.insertElement(50);

        System.out.println("BST => PreOrder Traversal:");
        bst.preorderTraversal();
        //InOrder Traversal
        System.out.println("\nBST => InOrder Traversal:");
        bst.inorderTraversal();
        //PostOrder Traversal
        System.out.println("\nBST => PostOrder Traversal:");
        bst.postorderTraversal();
    }
}
