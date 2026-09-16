class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        /*
            - given int[] piles
            - piles[i] is the number of bananas
            - i is the pile #
            - ex: [1,4] -> pile 0 has 1 banana, pile 1 has 4 bananas.
            - given int h = # hours you have to consume all bananas in piles[i]
            - we decide k which is bananas per hour eating rate.
            - if piles[i] < k, you can finish eating the pile but you cant eat from another pile in the same hour.
            - return minimum k such that you can eat all bananas within h hours.
            - we use a binary search from 1-piles.max() to see what the minimum k is. we test based on middle value.
            if middle val can eat all bananas in h hours, we test for a smaller k by eliminating right side (moving right pointer to middle).
            if middle val cannot eat all bananas in h hours, we need a bigger k. eliminate *left* side *(moving left pointer to middle).

            since we need to loop through the array to get the max value, the space complexity of this becomes O(n * logm), where m=piles.max()
            space complexity is O(1) because we didnt create any new data structures to handle this
        */
        int l=0;
        int r=Arrays.stream(piles)
                .max()
                .getAsInt();
        int res = r;
        // we have left and right pointers now we just do binary search
        while (l<=r) {
            int k=(l+r)/2;
            int hours = 0;
            for (int p : piles) {
                hours += Math.ceil((double) p/k);
            }
            if (hours <= h) {
                res = Math.min(res, k);
                r=k-1;
            } else {
                l=k+1;
            }
        }
        return res;
    }
}
