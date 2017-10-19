package queue;

public class LinkedQueue <E> implements QueueInter<E> {

	private Node<E> top;
	private Node<E> tail;
	private int size;
	
	public LinkedQueue(){
		
		top = null;
		tail = null;
		size = 0;
	}
	
	@Override
	public boolean isEmpty() {
		
		return top == null && tail == null;
	}

	@Override
	public int size() {
		
		return size;
	}

	@Override
	public void enqueue(E info) {
		Node<E> newNode = new Node<E>(info);
		if(isEmpty()){
			top = newNode;
			tail = newNode;
			size++;
		}else{
			tail.setNext(newNode);
			tail = newNode;
		}
		
	}

	@Override
	public E dequeue() {
		Node<E> aux;
		if(isEmpty()){
			//here we should throw an exception
		}else if(top==tail){
			aux = top;
			top=null;
			tail = null;
			size--;
			return aux.getInfo();
		}else{
			aux = top;
			top = top.getNext();
			size--;
			return aux.getInfo();
		}
			
		return null;
	}

	@Override
	public E front() {
		
		return top.getInfo();
	}
	
	public void print(){
		if(!isEmpty()){
			Node<E> aux;
			aux = top;
			
			while(aux != null){
				
				System.out.print(aux.getInfo());
				aux = aux.getNext();
			}
			
		}
	}
public static void main(String args[]){
	 LinkedQueue<Integer> q = new LinkedQueue<Integer>();
     System.out.println("Test the queue class");
     System.out.println("Is queue empty? "+q.isEmpty());
     System.out.println("Test adding to queue");
     
     for(int i = 0; i < 10; i++)
    	 q.enqueue(i);
     q.print();
     System.out.println("Is queue empty? "+q.isEmpty());
     System.out.println("Should be 0123456789");
     System.out.println("Test dequeue - the queue should decrease in each interation");
     for(int i = 0; i < 10; i++){
    	 q.dequeue();
    	 q.print();
     }
     System.out.println("Is queue empty? "+q.isEmpty());
}
}
