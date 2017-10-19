package queue;

public class CircularLinkedList<E> {

	  // in a circle there is no "first", so we change the name
	  private Node<E> position;
	  private int size;
	  
	  // a list is always created in an empty state
	  protected CircularLinkedList() {
	    position = null;
	    size = 0;
	  }

	  // if we need position in classes that extend this one
	  protected Node<E> getPosition() {
	    return position; 
	  }

	  // simple and self-explained code. Worth to reuse it
	  public boolean isEmpty() {
	    return position == null; 
	  }

	  // we insert after position, just because we had
	  // to decide where to insert, but no special reason
	  public void insert(E o) {
		  Node<E> newNode = new Node<E>(o);
		  if(isEmpty()){
			  position = newNode;
			  position.setNext(position);
			  size++;
		  }else{
			  newNode.setNext(position.getNext());
			  position.setNext(newNode);
			  position = newNode;
			  size++;
		  }
	  }

	  public Node <E> extract() {
		  Node<E> aux;
		  if(isEmpty()){
			  aux = null;
		  }else if(size == 1){
			aux = position;
			position = null;
			//size --;
		  }else{
			aux = position.getNext();
			position.setNext(position.getNext().getNext());
			//size--;
		  }
		  
		  return aux;
	    // look carefully which value is returned in each case
	    //
	    // 1 - if the list is empty, return null
	    // 2 - if the list has only one value,
	    // return the value and state that the list is empty
	    // 3 - if the list has more than one value,
	    // return the value that is next to 'position' and
	    // the Node that contained the returned Object.
	    //
	    // Look that in the third case, instead of returning the value of
	    // position, it is returned the next in the list. Why? Because it was
	    // easier to implement, nothing else. (draw it for a better understanding)
	    
	    
	    // TODO 
	  }

	  public String toString() {
		  String s = new String ();
		  Node <E> aux = position;
	    for(int i = 0; i < size; i++){
	    	s += aux.getInfo()+" ";
	    	aux = aux.getNext();
	    }
	    return s;
	  }

	  public int size() {
	  
	    return size;
	  }

	  public Object[] toArray() {
		  Node <E> aux = position.getNext();
		  Object[] toReturn = new Object [size];
		  for(int i = 0; i < size; i++){
			  toReturn[i] = aux.getInfo();
		    	aux = aux.getNext();
		    }
	    return toReturn;
	  }
	  
	  public static CircularLinkedList getExample() {
		    CircularLinkedList out = new CircularLinkedList();

		    // a random int value from 0 to 9 (random never returns 1)
		    int numberOfElements = (int) (Math.random() * 10) + 1;

		    // the list is filled with Integer values
		    //
		    // note: the Integer class is the object oriented representation of a int
		    // value
		    System.out.println("Found NumberOffElements: "+numberOfElements);
		    for (int i = 0; i < numberOfElements; i++) {
		      // the value ranges from -25 to 25
		      int value = (int) (Math.random() * 51) - 25;
		      out.insert(new Integer(value));
		    }
		    // printing this to stdout is not required. I do it just to track the code
		    System.out.println("Number of elements: " + numberOfElements);
		    return out;
		  }

	}
