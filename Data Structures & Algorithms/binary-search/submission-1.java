class Solution {
    public int search(int[] nums, int target) {
        /*
            for binary search remember conditionals for what halves to eliminate:
                if (nums[mid] < target) we get rid of the LEFT side, moving the LEFT pointer to the middle.
                if (nums[mid] > target) we get rid of RIGHT side, moving RIGHT pointer to middle.
        */
        int l = 0;
        int r = nums.length-1;
        while (l<=r) {
            int m = l + ((r-l)/2);
            if (nums[m] < target) {
                l=m+1;
            } else if (nums[m] > target) {
                r=m-1;
            } else {
                return m;
            }
        }
        return -1;
    }
}
