package org.algorithm.binSearch.L33.cp;

class cp1 {
    public int search(int[] nums, int target) {
        int min = 0, n = nums.length;
        for (int l = 1, r = n - 1; l <= r;) {
            int m = (l + r) / 2;
            if (nums[0] < nums[m]) l = m + 1;
            else { r = m - 1; min = m; }
        }
        for (int l = min, r = l + n - 1; l <= r;) {
            int m = (l + r) / 2, i = m % n;
            if (target < nums[i]) r = m - 1;
            else if (target > nums[i]) l = m + 1;
            else return i;
        }
        return -1;
    }
}