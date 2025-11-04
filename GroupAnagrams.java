class Solution {
    private String getFrequencyString(String str) {
        int[] freq = new int[26]; // Frequency array for 26 letters

        // Count frequency of each character
        for (char c : str.toCharArray()) {
            freq[c - 'a']++;
        }

        // Build a unique key for each word
        StringBuilder frequencyString = new StringBuilder();
        char c = 'a';
        for (int i : freq) {
            frequencyString.append(c);
            frequencyString.append(i);
            c++;
        }

        return frequencyString.toString();
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            String key = getFrequencyString(str);

            // If the key doesn’t exist, create a new list
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            // Add the current word to its anagram group
            map.get(key).add(str);
        }

        // Return the list of grouped anagrams
        return new ArrayList<>(map.values());
    }
}
