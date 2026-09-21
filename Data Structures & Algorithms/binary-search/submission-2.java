class Solution {
    public int search(int[] nums, int target) {
        /*
            remember conditions for a binary search:
            if the midpoint is GREATER than our target, then we know everything to the right of it is also greater. we can eliminate the right side.
            if the midpoint is LESS than our target, then we know everything to the left of it is also less. we can eliminate the left side.
        */

        int l=0;
        int r=nums.length-1;
        while (l<=r) {
            int mid = l + ((r-l)/2);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                r=mid-1;
            } else {
                l=mid+1;
            }
        }
        return -1;
    }
}
