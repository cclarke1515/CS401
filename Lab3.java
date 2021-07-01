import java.io.*;
import java.util.*;

public class Lab3
{
    public static void main(String[] args) throws Exception
    {
        if (args.length<1)
        {
            System.out.println("\nUsage: C:\\> java Lab2 <input filename>\n\n");
            System.exit(0);
        }
        BufferedReader infile = new BufferedReader(new FileReader(args[0]));
        ArrayList<String> jArray = new ArrayList<String>();
        while (infile.ready())
        {
            jArray.add(infile.readLine());
        } // END WHILE LOOP
        Collections.sort(jArray); // SORT ARRAY LIST
        for (String word : jArray)// FOR EACH WORD IN jARRAY
        {
            System.out.println(word + " " + canonical(word));
        }// END FOR LOOP
    } // END MAIN
    static String canonical(String word)
    {
        char[] letters = word.toCharArray();
        Arrays.sort(letters);
        return new String(letters);
    }// END CANONICAL METHOD
} // END LAB 3 CLASS