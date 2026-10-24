class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {

            // Convert the word into a character array
            char[] chars = s.toCharArray();

            // Sort the characters
            Arrays.sort(chars);

            // Convert the sorted characters back to a String
            String key = new String(chars);

            // Create a list if this key does not exist
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            // Add the original word to its group
            map.get(key).add(s);
        }

        // Return all the groups
        return new ArrayList<>(map.values());
    }
}