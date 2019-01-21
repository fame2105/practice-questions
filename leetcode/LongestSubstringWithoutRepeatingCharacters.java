package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fame.issrani on 1/15/19.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int substring(String s) {
        int length = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;
        for (int i = 0, j = 0; j < length; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = map.get(s.charAt(j));
            }
            map.put(s.charAt(j), j + 1);
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters obj = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(obj.substring("peekewl"));
    }
}

//FAAME->AME
