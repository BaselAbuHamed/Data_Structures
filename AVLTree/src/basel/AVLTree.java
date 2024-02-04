package basel;

public class AVLTree {

    private AVLTreeNode root;

    public AVLTree(){
        root=null;
    }

    // Return the height of a node e
    public int height( AVLTreeNode e ){
        if( e == null )
            return -1;
        return e.height;
    }

    // Rotate binary tree node with left child(single rotate to right)
    private AVLTreeNode rotateWithLeftChild(AVLTreeNode k2){
        AVLTreeNode k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = Math.max(height(k2.left),height( k2.right ))+ 1;
        k1.height = Math.max(height(k1.left),k2.height )+ 1;
        return k1;
    }

    private AVLTreeNode rotateWithRightChild(AVLTreeNode k1) {
        AVLTreeNode k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
        k2.height = Math.max(height(k2.right), k1.height) + 1;
        return k2;
    }

    /* Double rotate binary tree node: first left child with its
    right child; then node k3 with new left child */
    private AVLTreeNode DoubleWithLeftChild(AVLTreeNode k3){
        k3.left = rotateWithRightChild( k3.left );
        return rotateWithLeftChild( k3 );
    }

    /*Double rotate binary tree node: first right child
    with its left child; then node k1 with new right child */
    private AVLTreeNode DoubleWithRightChild(AVLTreeNode k1){
        k1.right = rotateWithLeftChild( k1.right );
        return rotateWithRightChild( k1 );
    }

    //create getHeight() method to get the height of the AVL Tree
    public int getHeight(AVLTreeNode node ){
        return node == null ? -1 : node.height;
    }

    //create maxNode() method to get the maximum height from left and right node
    public int getMaxHeight(int leftNodeHeight, int rightNodeHeight) {
        return Math.max(leftNodeHeight, rightNodeHeight);
    }

    // create insertElement() to insert element to to the AVL Tree
    public void insertElement(int element)
    {
        root = insertElement(element, root);
    }

    private AVLTreeNode insertElement(int element, AVLTreeNode node) {
        //check whether the node is null or not
        if (node == null)
            node = new AVLTreeNode(element);
            //insert a node in case when the given element is lesser than the element of the root node
        if (element < node.element)
        {
            node.left = insertElement( element, node.left );
            if( getHeight( node.left ) - getHeight( node.right ) == 2 )
                if( element < node.left.element )
                    node = rotateWithLeftChild( node );
                else
                    node = DoubleWithLeftChild( node );
        }
        else if( element > node.element )
        {
            node.right = insertElement( element, node.right );
            if( getHeight( node.right ) - getHeight( node.left ) == 2 )
                if( element > node.right.element)
                    node = rotateWithRightChild( node );
                else
                    node = DoubleWithRightChild( node );
        }
        else
            ;  // if the element is already present in the tree, we will do nothing
        node.height = getMaxHeight( getHeight( node.left ), getHeight( node.right ) ) + 1;

        return node;

    }

    public boolean searchElement(int element)
    {
        return searchElement(root, element);
    }

    private boolean searchElement(AVLTreeNode head, int element) {
        boolean check = false;
        while ((head != null) && !check)
        {
            int headElement = head.element;
            if (element < headElement)
                head = head.left;
            else if (element > headElement)
                head = head.right;
            else
            {
                check = true;
                break;
            }
            check = searchElement(head, element);
        }
        return check;
    }

    // create inorderTraversal() method for traversing AVL Tree in in-order form
    public void inorderTraversal()
    {
        inorderTraversal(root);
    }

    private void inorderTraversal(AVLTreeNode head) {
        if (head != null)
        {
            inorderTraversal(head.left);
            System.out.print(head.element+" ");
            inorderTraversal(head.right);
        }
    }

    // create preorderTraversal() method for traversing AVL Tree in pre-order form
    public void preorderTraversal() {
        preorderTraversal(root);
    }

    private void preorderTraversal(AVLTreeNode head) {
        if (head != null)
        {
            System.out.print(head.element+" ");
            preorderTraversal(head.left);
            preorderTraversal(head.right);
        }
    }

    // create postorderTraversal() method for traversing AVL Tree in post-order form
    public void postorderTraversal()
    {
        postorderTraversal(root);
    }

    private void postorderTraversal(AVLTreeNode head) {
        if (head != null)
        {
            postorderTraversal(head.left);
            postorderTraversal(head.right);
            System.out.print(head.element+" ");
        }
    }

}
