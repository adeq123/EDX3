package queue;

import stacks.Stack;

/*
 * Class that implements a Stack with a Deque
 *  
 * @author DIT-UC3M
 *
 */
public class DQStack implements Stack {

  private DLDqueue data;

  public DQStack() {
   data = new DLDqueue ();
  }

  public void push(Object obj) {
   data.insertLast(obj);
  }

  public Object pop() {
    return data.removeLast();
  }

  public int size() {
    return data.size(); 
  }

  public String toString() {
    return data.toString();
  }

  public static void main(String[] args) {
    
    DQStack stack = new DQStack();
    for (int i = 0; i < 5; i++) {
      stack.push(i);
    }
    System.out.println("Printing stack: " + stack);

    int s = stack.size();
    System.out.println("Printing size: " + stack.size());

    Object o = stack.pop();
    System.out.println("Pop element = " + o);

    System.out.println("Printing stack: " + stack);
    
  }

@Override
public boolean isEmpty() {
	// TODO Auto-generated method stub
	return false;
}

@Override
public Object top() {
	// TODO Auto-generated method stub
	return null;
}
}
