/* Project2.java */

import java.io.*;
import java.util.*;

public class Project2
{
	static final int INITIAL_CAPACITY = 10;
	public static void main (String[] args) throws Exception
	{
		// ALWAYS TEST FIRST TO VERIFY USER PUT REQUIRED INPUT FILE NAME ON THE COMMAND LINE
		if (args.length < 1 )
		{
			System.out.println("\nusage: C:\\> java Project2 <input filename>\n\n"); // i.e. C:\> java Project2 dictionary.txt
			System.exit(0);
		}

		String[] words = new String[INITIAL_CAPACITY];
		int wordCount = 0;
		int vowelCount = 0;

		BufferedReader infile = new BufferedReader( new FileReader(args[0]) );
		while ( infile.ready() )
		{
			String word = infile.readLine();

			// # # # # # DO NOT WRITE/MODIFY ANYTHING ABOVE THIS LINE # # # # #
			if (words.length == wordCount)
			{
				words = upSize(words);
				System.out.println( "words.length after upSize: " + words.length );
			}
			words[wordCount++] = word;
			for (int i = 0; i<word.length(); i++)
				if (word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'i' || word.charAt(i) == 'o' || word.charAt(i) == 'u')
					++vowelCount;
			// # # # # # DO NOT WRITE/MODIFY BELOW THIS LINE IN MAIN   # # # # #

		} //END WHILE INFILE READY
		infile.close();

		words = downSize( words, wordCount );
		System.out.println( "After downSize() words.length=" + words.length + "\nwordCount=" + wordCount + "\nvowelCount=" + vowelCount );

		System.out.println( "The duplicate word is: " + findFirstDupe( words, wordCount ) );

	} // END main

	// RETURN AN ARRAY OF STRING 2X AS BIG AS ONE YOU PASSED IN
	// BE SURE TO COPY ALL THE OLD OWRDS OVER TO THE NEW ARRAY FIRST
	static String[] upSize( String[] fullArr )
	{
		String[] biggerArr = new String[fullArr.length * 2];
		for (int i=0; i<fullArr.length; i++)
			biggerArr[i] = fullArr[i];
		return biggerArr;
	}

	static String[] downSize( String[] arr, int count )
	{
		String[] smallerArr = new String[count];
		for (int i=0; i<count; i++)
			smallerArr[i] = arr[i];
		return smallerArr;
	}

	static String findFirstDupe( String[]  array,  int count )
	{
		for (int i=0; i<count; i++)
			for (int j=i+1; j<count; j++)
				if (array[i].equals(array[j]))
					return array[j];
		return "NO DUPE FOUND IN ARRAY"; // LEAVE THIS HERE
	}

} // END CLASS PROJECT#2