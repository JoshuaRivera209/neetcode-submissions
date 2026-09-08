class Solution {
    public boolean isPalindrome(String s) {
        /*
            2 pointer approach; l and r pointers, checking at each iteration that they are the same letter until they cross paths

            this is done in place to produce a space complexity of O(1) and time complexity of O(n) because we MUST scan the whole string to ensure validity

            we disregard spaces and punctuation as the solution is case insensitive and ignores ALL non-alphanumeric chars

            to disregard these things, we can utilize a nested while loop that will skip over the invalid characters/spaces
            
            we must also account for invalid characters on the left side. since it is case insensitive we will also convert all characters to lowercase at the time of comparison
        */

        int l = 0;
        int r = s.length()-1;
        
        while (l<r) {
            while (l<r && !isAlphaNum(s.charAt(l))) {
                l++;
            }
            while (l<r && !isAlphaNum(s.charAt(r))) {
                r--;;
            }
            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public boolean isAlphaNum(char c) {
        return ((c >= '0' && c <= '9') || 
              (c >= 'A' && c <= 'Z') || 
              (c >= 'a' && c <= 'z'));
    }
}
