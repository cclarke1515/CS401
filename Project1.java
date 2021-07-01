// Project1.java

import java.io.*; // BufferedReader
import java.util.*; // Scanner to read from a text file

public class Project1
{
	public static void main (String args[]) throws Exception // we NEED this 'throws' clause
	{
		// ALWAYS TEST FIRST TO VERIFY USER PUT REQUIRED CMD ARGS
		if (args.length < 3)
		{
			System.out.println("\nusage: C:\\> java Project1 <input file name> <lo>  <hi>\n\n"); 
			// i.e. C:\> java Project1 P1input.txt 1 30
			System.exit(0);
		}
		
		String infileName = args[0];  // no need to convert, just copy into infileName
		int lo = Integer.parseInt( args[1] ); // conver to int then store into to
		int hi = Integer.parseInt( args[2] ); // conver to int then store into hi
		
	
		// STEP #1: OPEN THE INPUT FILE AND COMPUTE THE MIN AND MAX. NO OUTPUT STATMENTS ALLOWED
		Scanner infile = new Scanner( new File(infileName) );
		int min,max;
		min=max=infile.nextInt(); // WE ASSUME INPUT FILE HAS AT LEAST ONE VALUE
		while ( infile.hasNextInt() )
		{
			int x = infile.nextInt();
			if ( x < min )
				min = x;
			else if ( x > max )
				max = x;
		}
		System.out.format("min: %d max: %d\n",min,max); // DO NOT REMOVE OR MODIFY IN ANY WAY


		// STEP #2: DO NOT MODIFY THE REST OF MAIN. USE THIS CODE AS IS 
		// WE ARE TESTING EVERY NUMBER BETWEEN LO AND HI INCLUSIVE FOR
		// BEING PRIME AND/OR BEING PERFECT 
		for ( int i=lo ; i<=hi ; ++i)
		{
			System.out.print( i );
			if ( isPrime(i) ) System.out.print( " prime ");
			if ( isPerfect(i) ) System.out.print( " perfect ");
			System.out.println();
		}
	} // END MAIN
	
	// *************** YOU FILL IN THE METHODS BELOW **********************
	
	// RETURNs true if and only if the number passed in is perfect
	static boolean isPerfect( int n )
	{	
		int sum = 0;
		for (int div = 1; div <= n/2; ++div) 
			if (n % div == 0) sum += div;
		return (sum == n);
	}
	// RETURNs true if and only if the number passed in is prime
	static boolean isPrime( int n )
	{	
		if (n < 2) return false;
		for (int div = 2; div <= n/2; ++div) 
			if (n % div == 0) return false;
		return true;
	}
} // END Project1 CLASS