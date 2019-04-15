/*
Accepted	3 ms	47.8 MB	java
*/


class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 != null && nums2 != null) {
            int[] nums3 = new int[nums1.length + nums2.length];
            System.arraycopy(nums1, 0, nums3, 0, nums1.length);
            System.arraycopy(nums2, 0, nums3, nums1.length, nums2.length);
            Arrays.sort(nums3);
            return getMed(nums3);
        } else {
            if (nums1 == null) {
                return getMed(nums2);
            } else {
                return getMed(nums1);
            }
        }
    }
    
    private double getMed(int[] nums3)
    {
        if (nums3.length % 2 == 0) {
            int m = nums3.length / 2;
            int m1 = nums3[m];
            int m2 = nums3[m - 1];
            return (double) (m1 + m2) / 2;
        } else {
            return nums3[nums3.length / 2];
        }
    }
}
