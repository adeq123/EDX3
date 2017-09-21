package LinkedList;

import java.util.ArrayList;

public class test {

	public static void main(String[] args) {
		ArrayList<Integer> arraylist = new ArrayList<Integer>();
		Integer var = new Integer(5);
		for (int i = 0; i<100; i++){
		    arraylist.add((int) (Math.random()*10));
		}

		while(!arraylist.isEmpty() && arraylist.contains(var)){
		    arraylist.remove(var);
		}
	for(int i = 0;i < arraylist.size(); i++){
		System.out.print(arraylist.get(i));
	}

	}

}
