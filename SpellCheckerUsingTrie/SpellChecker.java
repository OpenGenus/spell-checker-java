
//SpellChecker class implements the spell checking functionality. 
public class SpellChecker {
    //A static Trie object that holds the dictionary for spell checking
    private static Trie dictionary;
    
    //Constructor that takes Trie object as an argument and sets it as the dictionary for spell checking
    public SpellChecker(Trie trie) {
        SpellChecker.dictionary = trie;
    }
    
    //ANSI escape codes for setting colors while printing words
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    //Method to check the spelling of words in the input string
    public  void check(String input) {
        //Splitting the input string into words
        String[] words = input.split("\\s+");
        System.out.print("The Sentence after checking: ");
        //Printing the spell checked words
        printCheckedTrie(words);
    }

    //Method to print the spell checked words along with the closest correct word
    public static void printCheckedTrie(String[] words) {
        int m=0;
        
        //Iterating through each word in the input
        for (String word : words) {
            //Checking if the word exists in the dictionary
            if (!dictionary.search(word)) {
                //If the word doesn't exist, print the word in red
                System.out.print(ANSI_RED + word + " " + ANSI_RESET);
                m++;
            } else {
                //If the word exists, print the word in blue
                System.out.print(ANSI_BLUE + word + " " + ANSI_RESET);
            }
        }
        //Printing a new line
        System.out.println();
        if (m==0) System.out.println("No mistakes, you're good.");
        else{
            //Printing the header for the possible corrections for misspelled words
            System.out.println(ANSI_YELLOW + "**Possible Corrections for misspelled words**" + ANSI_RESET);
            //Iterating through each word in the input
            for (String word : words) {
                //Checking if the word exists in the dictionary
                if (!dictionary.search(word)) {
                    //If the word doesn't exist, print the misspelled word in red along with the closest correct word in blue
                    System.out.println(ANSI_RED + word + ANSI_RESET + " --> " + ANSI_BLUE + dictionary.getClosest(word) + ANSI_RESET);
                }
            }
        }
    }
}



