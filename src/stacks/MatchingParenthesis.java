package stacks;

import java.util.Stack;

public class MatchingParenthesis{
    
    /*
    * You should change the code to work with any kind of
    * parenthesis {} () []
    */
    
    public static boolean balanced(String mystring){
        Stack<Character> stack = new Stack<Character>();
	    char c;
	    char fromStack;
	    for (int i=0; i < mystring.length();i++){
	        c = mystring.charAt(i);
	        if ( c == '('){
		        stack.push(c);
	        }
	        else if (c == ')'){
		        if (stack.isEmpty()){
    		        return false;
	    	    }
		        fromStack = stack.pop();
		        if (fromStack != '('){
		            return false;
		        }
	        }else if ( c == '['){
	        	stack.push(c);
	        }else if (c == ']'){
		        if (stack.isEmpty()){
    		        return false;
	    	    }
		        fromStack = stack.pop();
		        if (fromStack != '['){
		            return false;
		        }
	        }else if ( c == '{'){
	        	stack.push(c);
	        }else if (c == '}'){
		        if (stack.isEmpty()){
    		        return false;
	    	    }
		        fromStack = stack.pop();
		        if (fromStack != '{'){
		            return false;
		        }
	        }
	    }
	    return stack.isEmpty();
    }
    
    public static void main(String args[]){

	    System.out.println("(())"+" balanced? "+balanced("(())"));
	    System.out.println("((1,b,c))"+" balanced? "+balanced("((1,b,c))"));
	    System.out.println("((1),(b,c))"+" balanced? "+balanced("((1),(b,c))"));
	    System.out.println("((1)),(b,c))"+" balanced? "+balanced("((1)),(b,c))"));
	    System.out.println("((1,(b,c)))"+" balanced? "+balanced("((1,(b,c)))"));
	    System.out.println("((1),(b,c)))"+" balanced? "+balanced("((1),(b,c)))"));
	    System.out.println(""+" balanced? "+balanced(""));
	    /*Your code should work also with these strings:*/
	    /*For this one the condition is true*/
	    System.out.println("(([]{}))"+" balanced? "+balanced("(([]{}))"));
	    /*For this one the condition is false*/
	    System.out.println("(([]]{}}))"+" balanced? "+balanced("(([]]{}}))"));
    }
}

