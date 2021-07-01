// Lab1.java STARTER FILE

import java.io.*; // I/O
import java.util.*; // Scanner class

public class Lab1
{
	public static void main( String args[] ) 
	{
		final double MILES_PER_MARATHON = 26.21875; // i.e 26 miles 285 yards

		Scanner kbd = new Scanner (System.in);

		// THE FOLLOWING THREE VARIABLES ARE PRINTED OUT AT THE END OF THE PROGRAM
		double aveMPH=0, aveMinsPerMile=0, aveSecsPerMile=0;

		// YOUR JOB IS TO DO WHAT YOU HAVE TO TO TO PUT THE CORRECT VALUES INTO THEM
		// BEFORE THEY GET PRINTED OUT AT THE BOTTOM

		System.out.print("Enter marathon time in hrs minutes seconds: "); // i.e. 3 49 37
		// DO NOT WRITE OR MODIFY ANYTHING ABOVE THIS LINE

			final int SECONDS_PER_HOUR = 3600;
			final int SECONDS_PER_MIN = 60;
			double RTHours,RTMins,RTSecs;
			RTHours = kbd.nextDouble();
			RTMins = kbd.nextDouble();
			RTSecs = kbd.nextDouble();
		    double totalSeconds = (RTHours*SECONDS_PER_HOUR) + (RTMins*SECONDS_PER_MIN) + RTSecs;
			
			aveMPH = MILES_PER_MARATHON / (totalSeconds/SECONDS_PER_HOUR);
			aveMinsPerMile = (int) (totalSeconds/SECONDS_PER_MIN) / MILES_PER_MARATHON;
			aveSecsPerMile = (int) totalSeconds / MILES_PER_MARATHON;
			aveSecsPerMile = (int) aveMinsPerMile % aveSecsPerMile;
		

		// DO NOT WRITE OR MODIFY ANYTHING BELOW THIS LINE. JUST LET MY CODE PRINT THE VALUES YOU PUT INTO THE 3 VARS
		System.out.println();
		System.out.format("Average MPH was: %.2f mph\n", aveMPH  );
		System.out.format("Average mile split was %.0f mins %.1f seconds per mile", aveMinsPerMile, aveSecsPerMile );
		System.out.println();

	} // END MAIN METHOD
} // EOF