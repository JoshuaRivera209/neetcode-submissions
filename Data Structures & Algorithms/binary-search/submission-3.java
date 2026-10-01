class Solution {
    public int search(int[] nums, int target) {
        /*
            conditions:
                if (nums[m] < target) -> throw away left side of array
                if (nums[m] > target) -> throw away right side of array
        */
        int l=0, r=nums.length-1;
        while (l<=r) {
            int m = l + ((r-l) / 2);
            if (nums[m] == target) {
                return m;
            } else if (nums[m] < target) {
                l=m+1;
            } else {
                r=m-1;
            }
        }
        return -1;
    }
}
