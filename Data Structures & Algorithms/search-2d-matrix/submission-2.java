class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        /*
            general idea: do binary search on each row of the array
            - enhanced loop on the matrix, doing binary search on each row
            - because the matrix reads in non decreasing order like a book (left-right)
            we can skip rows to get to the one that has the target
            - we can do this by simply checking the last number in the row, and if that number
            is greater than the target then we know the target is in that particular row
            - once we find the correct row we just binary search the target on that row
        */

        for (int[] row : matrix) {
            if (row[row.length-1] < target) {
                continue;
            }
            int l = 0, r = row.length-1;
            while (l<=r) {
                int m = l + ((r-l) / 2);
                if (row[m] == target) {
                    return true;
                } else if (row[m] < target) {
                    l=m+1;
                } else {
                    r=m-1;
                }
            }
        }
        return false;
    }
}
