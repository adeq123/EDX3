package stacks;

import java.util.Stack;

public class RPNcalculator{

    /*
     * Implement a simple RPN calculator
     * with an Stack
     * this is a possible solution, others are
     * also possible
     */
    public static int calculate(String ops[]){
	    int result = 0;
	    String operators = new String("+-/*");
	    Stack <Integer> myStack = new Stack <Integer> ();

	    for (String op: ops){
            if(operators.contains(op)){
            	int number2 = myStack.pop();
            	int number1 = myStack.pop();
            	
                  	
            	if(op.equals("+")){
            	int result2 = number1 + number2;
            	myStack.push(result2);
            	}else if(op.equals("-")){
            		myStack.push(number1 - number2);
            	}else if(op.equals("/")){
            		myStack.push(number1 / number2);
            	}else if(op.equals("*")){
            		myStack.push(number1 * number2);
            	}
            	
            }else{
            	myStack.push(Integer.parseInt(op));
            	
            }
	    }
	    
	    if(!myStack.isEmpty())
	    	result = myStack.pop();

	    return result;
    }
    public static void main(String args[]){
        /*
	     * The main program should print
	        5 3 + =8
            5 3 - = 2
            2 1 12 3 / - + = -1
            3 2 * 11 - = -5
	    */
	    
	    String[] argu= new String[]{"5","3","+"};
	    int result = calculate(argu);
	    System.out.println("5"+" 3"+" +"+" ="+ result);
	    result = calculate(new String[]{"5","3","-"});
	    System.out.println("5"+" 3"+" -"+" = "+ result);
    	result = calculate(new String[]{"2","1","12","3","/", "-", "+"});
	    System.out.println("2"+" 1"+" 12"+" 3"+" /"+ " -"+ " +"+" = "+ result);
	    result = calculate(new String[]{"3", "2", "*", "11", "-"});
	    System.out.println("3"+" 2"+" *"+" 11"+" -"+" = "+ result);
	     
    }
}

