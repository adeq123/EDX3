package tree;

public class NonRecursiveLBTree<E> implements BTree<E> {
    
    // Attributes (non-recursive definition)
    private E info;
    private BTree<E> left;
    private BTree<E> right;
 
    /*
     * Constructor of an empty tree
     */
    public NonRecursiveLBTree() {
        this.info = null;
        this.left = null;
        this.right = null;
    }
    
    /* 
     * Constructor
     */
    public NonRecursiveLBTree(E info) {
        this.info = info;
        this.left = null;
        this.right = null;
    }
 
    /*
     * Checks if the tree is empty
     */
    public boolean isEmpty() {
        return (info == null);
    }
    
    /*
     * Returns the information stored in the node
     */
    public E getInfo() throws BTreeException {
        if (isEmpty()) {
            throw new BTreeException("Empty trees do not have info");
        }
        return info;
    }
    
    /*
     * Returns left and right subtrees
     */
    public BTree<E> getLeft() throws BTreeException {
             if (isEmpty()) {
            throw new BTreeException("Empty trees do not have a subtree");
        }
        return left;
    }
    
    public BTree<E> getRight() throws BTreeException {
                     if (isEmpty()) {
            throw new BTreeException("Empty trees do not have a subtree");
        }
        return right;
    }

    /* 
     * Inserts a given tree as a subtree in the given side
     */
    public void insert(BTree<E> tree, int side) throws BTreeException {
        if (isEmpty()) {
        	throw new BTreeException("Empty trees do not have a subtree");
        }
        if(side==LEFT) {
            if (this.left!=null) {
                throw new BTreeException("Left subtree is not empty");
            }  
            this.left = tree;
        } else {
            if (this.right!=null) {
                throw new BTreeException("Left subtree is not empty");
            }  
            this.right = tree;
        }
    }
    
    /*
     * Tree traversals
     */
    public String toStringPreOrder() {
        if (isEmpty()) {
            return "";
        } else {
            return info.toString() + " " +
                   (left!=null ? left.toStringPreOrder() : "") +
                   (right!=null ? right.toStringPreOrder() : "");
        }
    }
    
    public String toStringInOrder() {
        if (isEmpty()) {
            return "";
        } else {
            return (left!=null ? left.toStringPreOrder() : "") +
            		info.toString() + " " +
                   (right!=null ? right.toStringPreOrder() : "");
        }
    }
    
    public String toStringPostOrder() {
        if (isEmpty()) {
            return "";
        } else {
            return (left!=null ? left.toStringPreOrder() : "") +
                   (right!=null ? right.toStringPreOrder() : "") +
                   info.toString() + " ";
        }
    }
    
    /*
     * Tree properties
     */
    public int size() {
    	if(isEmpty()){
    		return 0;
    	}else{
    		return 1 + (left!=null ? left.size() : 0) +
                   (right!=null ? right.size() : 0);
    		
    	} 
        
    }
    
    public int height() {
        if(isEmpty()){
        	return -1;
        } else{
        	return Math.max(left!=null ? left.height() + 1 : -1, right!=null ? right.height() + 1 : -1);
        }
        
    }
    
}