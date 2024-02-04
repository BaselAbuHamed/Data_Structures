public class BSTNode {

    Object element; //store data
    BSTNode left; // left child
    BSTNode right; //right child

    public BSTNode(Object element){
        this(element, null, null);
    }

    public BSTNode(Object element,BSTNode left,BSTNode right) {
        this.element = element;
        this.left = left;
        this.right = right;
    }
}
