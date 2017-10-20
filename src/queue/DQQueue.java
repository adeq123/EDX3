package queue;

/*
 * Class that implements a Queue with a Deque
 *  
 * @author DIT-UC3M
 *
 */
public class DQQueue implements QueueInter {

  private DLDqueue data;

  public DQQueue() {
   data = new DLDqueue();
  }

  public void enqueue(Object obj) {
   data.insertLast(obj);
  }

  public Object dequeue() {
    return data.removeFirst();
  }

  public int size() {
   return data.size();
  }

  public String toString() {
   return data.toString();
  }

  public static void main(String[] args) {
    
    DQQueue queue = new DQQueue();
    for (int i = 0; i < 5; i++) {
      queue.enqueue(i);
    }
    System.out.println("Printing queue: " + queue);

    int s = queue.size();
    System.out.println("Printing size: " + queue.size());

    Object o = queue.dequeue();
    System.out.println("Deque element = " + o);

    System.out.println("Printing queue: " + queue);
    
  }

@Override
public boolean isEmpty() {
	// TODO Auto-generated method stub
	return false;
}

@Override
public Object front() {
	// TODO Auto-generated method stub
	return null;
}
}
