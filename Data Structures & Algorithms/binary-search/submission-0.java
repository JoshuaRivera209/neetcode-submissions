class Solution {
    public int search(int[] nums, int target) {
        /*

            - input array is sorted in ascending order and fully distinct
            - we want to find the target value
            - solution must be O(logn)
            approach: 
                - we want to use a binary search
                - we do this by using 3 pointers. left, right, and a middle pointer. the middle pointer is determined by adding the left and right pointer positions, then dividing by 2 to get the midpoint of the array.
                - we check the value of the middle pointer, and if nums[mid] > target, then we know everything to the right of it is greater as well.
                - so we move the right pointer to the position of the middle, and then recalculate the middle position.
                - on the other hand, if nums[mid] < target, we know everything to the left of the midpoint is less than the target, so we shift the left pointer forward to the middle position and recalculate.
                - repeat this process until middle == target, then return the value.
                - to account for edge cases, we need to make sure that there is a condition that makes this loop exit once the search completes in the event that the target was not found.
        */
        int l = 0;
        int r = nums.length-1;
        while (l<=r) {
            int mid = l + ((r-l) / 2);
            if (nums[mid] < target) {
                l=mid+1;
            } else if (nums[mid] > target) {
                r=mid-1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
