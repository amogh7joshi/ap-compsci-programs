package diceGame;

import java.util.Random;

public class Dice {
	private Random rg = new Random();
	
	public Dice() {
		
		
	}
	
	int roll(int sides) {
		return (rg.nextInt(sides)) + 1;
 	}
	
	boolean isEven(int roll) {
		return roll % 2 == 0;
	}
	
	int sum(int...args) {
		int end = 0;
		for(int arg: args) {
			end += arg;
		}
		return end;
	}

}
