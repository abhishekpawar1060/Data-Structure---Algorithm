public class Trie {
    
    public static Node root = new Node();

    static class Node {
        Node children[] = new Node[26];
        boolean eow;  //end of word 
        public Node(){
            for(int i = 0; i < 26; i++){
                children[i] = null;
            }    
        }
    }

    public static void insert(String word){
        int len = word.length();
        int idx = 0;
        Node curr = root;
        for (int i = 0; i < len; i++) {
            idx = word.charAt(i) - 'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            }            
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    public static boolean search(String key){
        int len = key.length();
        int idx = 0;
        Node curr = root;
        for (int i = 0; i < len; i++) {
            idx = key.charAt(i) - 'a';
            if(curr.children[idx] == null){
                return false;
            }
            curr = curr.children[idx];
        } 

        return curr.eow == true;

    }


    public static boolean startsWith(String prefix){
        Node curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';
            if(curr.children[idx] == null){
                return false;
            }

            curr = curr.children[idx];

        }
        return true;

    }
   
    public static boolean wordBreak(String key) {
        int len = key.length();
 
        if(len == 0) {
            return true;
        }
 
        for(int i=1; i<=len; i++) {
            if( search(key.substring(0, i)) &&
                wordBreak(key.substring(i)) ) {
                    return true;
                }
        }
 
        return false;
    }


    public static String ans = "";
    public static void longestWord(Node root, StringBuilder curr) {
        if (root == null) {
            return;
        }
    
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null && root.children[i].eow == true) {
                curr.append((char) (i + 'a'));
                if (curr.length() > ans.length()) {
                    ans = curr.toString();
                }
                longestWord(root.children[i], curr);

                curr.deleteCharAt(curr.length() - 1);
            }
        }
    }
 
 

    public static void main(String[] args) {
        String words[] = {"the", "t","there", "their", "any", "thee"};
        for (String word : words) {
           insert(word);
           System.out.println("inserted " + word);
        }

    //    System.out.println("thee -> " + search("thee"));
    //    System.out.println("thor -> " + search("thor"));


    //    System.out.println(startsWith("the"));
    //    System.out.println(startsWith("thi"));

    //    System.out.println(wordBreak("there"));

        
        
        longestWord(root, new StringBuilder(""));
        System.out.println("Longest word : "+ans);

    }
}
