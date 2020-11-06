package spinner;

import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Math;

public class mainSpinner {
	public static void main(String[] args) {
		Spinner spinner = new Spinner();
		ArrayList<Integer> spins = new ArrayList<Integer>();
		if(spinner.isEven(spinner.spin(2))) {
			spins.add(spinner.spin());
			spins.add(spinner.spin());
			int lowest = spins.indexOf(spinner.lowest(spins.get(0), spins.get(1)));
			int largest = 1 - lowest;
			spins.add(spinner.spin(4));
			spinner.result(spinner.product(spins.get(lowest), spinner.spin(4)) >= (int)Math.pow((double)(spins.get(largest)), 2.0));
		}
		else {
			ArrayList<Integer> indices = new ArrayList(Arrays.asList(0, 1, 2));
			spins.add(spinner.spin());
			spins.add(spinner.spin());
			spins.add(spinner.spin());
			int lowest = spins.indexOf(spinner.lowest(spins.get(0), spins.get(1), spins.get(2)));
			indices.remove(lowest);
			int product = 1;
			for(int index: indices) {
				product *= spins.get(index);
			}
			spinner.result(product >= spinner.product(spins.get(lowest), spinner.spin(10)));
			
		}
	}
}




