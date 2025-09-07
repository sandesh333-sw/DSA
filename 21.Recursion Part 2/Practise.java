public class Practise {

    public static void removeDuplicates(String str, int idx, StringBuilder newStr, boolean[] map){
        //base case
        if(idx == str.length()){
            System.out.println(newStr);
            return;
        }

        char curr = str.charAt(idx);
        if(map[curr - 'a'] == true){
            removeDuplicates(str, idx+1, newStr, map);
        } else {
            map[curr - 'a'] = true;
            removeDuplicates(str, idx+1, newStr.append(curr), map);
        }
    }
   
    public static void main(String args[]){
        String str = "agasfdaeeeewesaa";
        boolean[] map = new boolean[26];
        removeDuplicates(str, 0, new StringBuilder(""), map);
    }
}
