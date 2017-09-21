package LinkedList;

public class MyDoublyLinkedList<E extends Comparable<E>>{
    private NodeDouble<E> head;
    private NodeDouble<E> tail;
    
    public MyDoublyLinkedList(){
	    this.head = null;
	    this.tail = null;
    }
    
    /*
     * Insertion at the beginning
     */
    public void insert(E info){
	    NodeDouble<E> newNode = new NodeDouble<E>(info);
	    newNode.setNext(head);
	    if (head != null){
	        head.setPrev(newNode);
	    }
	    head = newNode;
	    if (tail == null){
	        tail = newNode;
	    }
    }
    /*
     * Insertion at the end 
     */
    public void insertEnd(E info){
	    NodeDouble<E> newNode = new NodeDouble<E>(info);
	    if (tail == null){
            head = newNode;
	        tail = newNode;
	    }else{
            tail.setNext(newNode);
            newNode.setPrev(tail);
	        tail = newNode;
	   }
    }
    
    /*
     * Extraction of the first node
     */
    public E extract(){
	    E data = null;
	    
	    if(tail != null && head == tail){
	    	data = head.getInfo();
	    	head = null;
	    	tail = null;		
	    }
	    if(head != null){
	    	data = head.getInfo();
	    	head = head.getNext();
	    }
	    return data;
    }
    /*
     * Extraction of the last node
     */
    public E extractEnd(){
	    E data = null;
	    
	    if(tail != null && head == tail){
	    	data = head.getInfo();
	    	head = null;
	    	tail = null;		
	    }else if(tail != null){
	    	data = tail.getInfo();
	    	tail = tail.getPrev();
	    	tail.setNext(null);
	    }
	    
	    
	    
	    return data;
    }
    /*
     * Delete all nodes with info equal to value
     * returns number of deleted nodes
     */
     
     public int deleteAll(E info){
    	
         int deleted = 0;
         
         NodeDouble aux = new NodeDouble();
    	 aux = head;
    	
    	 while(aux != null){
    		if(aux.getInfo() == info){
    			deleted++;
    			
    			if(aux.getPrev() != null)
    				aux.getPrev().setNext(aux.getNext());
    			
    			if(aux.getNext() != null)
    				aux.getNext().setPrev(aux.getPrev());
    			
    			if(aux == head)
    				head = aux.getNext();
    			
    			if(aux == tail)
    				tail = aux.getPrev();
    				
    		}
    		aux = aux.getNext();
    	 }
        	 
         
         return deleted;
     }
     
    /*
     * Print all list forward
     */
    public void print(){
	    NodeDouble<E> current = head;
	    
	    while (current != null){
	        System.out.print(current.getInfo() + " ");
	        current = current.getNext();
	    }
	    System.out.println();
    }
    /*
     * Print all list backwards
     */
    public void printBackwards(){
	    NodeDouble<E> current = tail;
	    
	    while (current != null){
	        System.out.print(current.getInfo() + " ");
	        current = current.getPrev();
	    }
	    System.out.println();
    }
}

