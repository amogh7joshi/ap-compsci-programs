package race;

public class Runner {
	public Runner(int times) {
		for (int i = 0; i < times; i++)
		{
			int position = 0;
			Tortoise tortoise = new Tortoise();
			Hare hare = new Hare();
			while (position < 100)
			{
				tortoise.changePosition();
				hare.changePosition();
				if (tortoise.getPosition() > hare.getPosition())
					position = tortoise.getPosition();
				else
					position = hare.getPosition();
					
				System.out.println("Hare: " + hare.getPosition() + " Tortoise: " + tortoise.getPosition());
			}
			
			if (tortoise.getPosition() > hare.getPosition())
				System.out.println("Race " + i + ": The Tortoise Wins!");
			else if (hare.getPosition() > tortoise.getPosition())
				System.out.println("Race " + i + ": The Hare Wins!");
			else
				System.out.println("Race " + i + ": Tie!");
			
		} 
		
	}
	
	public static void main(String args[])
	{
		Runner runner = new Runner(100);
	}
}
