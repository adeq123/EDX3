package LinkedList;

public class LinkedListHeadTail<E>{
    private Node<E> head;
    private Node<E> tail;
    
    public LinkedListHeadTail(){
	    this.head = null;
	    this.tail = null;
    }
    
    /*
     * Insertion at the beginning
     */
    public void insert(E info){
	    Node<E> newNode = new Node<E>(info);
	    newNode.setNext(head);
	    head = newNode;
	    if (tail == null){
	        tail = newNode;
	    }
    }
    /*
     * Insertion at the end 
     * Implement this method
     */
     
    public void insertEnd(E info){
	 	Node<E> newNode = new Node<E>(info);
	 	if (tail == null){
	    tail = newNode;
	    }else{
	        tail.setNext(newNode);
	        tail = newNode;
	    }
        if (head == null){
	    head = newNode;
	    }
    }
    
    /*
     * Extraction of the first node
     */
    public E extract(){
        E data = null;
       if (head != null){
           data = head.getInfo();
	     head = head.getNext();
	    }
        return data;
    }
    /*
     * Extraction of the last node
     * Implement this method
     */
    public E extractEnd(){
	    E data = null;
        Node<E> current = head;
        Node <E> prev = head;
         Node <E> prevPrev = head;
        while(current != null){
           prevPrev=prev;
            prev = current;
           current = current.getNext();
        }
        
        if(prev != prevPrev){
            data = prev.getInfo();
            tail = prevPrev;
            prevPrev.setNext(null);
        }else{
            head = null;
            tail = null;
        }
        
	    return data;
    }
    /*
     * Print all list
     */
    public void print(){
	    Node<E> current = head;
	    
	    while (current != null){
	        System.out.print(current.getInfo() + " ");
	        current = current.getNext();
	    }
	    System.out.println();
    }
    
    public static void main(String args[]){
        // Create a linked list using MyLinkedList<Integer>
    	LinkedListHeadTail<Integer> mine = new LinkedListHeadTail<Integer>();
	   
	    System.out.println("Inserting at beginning");
	    // Insert the first 10 ints at the beginning
	    for (int i=0; i< 10; i++){
	        mine.insert(i);
	        mine.print();
	    }
	    //Print the whole list
	    
	    
	    
	    System.out.println("Extracting from beginning");
	    //Extract all the elements from the list from the beginning
        Integer bar;
        while( (bar=mine.extract()) != null){
            System.out.print(bar + " ");
            mine.print();
        }	    
        System.out.println();
        System.out.println("Inserting at the end");
	    // Insert 10 ints at the end
	    for (int i=0; i< 10; i++){
	        mine.print();
	        mine.insertEnd(i);
	    }
	    //Print the whole second list
	    mine.print();
	    
        System.out.println("Extracting from the end");
        
        //Extract all the elements from the list from the end
        
        while( (bar=mine.extractEnd()) != null){
        	mine.print();
            //System.out.print(bar + " ");
            
        }
      mine.print();
        
    }
}
