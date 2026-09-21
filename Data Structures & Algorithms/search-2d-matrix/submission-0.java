class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        /*
            the approach with this problem is much simpler than its made out to be. we are essentially just applying a binary search to every row of the matrix.

            so we're just doing binary search on a bunch of arrays.

            a nice trick that might speed up run time a little bit is given in the 2nd bullet point in the problem statement.
            since we know the first integer of every row is greater thant he last integer of the previous row, we can use this
            to our advantage to help narrow down where the target value is.
            at each row we can check the right pointer (aka the end of the row) and if that value is less than the target, then we know we can
            skip the row entirely and go to the next row. once we reach a row where the last value is greater than the target, then we know the target
            is in that row and can then perform binary search on it. 

            time complexity: O(log(m*n))
            space complexity: O(1)\
        */
        for (int[] row : matrix) {
            if (row[row.length-1] < target) {
                System.out.println("skipping...");
                continue;
            }
            int l=0;
            int r=row.length-1;
            while (l<=r) {
                int mid = l + ((r-l)/2);
                if (row[mid] == target) {
                    return true;
                } else if (row[mid] < target) {
                    l=mid+1;
                } else {
                    r=mid-1;
                }
            }
        }
        return false;
    }
}
