package race;

import java.util.Random;

public class Hare {
	static Random random;
	private int speed;
	private int position;
	
	public Hare() {
		this.speed = 10;
	}
	
	public int getPosition() {
		return this.position;
	}
	
	public void changePosition() {
		if ((random.nextInt(2) + 1) == 3)
			this.position += this.speed; 
 	}
	
	@Override
	public String toString() {
		return String.valueOf(this.position);
	}
}
