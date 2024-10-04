class Node{
    Node[] children = new Node[26];
    boolean eow = false;

    public Node(){}

    public boolean containsKey(char ch){
        return children[ch-'a'] != null;
    }

    public void putNode(char ch, Node node){
        children[ch-'a'] = node;
    }

    public Node getNode(char ch){
        return children[ch-'a'];
    }

    public void setEOW(){
        eow = true;
    }

    public boolean isEOW(){
        return eow;
    }

}

class Trie{
    Node root;
    public Trie(){
        root = new Node();
    }

    public void insert(String s){
        Node node = root;
        for(char ch : s.toCharArray()){
            if(!node.containsKey(ch)){
                node.putNode(ch, new Node());
            }
            node = node.getNode(ch);
        }

        node.setEOW();
    }

    public boolean search(String s){
        Node node = root;

        for(char ch : s.toCharArray()){
            if(!node.containsKey(ch)){
                return false;
            }
            node = node.getNode(ch);
        }
        
        return node.isEOW();
    }

    public boolean startsWith(String prefix){
        Node node = root;

        for(char ch : prefix.toCharArray()){
            if(!node.containsKey(ch)){
                return false;
            }

            node = node.getNode(ch);
        }

        return true;
    }
}


public class TrieImplementation {
    public static void main(String[] args) {
        String[] s = {"the", "there", "hi", "hii", "hello", "he"};

        Trie trie = new Trie();

        for(String str : s){
            trie.insert(str);
        }

        System.out.println(trie.search("he"));
        System.out.println(trie.startsWith("ther"));
    }
}
