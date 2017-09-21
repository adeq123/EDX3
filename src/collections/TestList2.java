package collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/*
 * Lists II.
 */
 public class TestList2{

    private static void printList(List<Integer> mine){
        for(Integer s : mine)
            System.out.print(s+" ");
        System.out.println();
    }
    private static List<Integer> createRandomList(int size, int max){
        List<Integer> result = new ArrayList<Integer>();
        
        for (int i=0; i< size; i++){
            result.add( (int)( Math.random()*max));
        }
        return result;
    } 
 
 
    private static void removeDuplicates(List<Integer> mine){
    	  	
    	Integer auxElem = mine.get(0);
    	List<Integer> auxList;
    	for(int i = 1; i < mine.size(); i++){
    		auxElem = mine.get(i-1);
    		auxList = mine.subList(i, mine.size());
    			while(auxList.contains(auxElem)){
    				auxList.remove(auxElem);
    		}
    		
    	}

    }
    
    public static void main(String args[]){
    	System.out.println("Random List");
    	List<Integer> myList = createRandomList(10,5);
	    printList(myList);
	    System.out.println("Removed duplicates");
	    removeDuplicates(myList);
	    printList(myList);
    }
}
