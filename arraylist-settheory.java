import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListClass {
	private ArrayList<Integer> list1;
	private ArrayList<Integer> list2;
	
	public arrayListClass()
	{
		list1 = new ArrayList<Integer>(Arrays.asList(2, 5, 7, 10));
		list2 = new ArrayList<Integer>(Arrays.asList(1, 3, 5, 7, 9));
		
		// Union Method.
		System.out.println("Union: " + union());
		// Intersection Method.
		System.out.println("Intersection: " + intersection());
		// containedWithin Method.
		ArrayList<Integer> testList1 = new ArrayList<Integer>(Arrays.asList(5, 7));
		System.out.println("Contained Within 1: " + containedWithin(testList1, list1));
		ArrayList<Integer> testList2 = new ArrayList<Integer>();
		System.out.println("Contained Within 2: " + containedWithin(testList2, list1));
		ArrayList<Integer> testList3 = new ArrayList<Integer>(Arrays.asList(1, 5, 7));
		System.out.println("Contained Within 3: " + containedWithin(testList3, list1));
	}
	
	public ArrayList<Integer> union()
	{
		ArrayList<Integer> uni = new ArrayList<Integer>();
		for(int value: this.list1)
		{
			if(!uni.contains(value))
				uni.add(value);
		}
		for(int value: this.list2)
		{
			if(!uni.contains(value))
				uni.add(value);
		}
		return uni;
	}
	
	public ArrayList<Integer> intersection()
	{
		ArrayList<Integer> overlap = new ArrayList<Integer>();
		for(int value: this.list1) {
			if (this.list2.contains(value))
			{
				overlap.add(value);
			}
		}
		return overlap;
	}
	
	boolean containedWithin(ArrayList<Integer> list1, ArrayList<Integer> list2)
	{
		if (list1.isEmpty()) return true;
		int initialValue = list1.get(0);
		int startIndex;
		if(!list2.contains(initialValue)) 
			return false;
		else 
			startIndex = list2.indexOf(initialValue);
		for(int i = startIndex; i < startIndex + list1.size(); i++) {
			System.out.println(list1.get(i - startIndex) + " " + list2.get(i));
			if (!(list2.get(i) == list1.get(i - startIndex)))
				return false;
		}
		return true;
		
	}
	
	public static void main(String[] args)
	{
		ArrayListClass myclass = new ArrayListClass();	
	}
}
