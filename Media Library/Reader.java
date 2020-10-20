package mediaLib;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.math.BigDecimal;
import java.math.RoundingMode;

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
		
		System.out.println(avgPrice(songs));
		
		System.out.println(avgRating(songs));
		
		
		
	}
	
	public static double avgPrice(Song songs[]) {
		double total = 0;
		for(Song song: songs) {
			total += song.getPrice();
		}
		
		return round(total / songs.length, 2);
	}
	
	public static double avgRating(Song songs[]) {
		double total = 0;
		for(Song song: songs) {
			total += song.getRating();
		}
		
		return round(total / songs.length, 2);
	}
	
	public static double round(double value, int places) {
		if (places < 0) {
			throw new IllegalArgumentException();
		}
		
		BigDecimal decimal = new BigDecimal(value);
		decimal = decimal.setScale(places, RoundingMode.HALF_UP);
		return decimal.doubleValue();
	}
	

}
