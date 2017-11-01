package BST;

public class LBSTree<E> implements BSTree<E> {
	
	/*
	 * Attribute: the node
	 */
	private LBSNode<E> root;
	private boolean isRemoved;
	/*
	 * Constructors
	 */
	public LBSTree(Comparable key, E info) {
		root = new LBSNode<E>(key, info, new LBSTree<E>(), new LBSTree<E>());
		this.isRemoved = false;
	}
	
	public LBSTree() {
		root = null;
		this.isRemoved = false;
	}
	
	/* 
	 * Checks if the tree is empty
	 */
	public boolean isEmpty() {
		return root == null;
	}
	
	/*
	 * Returns the search key of the information stored in the tree
	 */
	  public void setIsRemoved (boolean isRemoved){
		  this.isRemoved = isRemoved;
	  }
	  public boolean getIsRemoved (){
		  return isRemoved;
	  }
	public Comparable getKey() {
		if(isEmpty()) {
			return null;
		} else {
			return root.getKey();
		}
	}
	
	/*
	 * Returns the information stored in the tree
	 */
	public E getInfo() {
		return root.getInfo();
	}
	
	/* 
	 * Returns the left and right subtrees
	 */
	public BSTree<E> getLeft() { //add exception here,
		return root.getLeft();
	}
	
	public BSTree<E> getRight() {
		return root.getRight();
	}
	
	/*
	 * Inserts information into the tree. If key already exists, the information is overwritten
	 */
	public void insert(Comparable key, E info) {
		if(isEmpty()) {
			root = new LBSNode<E>(key, info, new LBSTree<E>(), new LBSTree<E>());
			this.isRemoved = false;
		} else {
			if(root.getKey().compareTo(key)>0) {
				getLeft().insert(key, info);
				//System.out.println("Adding " + (String) key + " to the left with root " + (String) root.getKey());
			} else if(root.getKey().compareTo(key)<0) {
				getRight().insert(key, info);
				//System.out.println("Adding " + (String) key + " to the right with root " + (String) root.getKey());
			} else {
				root.setInfo(info);
				this.isRemoved = false;
			}
		}
	}
	
	/*
	 * Searches for information in the tree
	 */
	public E search(Comparable key) throws Exception {
		if(root == null){
			throw new Exception("No result found!");
		}else{
			if(root.getKey().compareTo(key) > 0){
				return getLeft().search(key);
				//System.out.println("Searching" + (String) key + " to the left with root " + (String) root.getKey());
			}else if (root.getKey().compareTo(key)< 0){
				//right
				return getRight().search(key);
				//System.out.println("Searching " + (String) key + " to the right with root " + (String) root.getKey());
			}else {
				if(isRemoved){
					return null;
				}else{
					return root.getInfo();
				}
			}
			
		}
		//System.out.println("return " + (String) key + " to the left with root " + (String) root.getKey());
		
	}

	/*
	 * Searches and extracts information (dummy implementation)
	 */
	
	public E extract(Comparable key) throws Exception {
		if(isEmpty()){
			return null;
		}else{
			if(root.getKey().compareTo(key) > 0){
				return getLeft().extract(key);
			}else if (root.getKey().compareTo(key)< 0){
				//right
				return getRight().extract(key);
			}else {
				if(isRemoved){
					return null;
				}else{
					isRemoved = true;
					return getInfo();
				}
			}
			
		}
	}
	
	
	/*
	 * Tree traversals (dummy implementation)
	 */
	public String toStringPreOrder() {
		if(root == null){
			return "";
		}else{
			if(isRemoved){
				return 	root.getLeft().toStringPreOrder() +
						root.getRight().toStringPreOrder();
			}else{
			return root.getInfo() + " " +
					root.getLeft().toStringPreOrder() +
					root.getRight().toStringPreOrder();
			}
		}
		
	}
	
	public String toStringInOrder() {
		if(root == null){
			return "";
		}else{
			if(isRemoved){
				return 	root.getLeft().toStringPreOrder() +
						root.getRight().toStringPreOrder();
			}else{
			return 	root.getLeft().toStringInOrder() +
					root.getInfo() + " " +
					root.getRight().toStringInOrder();
			}
		}
	}
	
	public String toStringPostOrder() {
		if(root == null){
			return "";
		}else{
			if(isRemoved){
				return 	root.getLeft().toStringPreOrder() +
						root.getRight().toStringPreOrder();
			}else{
			return 	root.getLeft().toStringPostOrder() +
					root.getRight().toStringPostOrder()+
					root.getInfo() + " " ;
			}
		}
	}	
	
	/*
	 * Returns size of the tree (the number of pieces of information) (dummy implementation)
	 */
	public int size() {
		if(root == null){
			return 0;
		}else{
			return (!isRemoved ? 1 : 0) + getLeft().size() + getRight().size();
		}
	}
	
}
