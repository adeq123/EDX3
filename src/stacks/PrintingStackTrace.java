package stacks;

public class PrintingStackTrace{
    static double fact (int n){
	    double result;
	    System.out.println("Enter fact("+n+")");
	    printStack();
	    if (n<=1){
	        System.out.println("Exit fact("+n+")");
	        printStack();
	        return 1;
	    }
	    else{
	        result = fact(n-1);
	        System.out.println("Exit fact("+n+")");
	        printStack();
	        return n*result;
	    }
    }

    static void printStack(){
	    System.out.println("Stack trace:");
	    StackTraceElement[] elements = Thread.currentThread().getStackTrace();
	    /* Change i=2 to i=0 and see what happens */
	    for (int i = 0; i < elements.length; i++) {
	        StackTraceElement s = elements[i];
	        System.out.println("\tat " + s.getClassName() + "."
			                   + s.getMethodName()
			                   + "(" + s.getFileName()
			                   + ":" + s.getLineNumber() + ")");
	    }
    }
    public static void main(String args[]){
	    System.out.println(fact(4));
    }
}

