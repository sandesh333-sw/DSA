public class Duplicates {
    public static void removeDuplicates(String str, int idx, StringBuilder newStr, boolean[] map) {
        if (idx == str.length()) {
            System.out.println(newStr);
            return;
        }

        // Processing
        char currChar = str.charAt(idx);
        if (map[currChar - 'a'] == true) {
            // Skip duplicate character
            removeDuplicates(str, idx + 1, newStr, map);
        } else {
            // Mark character as seen and add it to newStr
            map[currChar - 'a'] = true;
            removeDuplicates(str, idx + 1, newStr.append(currChar), map);
        }
    }

    public static void main(String[] args) {
        String str = "aabbccddeeff";
        boolean[] map = new boolean[26]; // Track if character has appeared
        removeDuplicates(str, 0, new StringBuilder(""), map);
    }
}
