class Solution {
    public int[] twoSum(int[] nums, int target) {
        /*
            the approach:
                the array being sorted in non-decreasing order is HUGE for this problem and is the main reason why this approach works.
                we create left and right pointers, and we add their values (sum) and compare against target.
                if sum > target, we need to DECREASE our sum. this means we decrement the right pointer. we are able to do this because of the sorted array.
                on the other end, if sum < target, we need to INCREASE our sum. this means we increment left pointer.

                because there will always be exactly 1 valid solution, we know that once we reach the target value we can safely return.
                **remember that because this is 1-indexed, when we return we must return our pointer idx's+1**

                we are doing this in place as the prompt asks, so we are accomplishing this in O(1) (auxiliary) space complexity and O(n) time complexity.
        */

        int l=0;
        int r=nums.length-1;
        while (l<r) {
            int sum = nums[l]+nums[r];
            if (sum < target) {
                l++;
            } else if (sum > target) {
                r--;
            } else {
                return new int[] {l+1, r+1};
            }
        }
        return new int[] {l+1, r+1};
    }
}
