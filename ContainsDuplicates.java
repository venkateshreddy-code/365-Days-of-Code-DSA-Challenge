import java.util.HashSet;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        
        for (int num : nums) {
            if (set.contains(num)) {
                return true; // duplicate found
            }
            set.add(num);
        }
        return false; // no duplicates
    }

    public static void main(String[] args) {
        ContainsDuplicate cd = new ContainsDuplicate();
        int[] arr1 = {2, 3, 4, 2};
        int[] arr2 = {6, 7, 8, 9};
        System.out.println(cd.containsDuplicate(arr1)); // true
        System.out.println(cd.containsDuplicate(arr2)); // false
    }
}
