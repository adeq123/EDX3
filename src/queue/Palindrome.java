package queue;

import java.util.Stack;

public class Palindrome{
	
	private LinkedQueue<Character> q;
	private Stack<Character> s;
    
	public Palindrome(){

	}
    
	public boolean checkString(String str){
		q = new LinkedQueue<Character>();
		s = new Stack<Character>();
		boolean toReturn = true;
		char [] strChar;
		strChar = str.toCharArray();
		char singleChar;
		
		for(int i = 0; i < strChar.length; i++){
			singleChar = strChar[i];
			if(singleChar != ' ' && singleChar != ','&& singleChar != '?'&& singleChar != '!' && singleChar != '\''){
			q.enqueue(singleChar);
			s.push(singleChar);
			}
		}
		
		//q.print();
		//System.out.println(s.toString());
		
		char qChar;
		char sChar;
		
	for(int i = 0; i < s.size(); i++){
		qChar = Character.toLowerCase(q.dequeue());
		sChar = Character.toLowerCase(s.pop());
		if(sChar != qChar){
			toReturn = false;
		}
	}
		return toReturn;
	}
    public static void main(String [] args)
    {
       Palindrome myPalindrome = new Palindrome();
       String p1 = "A man, a plan, a canal, Panama";
       String p2 = "Was it a car or a cat I saw";
       String p3 = "No 'x' in Nixon";
       String p4 = "blelak";
       String p5 = "bhuoiho ooi ?? lak";
       
       System.out.println("String:\""+p1+"\" Is it a palindrome? "+myPalindrome.checkString(p1));
       System.out.println("String:\""+p2+"\" Is it a palindrome? "+myPalindrome.checkString(p2));
       System.out.println("String:\""+p3+"\" Is it a palindrome? "+myPalindrome.checkString(p3));
       System.out.println("String:\""+p4+"\" Is it a palindrome? "+myPalindrome.checkString(p4));
       System.out.println("String:\""+p5+"\" Is it a palindrome? "+myPalindrome.checkString(p5));
    }
}
