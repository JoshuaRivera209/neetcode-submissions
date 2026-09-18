class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        /*
            for this problem we want to create a hashmap that will organize all the data.
            the key for the hashmap will be a String.
            we will iterate through the array of strings, sorting each one alphabetically.
            when we sort the string we will store it in a temp variable to preserve the original word.
            sort the string, place it into the hashmap as the key. the value will be an array of the original strings that match the sorted string.
            AKA, the key will be the word in alphabetical order and the values will be an array of all the words that are anagrams of one another.
            time complexity: O(m * nlogn)
            space complexity: O(m*n)
        */
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] charArr = s.toCharArray();
            Arrays.sort(charArr);
            String temp = new String(charArr);
            map.computeIfAbsent(temp, k -> new ArrayList()).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
