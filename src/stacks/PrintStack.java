package stacks;

public class PrintStack{

	  /** Recursive algorithm to print a Stack */
	  private static void print(LinkedStack3<Integer> p)
	  {

		  if(p.isEmpty()){
			  System.out.println("Stack empty!");
		  }else{
			 System.out.println(p.pop().toString());
			 print(p);
		  }
	  } // print


	  public static void main(String [] args)
	  {
	    LinkedStack3<Integer> p = new LinkedStack3<Integer>();

	    p.push(1);
	    p.push(2);
	    p.push(3);
	    p.push(4);
	    p.push(5);

	    System.out.println("Stacks elements:");
	    print(p);

	  } // main

	    
	}
