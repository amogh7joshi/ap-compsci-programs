package palindromeFinder;
import java.util.Scanner;

public class PalindromeCreator 
{
	public static void main(String[] args)
	{
		Scanner reader = new Scanner(System.in);
		
		System.out.println("Palindrome Finder!");
		System.out.print("\nEnter a phrase: ");
		String word = reader.nextLine();
		word = word.toLowerCase().replaceAll("\\p{P}", "").replaceAll("\\s", "");
		System.out.println();
		int wordlength = word.length();
		
		char splitWord[] = new char[word.length()];
		
		for (int i = 0; i < word.length(); i++)
		{
			splitWord[i] = word.charAt(i);
		}
		
		boolean checking = true; boolean palindrome = true;
		int recursive = 0;

		while (checking)
		{				
			if(splitWord[recursive] == splitWord[wordlength-1-recursive])
			{
				if (recursive == (wordlength-recursive+1) || recursive == (wordlength-recursive+2))
				{
					palindrome = true;
					checking = false;
				}
				else
					recursive++;				
			}
			else
			{
				checking = false;
				palindrome = false;
			}
		}
		
		if (palindrome)
		{
			System.out.println("\nYour phrase is a palindrome!");
		}
		else if (!palindrome)
		{
			System.out.println("\nYour phrase is not a palindrome!");
		}	
		
	}
}
