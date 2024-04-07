import java.util.Arrays;

/**
 * LongestSubstringWithoutRepeatingCharacters
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s){
        int n = s.length();
        int l = 0;
        int r = 0;
        int maxLen = 0;
        int[] hash = new int[256];
        
        Arrays.fill(hash, -1);

        while(r < n){
            if(hash[s.charAt(r)] != -1){
                if(hash[s.charAt(r)] >= l){
                    l = hash[s.charAt(r)] + 1;
                }
            }
            maxLen = Math.max(maxLen, r-l+1);
            hash[s.charAt(r)] = r;
            r++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";

        System.out.println(lengthOfLongestSubstring(s));
    }
}