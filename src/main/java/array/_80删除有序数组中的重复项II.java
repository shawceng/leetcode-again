package array;

public class _80删除有序数组中的重复项II {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;
        int cur = Math.min(nums.length, 2);
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[cur - 2]) {
                nums[cur++] = nums[i];
            }
        }
        return cur;
    }
}
