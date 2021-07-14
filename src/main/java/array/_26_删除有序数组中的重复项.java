package array;

public class _26_删除有序数组中的重复项 {
    public int removeDuplicates(int[] nums) {
        int cur = 0;
        for (int num : nums) {
            if (num != nums[cur]) {
                nums[++cur] = num;
            }
        }
        return cur + 1;
    }
}
