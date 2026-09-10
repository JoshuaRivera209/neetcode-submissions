class Solution {
    public boolean isPalindrome(String s) {
        /*
            the general appraoch with this problem is to use 2 pointers to evaluate the validity of the string being a palindrome.

            there are a few constraints to be mindful of:
                - we only care about the alphanumeric characters of the string.
                - capitalization + punctuation does not matter; we will ignore these things with logic
                - spaces also dont matter

            with the constraints in mind, the approach will work something like this:
                use a left and right pointer to start at the beginning and end of the string.
                we will check each *letter* position to ensure that they are the same, leading all the way to when the pointers cross paths.
                as long as the pointers maintain validity through this loop, we know the string is a valid palindrome.
                to handle the constraints, we will have while loops that will adjust the pointer positions until they reach an alphanumeric character.
                at the time of comparison, we will also convert letters to lowercase since we ignore capitalization.

            for a true result, the goal is to traverse the whole string and successfully exit the loop.
            if we dont exit the loop then we will return false at some point because we've reached and invalid matching, making the string not a valid palindrome.

            because we are doing this in place, the space complexity of the solution is O(1) and the time complexity is O(n) since we have to traverse the entire string for any valid palindrome.
        */
        // we can use a loop for the left pointer, and create the right pointer separately
        int r = s.length()-1;
        for (int l=0; l<r+1; l++) {
            while (l<r && !isAlphaNum(s.charAt(l))) {
                l++;
            }
            while (l<r && !isAlphaNum(s.charAt(r))) {
                r--;
            }
            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }
            r--;
        }
        return true;
    }
    
    // lets make a boolean function to check for alphanumeric characters to avoid redundant code
    public boolean isAlphaNum(char c) {
        return ((c >= '0' && c <= '9') || 
              (c >= 'A' && c <= 'Z') || 
              (c >= 'a' && c <= 'z'));
    }
}
