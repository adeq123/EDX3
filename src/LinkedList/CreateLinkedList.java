package LinkedList;

/*
 * Exercise for Creation of a Linked List and printing
 */
public class CreateLinkedList{

    public static void main(String args[]){
	    
	   MyLinkedList myLL = new MyLinkedList<Integer> ();
	   
	    // Insert the first 10 ints at the beginning
	    for (int i=0; i< 10; i++){
	        myLL.insert(i);
	    }
	    //Print the whole list
	    myLL.print();
	    // Create another linked list using MyLinkedList<Integer>
	    MyLinkedList myLL2 = new MyLinkedList<Integer> ();

	    // Insert 10 ints at the end
	    for (int i=0; i< 10; i++){
	    	myLL2.insertEnd(i);
	    }
	    //Print the whole second list
	    myLL2.print();

    }
}
