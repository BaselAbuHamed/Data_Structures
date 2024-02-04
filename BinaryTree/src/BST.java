public class BST {

    public BSTNode root;

    public BST(){
        root=null;
    }

    //Check whether the element is in a tree or not
    public boolean contains (int e,BSTNode current){
        if (current==null)
            return false; // Not found, empty tree.
        else if (e<(int)current.element) // if smaller than root.
            return contains (e,current.left); // Search left subtree
        else if (e>(int)current.element) // if larger than root.
            return contains (e,current.right); // Search right subtree
        return true; // found .
    }

    //Returns the node contains the given element
    public BSTNode find(int element, BSTNode current){
        if (current == null)
            return null;
        if (element < (int) current.element)
            return find(element, current.left);
        else if (element > (int) current.element)
            return find(element, current.right);
        else
            return current;
    }

    //Insert element function
    public BSTNode insert (int element, BSTNode current){
        if (current==null)
            current= new BSTNode(element); //create one node tree
        else
        {
            if (element<(int)current.element)
                current.left=insert(element,current.left);
            else
                current.right=insert(element,current.right);
        }
        return current;
    }

    public void insert(int key)  {
        root = insert(key,root);
    }

    public void postOrder(BSTNode node)  {
        if (node == null)
            return;

        // first traverse left subtree recursively
        postOrder(node.left);

        // then traverse right subtree recursively
        postOrder(node.right);

        // now process root node
        System.out.print(node.element + " ");
    }

    // InOrder Traversal - Left:rootNode:Right (LnR)
    public void inOrder(BSTNode node)  {
        if (node == null)
            return;
        //first traverse left subtree recursively
        inOrder(node.left);

        //then go for root node
        System.out.print(node.element + " ");

        //next traverse right subtree recursively
        inOrder(node.right);
    }

    //PreOrder Traversal - rootNode:Left:Right (nLR)
    public void preOrder(BSTNode node)  {
        if (node == null)
            return;

        //first print root node first
        System.out.print(node.element + " ");
        // then traverse left subtree recursively
        preOrder(node.left);
        // next traverse right subtree recursively
        preOrder(node.right);
    }

    // Wrappers for recursive functions
    public void postOrder_traversal()  {
        postOrder(root);  }

    public void inOrder_traversal() {
        inOrder(root);   }

    public void preOrder_traversal() {
        preOrder(root);  }

    public BSTNode findMin (BSTNode current){
        if (current==null)
            return null;
        else if (current.left==null)
            return current;
        else
            return findMin(current.left); //keep going to the left
    }

    public BSTNode findMax (BSTNode current){
        if (current==null)
            return null;
        else if (current.right==null)
            return current;
        else
            return findMax(current.right); //keep going to the right
    }

    public BSTNode remove (int e,BSTNode current){
        if (current==null) return null; // Item not found,Empty tree
        if (e<(int)current.element)
            current.left=remove(e,current.left);
        else if (e>(int)current.element)
            current.right=remove(e,current.right);
        else // found element to be deleted
            if (current.left!=null && current.right!=null)// two children
            {
                /*Replace with smallest in right subtree */
                current.element=findMin(current.right).element;
                current.right=remove((int)current.element,current.right);
            }
            else
                current= (current.left!=null)?current.left:current.right;
        return current;
    }

}
