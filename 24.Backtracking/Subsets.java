

public class Subsets {
    public static void findSub(String str, String ans,  int i){
        //BC
        if(i == str.length()){
            System.out.println(ans);
            return;
        }
        //Work
        //Yes
        findSub(str, ans+str.charAt(i), i+1);

        //No
        findSub(str, ans, i+1);
    }
    public static void main(String args[]){
        String str = "abc";
        findSub(str, "", 0);
    }
}

























/* 
Level 0: i = 0, char = 'a'

-> Include 'a':
    findSub("abc", "a", 1)

    -> Include 'b':
        findSub("abc", "ab", 2)

        -> Include 'c':
            findSub("abc", "abc", 3)  → Print "abc"
        -> Exclude 'c':
            findSub("abc", "ab", 3)   → Print "ab"

    -> Exclude 'b':
        findSub("abc", "a", 2)

        -> Include 'c':
            findSub("abc", "ac", 3)   → Print "ac"
        -> Exclude 'c':
            findSub("abc", "a", 3)    → Print "a"

-> Exclude 'a':
    findSub("abc", "", 1)

    -> Include 'b':
        findSub("abc", "b", 2)

        -> Include 'c':
            findSub("abc", "bc", 3)   → Print "bc"
        -> Exclude 'c':
            findSub("abc", "b", 3)    → Print "b"

    -> Exclude 'b':
        findSub("abc", "", 2)

        -> Include 'c':
            findSub("abc", "c", 3)    → Print "c"
        -> Exclude 'c':
            findSub("abc", "", 3)     → Print ""
*/