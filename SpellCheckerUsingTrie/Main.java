import java.io.*;
import java.util.*;

// This is the Main class of the SpellCheckerUsingTrie program
public class Main {

    // A helper method to read the words from a file and insert them into a Trie
    public static Trie filetotrie(File file) throws FileNotFoundException {
        // Create a new Trie instance
        Trie trie = new Trie();
        // Create a scanner to read the file
        Scanner s = new Scanner(file);
        // Read the file line by line
        while (s.hasNextLine()) {
            String line = s.nextLine();
            // Insert each line (word) into the Trie
            trie.insert(line);
        }
        // Close the scanner
        s.close();
        // Print a message indicating that the reading of the file is done
        System.out.println("Done reading dictionary");
        // Return the Trie
        return trie;
    }
    // The main method of the program
    public static void main(String[] args) throws FileNotFoundException {
        // Create a File instance pointing to the file "words.utf-8.txt"
        File file = new File("words.utf-8.txt");
        // Call the helper method to read the words from the file and insert them into a Trie
        Trie trie = filetotrie(file);
        // Create a SpellChecker instance using the Trie
        SpellChecker spellChecker = new SpellChecker(trie);
        // Print a message to prompt the user to enter a string to be checked
        System.out.print("Enter the string to be checked (Characters only): ");
        // Create a scanner to read the user's input
        Scanner s = new Scanner(System.in);
        // Read the user's input
        String line;
        // Keep looping until the user enters 'q'
        while(( line = s.nextLine()) != null){
            // If the user enters 'q', break the loop
            if(line.equals("q")) break;
            // Call the check method of the SpellChecker to check the entered string
            spellChecker.check(line);
            // Print the prompt message again
            System.out.print("Enter another string: or ('q' for exit): ");
        }
        // Close the scanner
        s.close();
    }
}