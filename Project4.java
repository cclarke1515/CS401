/* Project4.java  InsertInOrder with bSearch optimization to compute insertion index */
// STUDENT STARTER FILE
// YOUR NAME/ID:

import java.util.*;
import java.io.*;

public class Project4
{
    static final int INITIAL_CAPACITY = 5;
    
    public static void main( String args[] ) throws Exception
    {
        if (args.length < 1 )
        {
            System.out.println("ERROR: Must put input filename on cmd line\n");
            System.exit(0);
        }
        
        Scanner infile = new Scanner( new File( args[0] ) );        
               
        int[] arr = new int[INITIAL_CAPACITY];
        int count= 0;

        while ( infile.hasNextInt() )
        {
            if ( count==arr.length ) arr = upSizeArr(arr);
            if (insertInOrder( arr, count, infile.nextInt() ) )
		++count;
        }
        
        arr=trimArr(arr,count); // Now count == .length
        printArray( arr );  // we trimmed it thus count == length so we don't bother to pass in count
        
    }
    
    // ############################################################################################################
    
    static void printArray( int[] arr  )
    {
        for( int i=0 ; i<arr.length ;++i )
			System.out.print(arr[i] + " " );
        System.out.println();
    }
    
    static int[] upSizeArr( int[] fullArr )
    {
        int[] upSizedArr = new int[ fullArr.length * 2 ];
        for ( int i=0; i<fullArr.length ; ++i )
			upSizedArr[i] = fullArr[i];
        return upSizedArr;
    }
    
    static int[] trimArr( int[] oldArr, int count )
    {
        int[] trimmedArr = new int[ count ];
        for ( int i=0; i<count ; ++i )
			trimmedArr[i] = oldArr[i];
        return trimmedArr;
    }
    static boolean insertInOrder( int[] arr, int count, int newVal )
    {
        int index = bSearch(arr, count, newVal);
	    if ( index >= 0 ) return false;
        if (index<0)
        {
            index = -(index + 1);
        }
        for (int i=count-1; i>=index; i--)
        {
            arr[i+1] = arr[i];
        }
        arr[index] = newVal;
        return true;
    }
    static int bSearch(int[] a, int count, int key)
    {
        int lo = 0;
        int hi = count - 1;
        int mid = 0;
        while (lo <= hi)
        {
            mid = lo+(hi-lo)/ 2;
            if (key > a[mid])
            {
                lo = mid + 1;
            }
            else if (key < a[mid])
            {
                hi = mid - 1;
            }
            else
            {
                return mid;
            }
        }
        return -(lo + 1);
    }
}// END PROJECT4