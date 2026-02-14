import java.util.HashMap;
import java.util.Map;

class Solution {
    public String minWindow(String s, String t) {

        Map<Character,Integer> need = new HashMap<>();

        for(char c : t.toCharArray())
            need.put(c, need.getOrDefault(c,0)+1);

        int left = 0;
        int matched = 0;

        int minLen = Integer.MAX_VALUE;
        int start = 0;

        for(int right = 0; right < s.length(); right++){

            char r = s.charAt(right);

            if(need.containsKey(r)){
                need.put(r, need.get(r)-1);

                if(need.get(r) == 0)
                    matched++;
            }

            while(matched == need.size()){

                if(right-left+1 < minLen){
                    minLen = right-left+1;
                    start = left;
                }

                char l = s.charAt(left);

                if(need.containsKey(l)){
                    if(need.get(l) == 0)
                        matched--;

                    need.put(l, need.get(l)+1);
                }

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" :
                s.substring(start, start + minLen);
    }
}
