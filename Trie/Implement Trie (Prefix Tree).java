// Problem: Implement Trie (Prefix Tree)
// Link: https://leetcode.com/problems/implement-trie-prefix-tree/description/
// Approach: Trie

package Trie;

class Trie {
    private class Node{
        Node[] children = new Node[26];
        boolean isEndOfWord = false;
        public boolean isEndOfWord(){
            return isEndOfWord;
        }
        public void setEndOfWord(boolean endOfWord){
            this.isEndOfWord = endOfWord;
        }
    }

    private final Node root;

    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node current = root;
        for(int i = 0; i<word.length(); i++){
            char c = word.charAt(i);
            int idx = c - 'a';
            if(current.children[idx] == null){
                current.children[idx] = new Node();
            }
            current = current.children[idx];
        }
        current.setEndOfWord(true);
    }
    
    public boolean search(String word) {
        Node current = root;
        for(int i = 0; i<word.length(); i++){
            char c = word.charAt(i);
            int idx = c - 'a';
            if(current.children[idx] == null){
                return false;
            }
            current = current.children[idx];
        }
        return current != null && current.isEndOfWord();
    }
    
    public boolean startsWith(String prefix) {
        Node current = root;
        for(int i = 0; i<prefix.length(); i++){
            char c = prefix.charAt(i);
            int idx = c - 'a';
            if(current.children[idx] == null){
                return false;
            }
            current = current.children[idx];
        }
        return current != null;
    }
}