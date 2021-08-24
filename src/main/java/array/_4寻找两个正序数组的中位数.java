package array;

public class _4寻找两个正序数组的中位数 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if ((m + n) % 2 == 0)
            return (findKth(nums1, nums2, m, n, (m + n) / 2) +
                    findKth(nums1, nums2, m, n, (m + n) / 2 + 1)) / 2.0;
        else
            return findKth(nums1, nums2, m, n, (m + n) / 2);

    }

    public double findKth(int[] nums1, int[] nums2, int m, int n, int k) {
        if (n > m) return findKth(nums2, nums1, n, m, k);
        if (n == 0) return nums1[nums1.length - m + k - 1];
        if (k == 1) return Math.min(nums1[nums1.length - m], nums2[nums2.length - n]);
        int ni = Math.min(k / 2, n);
        int mi = k - ni;

        if (nums1[nums1.length - m + mi - 1] < nums2[nums2.length - n + ni - 1]) {
            return findKth(nums1, nums2, m - mi, n, k - mi);
        } else if (nums1[nums1.length - m + mi - 1] > nums2[nums2.length - n + ni - 1]) {
            return findKth(nums1, nums2, m, n - ni, k - ni);
        } else {
            return nums1[nums1.length - m + mi - 1];
        }
    }
}
