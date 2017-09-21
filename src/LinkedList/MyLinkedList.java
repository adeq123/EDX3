package LinkedList;

public class MyLinkedList<E>{
	private Node<E> first;

	public MyLinkedList(){
		this.first = null;
	}

	/*
	 * Insertion at the beginning
	 */
	public void insert(E info){
		Node<E> newNode = new Node<E>(info);
		newNode.setNext(first);
		first = newNode;
	}
	/*
	 * Insertion at the end 
	 */
		
	public void insertEnd(E info){
		Node<E> newNode = new Node<E>(info);

		if(first == null){
			first = newNode;
		}else{
			Node<E> auxNode = first;
			Node<E> nextNode = auxNode;
			while((auxNode = auxNode.getNext())!=null){
				nextNode = auxNode;
			}
			nextNode.setNext(newNode);
		}
	}
		 
	/*
	 * Extraction of the first node
	 */
	public E extract(){
	    E data = null;
	    if (first != null){
	        data = first.getInfo();
	        first = first.getNext();
	    }
	    return data;
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
	
    /*
     * Delete the first occurrence of a value 
     * Return a boolean stating if the delete was successful
     */
    public boolean deleteFirstOccurrence(E info){
        boolean success = false;
        Node <E> currentNode = first;
        Node <E> previousNode = null;
        while(currentNode != null){
        	
        	if(currentNode.getInfo().equals(info)){
        		success= true;
        		if(previousNode == null){
        			first = first.getNext();
        		}else{
        			previousNode.setNext(currentNode.getNext());
        		}
        		
        	}
        	previousNode = currentNode;
        	currentNode = currentNode.getNext();
        }
        return success;
    }
    /*
     * Delete all the occurrences of a value
     * Returns the number of deleted nodes
     * You can use deleteFirstOccurrence
     */
     public int deleteAll(E info){
         int number = 0;
        while(deleteFirstOccurrence(info)){
        	number++;
        }
        return number;
    }
   
     
}

