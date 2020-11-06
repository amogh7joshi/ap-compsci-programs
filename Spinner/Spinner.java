package spinner;

import java.util.Random;

public class Spinner {
	private int firstint;
	private Random randomGenerator = new Random();
	
	public Spinner() {
		this.firstint = spin();
	}
	
	int spin(int bound) {
		return randomGenerator.nextInt(bound) + 1;
	}
	
	int spin() {
		return randomGenerator.nextInt(5) + 1;
	}
	
	int product(int a, int b) {
		return (int)(a * b);
	}
	
	boolean isEven(int a) {
		if (a % 2 == 0) return true;
		return false;
	}
	
	int lowest(int... values) {
		int low = Integer.MAX_VALUE;
		for(int val: values) {
			if (val < low) low = val;
		}
		return low;
	}
	
	void result(boolean outcome) {
		if(outcome == true) {
			System.out.println("You Win!");
		} else if(outcome == false) {
			System.out.println("You Lose!");
		}
	}


}

