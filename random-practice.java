import java.lang.Math;
import java.util.stream.IntStream;;

public class randomPractice {
	
	public randomPractice() {
		sqrtRange(632, 751);
		averageNum(10);
		smallestValue(20);
	}
	
	public static void main(String[] args) {
		System.out.println(sqrtRange(632, 751));
		System.out.println(averageNum(10));
		System.out.println(smallestValue(20));
	}
	
	static double sqrtRange(int min, int max) { // Number 3
		return (double)(Math.sqrt((int)(Math.random() * (max - min) + min + 1)));
	}
	
	static double averageNum(int maxrange) { // Number 4
		int sum = 0;
		for(int i = 0; i < maxrange; i++) {
			sum += (int)(Math.random() * (74 - 6) + 7);
		}
		return (double)(sum / maxrange);
	}
	
	static int smallestValue(int maxrange) {
		int lowest = Integer.MAX_VALUE;
		int newint;
		for(int i = 0; i < maxrange; i++) {
			newint = (int)(Math.random() * (103 - 85) + 86);
			if (newint < lowest)
				lowest = newint;
		}
		return lowest;
	}
	
	
}
