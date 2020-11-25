package diceGame;

import java.util.ArrayList;
import java.util.Arrays;

public class diceGame {
	private static Dice d = new Dice();
	
	public static void main(String args[]) {
		runGame(10);
		runGame(100);
		runGame(1000);
		runGame(10000);
			
	}
	
	public static boolean simulateGame() {
		if (d.isEven(d.roll(4))){
			int twentyroll = d.roll(20);
			if(twentyroll > 16) {
				if(d.roll(8) > d.sum(d.roll(6), d.roll(6))) return true;
				else {
					if(d.isEven(d.roll(4))) return true;
					else return false;
				}
			}
			else if (twentyroll < 4) return false;
			else if (!d.isEven(twentyroll)) {
				if (d.roll(6) > d.roll(8)) return true;
				else return false;
			}
			else {
				ArrayList<Integer> rolls = new ArrayList<> (Arrays.asList(d.roll(4), d.roll(8), d.roll(6)));
				if (d.isEven(rolls.get(0)) && d.isEven(rolls.get(1)) && d.isEven(rolls.get(2))) return true;
				int nums = 0; for(Integer a: rolls) {if (d.isEven(a)) {nums++;}};
				if (nums == 2) {
					if(d.isEven(d.roll(4)) && d.isEven(d.roll(8))) return true;
					else return false;
				}
				else {
					if(d.sum(d.roll(4), d.roll(6)) > d.roll(20)) return true;
					else return false;
				}
			}
		}
		return true;
	}
	
	public static void runGame(int times) {
		ArrayList<Boolean> results = new ArrayList<Boolean>();
		for(int i = 0; i < times; i++) {
			results.add(simulateGame());
		}
		int wins = 0; int loss = 0;
		for(boolean res: results) {
			if (res) wins++;
			else loss++;
		}
		double time = times * 1.0;
		System.out.println("You won " + wins + " games and lost " + loss + " games"
				+ " out of " + times + "games. Your probability of winning was " + (double)(wins/time));
	}
	
	

}
