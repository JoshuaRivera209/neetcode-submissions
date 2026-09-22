class Solution {
    public int findMin(int[] nums) {
        /*
            the approach with this problem is to perform a binary search with specific conditions that allow us to search the
            rotated array directly.

            we can do this based on the fact that we know whenever an array is sorted, everything to the left of the 
            minimum value (the pivot) will be GREATER than everything on the right.

            we can use this to think of the array as 2 subarrays that are each sorted. when we perform our binary search,
            the condition will evaluate if the middle value is in the left or the right sorted section of the array, and that will determine
            what side of the array we search.

            if the value is in the left sorted portion of the array we'll search the right, and vice versa.

            since this method only works on rotated sorted arrays, if we get to a section of the array that IS sorted, then we can just check the value of the left pointer
            against the current result value and update accordingly for a new minimum value.

            ex: Input: nums = [3,4,5,6,1,2]

            say l=3
                r=2
                m=5
            we want to see, is m > l? it is, so, we want to search the right
        */

        int l=0;
        int r=nums.length-1;
        int res=nums[0];
        while (l<=r) {
            if (nums[l] < nums[r]) {
                res = Math.min(res, nums[l]);
                break;
            }
            int mid = l + (r-l)/2;
            res = Math.min(res, nums[mid]);
            if (nums[mid] >= nums[l]) {
                l=mid+1;
            } else {
                r=mid-1;
            }
        }
        return res;
    }
}
