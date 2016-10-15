package Map;

import java.util.Arrays;
import java.util.Set;

public class ShortestUnique {

    class TrieNode{
        char c;
        TrieNode[] adj;
        public TrieNode(char c) {
            this.c = c;
            adj = new TrieNode[26];

        }
    }
    TrieNode root = new TrieNode(' ');
    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.adj[c - 'a'] == null) {
                node.adj[c - 'a'] = new TrieNode(c);
            }
            node = node.adj[c - 'a'];
        }
    }
    public boolean startsWith(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.adj[c - 'a'] == null) {
                return false;
            }
            node = node.adj[c - 'a'];
        }
        return true;
    }

    public String shortesUniq(String word, Set<String> words) {
        for (String s : words) {
            addWord(s);
        }


        for (int i = 0; i < word.length(); i++) {
            String check = word.substring(0, i + 1);
            if (!startsWith(check)) {
                return check;
            }
        }
        return null;
    }

}
