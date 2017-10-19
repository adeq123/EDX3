package queue;

/**
 * Universidad Carlos III de Madrid
 * Departamento de Ingenieria Telematica.
 * Int queue
 * 2017
 */


/**
  * Int Queue
  */
public class Queue{
        
    /** num elements*/
    private int numElements;
    private int capacity;

    /** Array to save elements **/
    private int elements[];

    private int head;
    private int tail;

    /** Constructor to init the state object */
    Queue(int capacity){
        this.capacity = capacity;
        elements = new int[capacity];
        numElements = 0;
        head = tail = -1;
    }

    /** Is empty the queue? */
    public boolean isEmpty(){
        // todo
        return (head == tail);
    }

    /** Is full the queue */
    public boolean isFull(){
        
        return ((capacity) == numElements);
    }

    /** Insert an element in the queue 
     * @throws Exception */
    public void enqueue(int element) throws Exception{
    	if(isFull())
    		throw new Exception("Queue is full");
       numElements++;
       tail++;
       elements[tail] = element;
    }

    /** Extract the element in the queue.
     *  There isn't control error */
    public int dequeue(){
    	numElements--;
        head++;    
        return elements[head];
    }

    /** Returns the number of elements in the queue */
    public int numElements(){
         
        return numElements;
    }

    /** Print the elements in the queue*/
    public void print(){
        for(int i = head+1;i <= tail; i++){
        	System.out.print(elements[i]);
        }
        System.out.println();
        
    }
        
   public static void main(String args[]) throws Exception{
     // test the class
	 Queue q = new Queue(10);
     System.out.println("Test the queue class");
     System.out.println("Is queue empty? "+q.isEmpty());
     System.out.println("Is queue full? "+q.isFull());
     System.out.println("Test adding to queue");
     
     for(int i = 0; i < 10; i++)
    	 q.enqueue(i);
     q.print();
     System.out.println("Is queue empty? "+q.isEmpty());
     System.out.println("Is queue full? "+q.isFull());
     System.out.println("Should be 0123456789");
     System.out.println("Test dequeue - the queue should decrease in each interation");
     for(int i = 0; i < 10; i++){
    	 q.dequeue();
    	 q.print();
     }
     System.out.println("Is queue empty? "+q.isEmpty());
     System.out.println("Is queue full? "+q.isFull());
   } // main

} // Queue