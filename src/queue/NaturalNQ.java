package queue;

public class NaturalNQ extends CircularQueue{

	NaturalNQ(int capacity) {
		super(capacity);
	}
	
	public void enqueue(int number) throws Exception{
		if(number > 0)
			super.enqueue(number);
	}
	public static void main(String args[]) throws Exception{
	     // Five elements maximun in the queue
	     
			NaturalNQ queue = new NaturalNQ(5);

	     System.out.println("Is empty?: " + queue.isEmpty());
	     queue.enqueue(-1);
	     queue.enqueue(2);
	     queue.enqueue(3);
	     queue.enqueue(4);
	     queue.enqueue(5);
	     System.out.println("Is full?: " + queue.isFull());

	     System.out.println("Elemento: " + queue.dequeue());
	     System.out.println("Elemento: " + queue.dequeue());
	     System.out.println("Elemento: " + queue.dequeue());
	     System.out.println("Elemento: " + queue.dequeue());
	 

	     System.out.println("Is empty?: " + queue.isEmpty());
	     
	   } // main

}
