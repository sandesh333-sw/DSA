public class Creation{

    static class Node{
        Node[] children = new Node[26];
        boolean eow = false;

        public Node(){
            for(int i=0; i<26; i++){
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();


    //insertion tries
    public static void insert(String word){
        Node curr = root;

        for(int level=0; level<word.length(); level++){
            int idx = word.charAt(level)-'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }

        curr.eow = true;
    }

    //search tries
    public static boolean search(String key){
        Node curr = root;

        for(int level=0; level<key.length(); level++){
            int idx = key.charAt(level) - 'a';
            if(curr.children[idx] == null){
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow == true;
    }

    //word break problem
   public static boolean wordBreak(String key){
    if(key.length() == 0){
        return true;
    }
    for(int i = 1; i <= key.length(); i++){
        if(search(key.substring(0, i)) && wordBreak(key.substring(i))){
            return true;
        }
    }
    return false;
}





//startsWith Problem
public static boolean startsWith(String prefix){
    Node curr =root;

    for(int i=0; i<prefix.length(); i++){
        int idx = prefix.charAt(i) - 'a';
        if(curr.children[idx] == null){
            return false;
        }
        curr = curr.children[idx];
    }
    return true;
}


    public static void main(String args[]){
        // String[] words = {"the", "a", "there", "their", "any", "thee"};
        // for(int i=0; i<words.length; i++){
        //     insert(words[i]);
        // }

        // System.out.println(search("theess"));

        String[] arr = {"i", "like", "samsung", "mobile", "ice"};
        for(int i=0; i<arr.length; i++){
            insert(arr[i]);
        }

        String key = "ilikesassmsung";
        System.out.println(wordBreak(key));
    }
}