package array;

public class _33搜索旋转排序数组 {
    public int search(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }

    int search(int[] nums, int from, int to, int target) {
        if (from >= to) return nums[from] == target ? from : -1;
        int mid = from + (to - from) / 2;
        if (nums[from] < nums[to] && (nums[from] > target || nums[to] < target)) return -1;
        return Math.max(search(nums, from, mid, target), search(nums, mid + 1, to, target));
    }

}
