import java.io.*;
import java.util.*;

public class Main {

    public static Set<String> filetoset(File file) throws FileNotFoundException {
        // Create a set to store the words from the file
        Set<String> SET = new HashSet<>();
        // Create a scanner to read the file
        Scanner s = new Scanner(file);
        // Loop through each line of the file
        while (s.hasNextLine()) {
            // Read a line from the file
            String line = s.nextLine();
            // Add the line (word) to the set
            SET.add(line);
        }
        // Close the scanner
        s.close();
        // Print a message indicating that reading the dictionary is done
        System.out.println("Done reading dictionary");
        // Return the set of words
        return SET;
    }

    /*
    The Fucntion of Main() method is as follows:
    1. It will load a txt file into set data structure.
    2. create a constructor for spellchecker class.
    3. accept input as string.
    4. prints output according to the input.
    */ 
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("words.utf-8.txt");
        Set<String> SET = filetoset(file);
        SpellChecker spellChecker = new SpellChecker(SET);
        System.out.print("Enter the string to be checked (Characters only): ");
        String line;
        Scanner s = new Scanner(System.in);
        while(( line = s.nextLine()) != null){
            if(line.equals("q")) break;
            spellChecker.check(line);
            System.out.print("Enter another string: or ('q' for exit): ");
        }
        s.close();
    }
}
