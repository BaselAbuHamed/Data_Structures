package basel;

public class AVLTreeNode {

    int element; //store data
    AVLTreeNode left; // left child
    AVLTreeNode right; //right child
    int height; //Height

    public AVLTreeNode(int element){
        this(element, null, null);
    }

    public AVLTreeNode(int element, AVLTreeNode left, AVLTreeNode right)
    {
        this.element=element;
        this.left=left;
        this.right=right;
        this.height=0;
    }

}
