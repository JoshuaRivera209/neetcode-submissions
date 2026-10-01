class Solution {
    public int lengthOfLongestSubstring(String s) {
        /*
            - the mental model for something like this can be a for loop with the right pointer and the left pointer has to maintain a valid substring while trailing the right pointer
            - we will likely need to do this with a sliding window
            - we will need a couple things:
                - hashset to make sure we dont have duplicates
                - result variable that will be updated with potential new max lengths
                - l & r pointers
            - what we can do is start both pointers at the beginning of the array
            - grow the right pointer as long as the characters are unique, AND update the result variable as we go
            - we can do this by doing 2 things at each step:
                - add the current character to a hashset, if it is successful we know its unique
                - add the higher of the two values between the current max and the current size of the window (calculated by (r-l)+1)
            - if we have a duplicate, we decrease the size of the window AND remove the duplicate values from the hashset until we have a valid substring again
            - when we reach a duplicate, we have to remove the values from the LEFT pointer, because we dont know WHERE that duplicate character is in the substring
                - EX: say we have a substring like "abcdefc"
                    - we would need to remove "abc" in order to get a valid substring again
            - we have to scan the entire string, making best possible runtime O(n)

            time complexity: O(n)
            space complexity: O(m), where m is the size of the longest substring (because we use a hashset)
        */

        int l=0;
        int res=0;
        HashSet<Character> set = new HashSet<>();
        for (int r=0; r<s.length(); r++) {
            while (set.contains(s.charAt(r))) {
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            res=Math.max(res, (r-l)+1);
        }
        return res;
    }
}
