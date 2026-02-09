import java.util.*;

class Solution {
  public int lengthOfLongestSubstring(String s) {

    Map<Character, Integer> mp = new HashMap<>();
    int winStart = 0;
    int maxlen = 0;

    for (int winEnd = 0; winEnd < s.length(); winEnd++) {

      char ch = s.charAt(winEnd);

      if (mp.containsKey(ch)) {
        winStart = Math.max(winStart, mp.get(ch) + 1);
      }

      mp.put(ch, winEnd);
      maxlen = Math.max(maxlen, winEnd - winStart + 1);
    }

    return maxlen;
  }
}
