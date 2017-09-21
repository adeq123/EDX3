package LinkedList;

/*
* Exercise for inserting in a sorted way (lowest to highest)
* elements within a linked list
*/
public class SortedInsertionLinkedList<E extends Comparable<E>> extends MyLinkedList<E> {

	private Node<E> first;

	public SortedInsertionLinkedList(){
		this.first = null;
	}
	
	/*
	 * inserting in a sorted way
	 */
	
	public void insert (E e){
		Node<E> newNode = new Node<E>(e);
		Node<E> auxNode = first;
		Node<E> prevNode = first;
		if(first == null){
			first = newNode;
			auxNode = first;
		}else{
			while(auxNode!=null && (auxNode.getInfo().compareTo(newNode.getInfo()) < 0)){
				prevNode = auxNode;
				auxNode = auxNode.getNext();
			}
			
			if(prevNode == auxNode){
				newNode.setNext(first);
				first = newNode;
			}else{
				
			prevNode.setNext(newNode);
			newNode.setNext(auxNode);
			}
			}
	}
	
	/*
	 * Print all list
	 */
	public void print(){
	    Node<E> current = first;
	    
	    while (current != null){
	        System.out.print(current.getInfo() + " ");
	        current = current.getNext();
	    }
	    System.out.println();
	}
   public static void main(String args[]){
	   int number;
       // Create a linked list using MyLinkedList<Integer>
	    MyLinkedList<Integer> mine = new MyLinkedList<Integer>();
	    SortedInsertionLinkedList <Integer> mineS = new SortedInsertionLinkedList<Integer>();
	   // Insert 10 ints 
	    for (int i=0; i< 5; i++){
	    	number = (int) (100*Math.random());
	        mine.insert(number);
	        mineS.insert(number);
	    }
	    
	    //Print the whole list
	    mine.print();
	    mineS.print();
   }
}
