
import java.util.HashMap;
import java.util.Map;

// Trie class implementation
public class Trie {
    // TrieNode class definition
    private class TrieNode {
    // Map to store the children nodes
    Map<Character, TrieNode> children;
    // Flag to indicate end of a word
    boolean endOfWord;
    
    
        
        // Constructor to initialize the TrieNode
    public TrieNode() {
        // Initialize the children map
        children = new HashMap<>();
        // Initialize endOfWord flag to false
        endOfWord = false;
    }
}

// Root node of the Trie
private final TrieNode root;

// Constructor to initialize the Trie
public Trie() {
    // Initialize the root node
    root = new TrieNode();
}

// Method to insert a word into the Trie
public void insert(String word) {
    // Start from the root node
    TrieNode current = root;
    // Iterate through each character of the word
    for (int i = 0; i < word.length(); i++) {
        char ch = word.charAt(i);
        // Get the node for the current character
        TrieNode node = current.children.get(ch);
        // If the node doesn't exist, create a new one
        if (node == null) {
            node = new TrieNode();
            current.children.put(ch, node);
        }
        // Move to the next node
        current = node;
    }
    // Mark the end of the word
    current.endOfWord = true;
}

// Method to search a word in the Trie
public boolean search(String word) {
    // Start from the root node
    TrieNode current = root;
    // Iterate through each character of the word
    for (int i = 0; i < word.length(); i++) {
        char ch = word.charAt(i);
        // Get the node for the current character
        TrieNode node = current.children.get(ch);
        // If the node doesn't exist, return false
        if (node == null) {
            return false;
        }
        // Move to the next node
        current = node;
    }
    // Return the endOfWord flag
    return current.endOfWord;
}

// Method to get the closest word in the Trie
public String getClosest(String word) {
    // Start from the root node
    TrieNode current = root;
    // Initialize the closest word
    String closest = "";
    // Iterate through each character of the word
    for (int i = 0; i < word.length(); i++) {
        char ch = word.charAt(i);
        // Get the node for the current character
        TrieNode node = current.children.get(ch);
        // If the node doesn't exist, break the loop
        if (node == null) {
            break;
        }
        // Move to the next node
        current = node;
        // Add the current character to the closest word
        closest += ch;
    }
    // If the current node is the end of a word, return it
    if (current.endOfWord) {
            return closest;
        }
        // If not, search the Trie for a closer match
        return dfs(current, closest);
    }

    private String dfs(TrieNode node, String str) {
        // If the current node marks the end of a word, return the current match
        if (node.endOfWord) {
            return str;
        }
        // Initialize the closest match
        String closest = "";
        // Search the Trie for a closer match
        for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
            String word = dfs(entry.getValue(), str + entry.getKey());
            // Update the closest match if a closer match is found
            if (closest.length() == 0 || word.length() < closest.length()) {
                closest = word;
            }
        }
        // Return the closest match
        return closest;
    }



    
}


