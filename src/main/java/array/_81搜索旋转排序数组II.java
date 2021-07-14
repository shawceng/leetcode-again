package array;

public class _81搜索旋转排序数组II {
    public boolean search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    boolean search(int[] nums, int target, int from, int to) {
        if (from == to) return nums[from] == target;
        int mid = from + (to - from) / 2;
        if (nums[from] < nums[to] && (nums[from] > target && nums[to] < target)) {
            return false;
        }
        return search(nums, target, from, mid) || search(nums, target, mid + 1, to);
    }
}
