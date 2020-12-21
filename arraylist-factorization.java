import java.util.ArrayList;
import java.util.Collections;

public class primeFactorization {
	private ArrayList<Integer> list;
	private ArrayList<Integer> primeFactors;
	private ArrayList<Integer> factors;
	
	public primeFactorization() {
		list = new ArrayList<Integer>();
		primeFactors = new ArrayList<Integer>();
		factors = new ArrayList<Integer>();
		
		list = fill(1, 24);
		
		for(int i = 0; i <= 23; i++)
		{
			primeFactors = getPrimeFactors(list.get(i));
			factors = getFactors(list.get(i));
			
			System.out.println("Num: " + list.get(i));
			System.out.println("\t Prime Factors: " + primeFactors.toString());
			System.out.println("\t Factors: " + factors.toString());
			
		}
	}
	
	static ArrayList<Integer> fill(int low, int high) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = low; i <= high; i++)
		{
			list.add(i);
		}
		return list;
	}
	
	static ArrayList<Integer> getPrimeFactors(int num){
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 2; i * i <= num; i++)
		{
			while(num % i == 0)
			{
				list.add(i);
				num /= i;
			}
		}
		if (num != 1)
		{
			list.add(num);
		}
		return list;
	}
	
	static ArrayList<Integer> getFactors(int num) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		int inc = num % 2 == 0 ? 1 : 2;
		
		for(int i = 1; i * i <= num; i += inc)
		{ 
			if (num % i == 0)
			{
				list.add(i);
				
				if (i != num / i)
				{
					list.add(num / i);
				}
			}
		}
		
		Collections.sort(list);
		
		return list;	
		
	}
	
	public static void main(String args[]) {
		primeFactorization fac = new primeFactorization();
	}

}
