class Solution {
 public int longestConsecutive(int[] nums) {
 Set<Integer> set = new HashSet<>();
 int result = 0;

 for (int n : nums) set.add(n);

 for (int n : nums) {
 if (!set.contains(n - 1)) {
 int count = 0;
 while (set.contains(n)) {
 n++;
 count++;
 }
 result = Math.max(result, count);
 }
 }
 return result;
 }
}
