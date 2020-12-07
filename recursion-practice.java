import java.util.Random;

public class recursion {
	public static void main(String args[]) {
		Random random = new Random();
		System.out.println(sumoneten(10));
		for(int i = 2; i <= 10; i++) {
			System.out.println("The factorial of " + i + " is " + factorial(i));
		}
		for(int i = 0; i < 15; i++) {
			int a = random.nextInt(9998) + 2;
			int b = random.nextInt(9998) + 2;
			System.out.println("The GCD of " + a + " and " + b + " is " + gcd(a, b));
		}
	}
	
	public static int sumoneten(int i) {
		if (i == 1) return 1;
		else return i + sumoneten(i - 1);
	}
	
	public static int factorial(int i) {
		if (i == 1) return 1;
		else return i * factorial(i - 1);
	}
	
	public static int gcd(int i, int j) {
		if (i == 0) return j;
		else return gcd(j % i, i);
	}
}
