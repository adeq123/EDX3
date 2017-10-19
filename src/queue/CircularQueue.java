package queue;

/**
 * Universidad Carlos III de Madrid
 * Departamento de Ingenieria Telematica.
 * Int circular queue
 * 2017
 */


/**
  * Int Queue
  */
public class CircularQueue{

    /** Number of element in the queue */
    private int numElements;
    private int capacity;

    /** Array to save elements **/
    private int elements[];

    /** Indice to last element */
    private int head;
    private int tail;

    // Add one position and calculates if we must return the first position array.
    // Module opertion (%) is very important for this.
    private int next(int pos){
        return (pos+1) % (capacity+1);
    }


    /** Constructor to init the state object */
    CircularQueue(int capacity){
        numElements = 0;
        this.capacity = capacity;
        // We must create the array with an extra element to control the conditions empty and full
        elements = new int [capacity+1];
        tail = -1;
        head = -1;
    }

    /** Is empty the queue? */
    public boolean isEmpty(){
        
        return tail == head;
    }

    /** Is full the queue */
    public boolean isFull(){
        
        return head == next(tail);
    }

    /** Insert an element in the queue 
     * @throws Exception */
    public void enqueue(int element) throws Exception{
    	if(isFull())
    		throw new Exception("Queue is full");
    	numElements++;
    	tail = next(tail);
        elements [tail] = element;
    }

    /** Extract the element in the queue.
     *  There isn't control error 
     * @throws Exception */
    public int dequeue () throws Exception{
    	if(isEmpty())
    		throw new Exception("Queue is empty");
    	numElements--;
    	head++;
        return elements [head];
        
    }

    /** Returns the number of elements in the queue */
    public int numElements(){
        return numElements;
    }

    /** Print the elements in the queue*/
    public void print(){

        System.out.println("Head: " + head + " Tail: " + tail + " Number Elements: " + this.numElements);
        // from head to tail
        int index = head +1;
        for(int i = 1;i <= this.numElements; i++){
        	System.out.println("-"+elements [index]);
        	index = next(index);
        }
        System.out.println();
    }

   public static void main(String args[]) throws Exception{
     // Five elements maximun in the queue
	   CircularQueue queue = new CircularQueue(5);

     System.out.println("Is empty?: " + queue.isEmpty());
     queue.enqueue(1);
     queue.enqueue(2);
     queue.enqueue(3);
     queue.enqueue(4);
     queue.enqueue(5);
     System.out.println("Is full?: " + queue.isFull());

     int e;

     e = queue.dequeue();
     e = queue.dequeue();

     queue.print();

     e = queue.dequeue();
     e = queue.dequeue();

     queue.print();

     e = queue.dequeue();

     queue.print();

     queue.enqueue(1);

     queue.print();

     queue.enqueue(2);
     queue.enqueue(3);
     queue.enqueue(4);
     queue.enqueue(5);

     queue.print();

     System.out.println("Is empty?: " + queue.isEmpty());
     System.out.println("Is full?: " + queue.isFull());

   } // main

} // Queue
