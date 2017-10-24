package BST;

/*
 * Implementation of Binary Search Trees
 */ 
 public class Test {

	public static void main(String args[]) throws Exception {
		// FIFA World Rankings http://en.wikipedia.org/wiki/FIFA_World_Rankings (9 Feb 2017)
		
		BSTree<Integer> tree = new LBSTree();
		tree.insert("Belgium", 1333);
		tree.insert("Argentina", 1445);
		tree.insert("Poland", 1323);
		tree.insert("Portugal", 1446);
		tree.insert("France", 1226);
		tree.insert("Brazil", 1619);
		tree.insert("Spain", 1218);
		tree.insert("Germany", 1631);
		tree.insert("Chile", 1173);
		tree.insert("Peru", 1160);
		// ... (to complete)
		
		System.out.println("INORDER: " + tree.toStringInOrder());
		System.out.println("SIZE= " + tree.size());

		System.out.println("France: " + tree.extract("France"));

		System.out.println("France: " + tree.search("France"));

		System.out.println("INORDER: " + tree.toStringInOrder());
		System.out.println("SIZE= " + tree.size());
	}
	
}