import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

public final class Reading {
	
	private static String[] strings =  new String[30];
	private static Song[] songs = new Song[6];
	private static Scanner fileReader;
	
	public static void main(String[] args) {
		File myFile = new File("songList.txt");
		
		try {
			fileReader = new Scanner(myFile);
		}
		catch (FileNotFoundException e) {
			System.out.println("File Not Found.");
			e.printStackTrace();
		}
		
		String text = fileReader.nextLine();
		int i = 0;
		String word;
		
		while(text.length() > 0) {
			int delimeter = text.indexOf("|");
			word = text.substring(0, delimeter);
			text = text.substring(delimeter + 1);
			
			strings[i] = word;
			i++;
		}
		
		for(int t = 0; t < 30; t+=5) {
			songs[(t / 5)] = new Song(strings[t], strings[t+1], Integer.parseInt(strings[t+2]), 
					Double.parseDouble(strings[t+3]), Boolean.parseBoolean(strings[t+4]));
		}
		
		System.out.println(Arrays.toString(songs));
		
		
		
	}

}
