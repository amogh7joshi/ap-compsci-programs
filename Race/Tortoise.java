package race;

import java.util.Random;

public class Tortoise {
	static Random random;
	private int speed;
	private int position;
	
	public Tortoise() {
		this.speed = random.nextInt(2) + 2;
	}
	
	public int getPosition() {
		return this.position;
	}
	
	public void changePosition() {
		this.position += this.speed;
	}
	
	@Override
	public String toString() {
		return String.valueOf(this.position);
	}
}
