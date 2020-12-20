import java.util.ArrayList;
import java.util.Random;
import java.util.Iterator;
import java.util.stream.IntStream;

public class arraylistwork {
	public static void main(String args[]) {
		ArrayList<Integer> arraylist = new ArrayList<Integer>();
		arraylist = filler(30);
		output(arraylist);
		output(sorter(arraylist, 0));
		output(sorter(arraylist, 1));
	}
	
	public static ArrayList<Integer> filler(int max){
		ArrayList<Integer> arraylist = new ArrayList<Integer>();
		Random rg = new Random();
		for(int i = 0; i < max; i++) {
			arraylist.add(rg.nextInt(9) + 1);
		}
		return arraylist;
	}
	
	public static int printnum(int num, int val) {
		System.out.print(num + " ");
		if (val % 5 == 0) System.out.println();
		return 1;
	}
	
	static void doOut(int num, int indx) {
		System.out.print(num + " ");
		if ((indx + 1) % 5 == 0) System.out.println();
	}
	
	public static void output(ArrayList<Integer> arraylist) {
		final Iterator<Integer> it = IntStream.range(0,  arraylist.size()).iterator();
		arraylist.stream().forEach(i -> doOut(i, it.next()));
		System.out.println("\n");
	}
	
	static ArrayList<Integer> quicksort(ArrayList<Integer> arraylist){
		if(arraylist.size() <= 1) return arraylist;
		
		ArrayList<Integer> sorted = new ArrayList<Integer>();
		ArrayList<Integer> lesser = new ArrayList<Integer>();
		ArrayList<Integer> greater = new ArrayList<Integer>();
		
		int pivot = arraylist.get(arraylist.size() - 1);
		for(int i = 0; i < arraylist.size() - 1; i++) 
		{
			if (arraylist.get(i).compareTo(pivot) < 0)
				lesser.add(arraylist.get(i));
			else
				greater.add(arraylist.get(i));
		}
		
		lesser = quicksort(lesser);
		greater = quicksort(greater);
		
		lesser.add(pivot);
		lesser.addAll(greater);
		sorted = lesser;
		
		return sorted;
		
	}
	
	static ArrayList<Integer> reverseList(ArrayList<Integer> arraylist){
		for(int i = 0; i < arraylist.size() - 1; i++) {
			arraylist.add(i, arraylist.remove(arraylist.size() - 1));
		}
		return arraylist;
	}
	
	public static ArrayList<Integer> sorter(ArrayList<Integer> arraylist, int choice){
		ArrayList<Integer> sorted = quicksort(arraylist);
		if (choice == 0) return sorted;
		else return reverseList(sorted);
		
	}
}

