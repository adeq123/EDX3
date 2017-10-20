package queue;

/**
 * Class that implements a Deque with a Double Linked List.
 *
 * @author DIT-UC3M
 *
 */
public class DLDqueue implements Dqueue {
  // Attributes
	private DNode top;
	private DNode tail;
	private int size;
	
  public DLDqueue() {
    top = new DNode();
    tail = new DNode();
    size = 0;
    top.setNext(tail);
    tail.setPrev(top);
  }

  public void insertFirst(Object obj) {
	  DNode second = top.getNext();
	  DNode first = new DNode(obj, second, top); 
	  top.setNext(first);
	  second.setPrev(first);
	  size++;
  }

  public void insertLast(Object obj) {
	  DNode bLast = tail.getPrev();
	  DNode last = new DNode(obj, tail, bLast); 
	  tail.setPrev(last);;
	  bLast.setNext(last);
	  size++;
  }

  public Object removeFirst() {
	  if(top.getNext() == tail)
		  return null;
    DNode first = top.getNext();
    DNode second = first.getNext();
    
    top.setNext(second);
    second.setPrev(top);
    size --;
    return first;
  }

  public Object removeLast() {
	  if(top.getNext() == tail)
		  return null;
    DNode last = tail.getPrev();
    DNode bLast = last.getPrev();
    
    tail.setPrev(bLast);
    bLast.setNext(tail);
    size --;
    return last;
  }

  public int size() {
    return size;
  }

  public String toString() {
    String toReturn = "";
    DNode aux = top.getNext();
    while( !aux.equals(tail)){
    	toReturn += (aux.getVal() + " ");
    	aux = aux.getNext();
    }
    
    return toReturn;
  }

  public static void main(String [] args)
  {
    DLDqueue d = new DLDqueue ();
    System.out.println("Test dequeue. Should be 3 2 1");
    d.insertFirst(1);
    d.insertFirst(2);
    d.insertFirst(3);
    System.out.println(d.toString());
    System.out.println("Test dequeue. Should be 3 2");
    System.out.println("Removed: " +d.removeLast().toString());
    System.out.println(d.toString());
    System.out.println("Test dequeue. Should be 2");
    System.out.println("Removed: " +d.removeFirst().toString());
    System.out.println(d.toString());
    
    d.insertLast(9);
    d.insertLast(8);
    d.insertLast(7);
    
    System.out.println("Test dequeue. Should be 2 9 8 7");
    System.out.println(d.toString());
  }

}

