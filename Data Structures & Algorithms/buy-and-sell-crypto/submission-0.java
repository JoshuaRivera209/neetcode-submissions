class Solution {
    public int maxProfit(int[] prices) {
        /*
            - prices[i] = NeetCoin on ith day
            - we choose a single day to buy one NeetCoin and a different day in the future to sell it
            - return maximum profit you can achieve. you may choose to not make any transactions, which would make the profit 0

            since we want to make the maximum profit, we can use the known saying: buy low, sell high
            we can apply this concept to this problem by doing the following:
            - use 2 pointers. the right pointer will expand the window and simultaneously evaluate to see if there is a better day to buy
            - we know its a better day to buy if the price is lower than the current buy day (left pointer).
            - we also note that we only check for a potential higher profit if the sell day is greater than the buy day
            - we update the profit when appropriate and also update the buy day if we find a lower price

            time complexity of this solution is O(n) because we need to scan the whole array of prices
            space complexity is O(1) because we didnt create any new data structures to handle these operations

            example of how to apply this approach:
            Input: prices = [10,1,5,6,7,1]
            Output: 6

            both pointers start at 10
            right++ -> goes to 1
            1 < 10, so we update left pointer to be 1
            right++
            right pointer is now 5
            1<5, profit potential so we update maximum
            profit = Math.max(profit, right-left)
            right++
            1<6, profit potential so we try to update max
            profit = Math.max(profit, right-left)
            repeat this pattern until right pointer reaches the end
        */

        int l=0;
        int maxProf=0;
        for (int r=0; r<prices.length; r++) {
            if (prices[r] < prices[l]) {
                l=r;
            } else if (prices[r] > prices[l]) {
                maxProf = Math.max(maxProf, (prices[r] - prices[l]));
            }
        }
        return maxProf;
    }
}
