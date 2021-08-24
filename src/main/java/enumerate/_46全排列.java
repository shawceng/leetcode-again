package enumerate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _46全排列 {
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> t = new ArrayList<>();
        Arrays.stream(nums).forEach(e -> t.add(e));

        dfs(res, t, 0);
        return res;
    }

    void dfs(List<List<Integer>> res, List<Integer> nums, int k) {
        if (k == nums.size() - 1) {
            res.add(new ArrayList<>(nums));
        }
        for (int i = k; i < nums.size(); i++) {
            swap(nums, k, i);
            dfs(res, nums, k + 1);
            swap(nums, k, i);
        }
    }

    void swap(List<Integer> nums, int from, int to) {
        int v = nums.get(from);
        nums.set(from, nums.get(to));
        nums.set(to, v);
    }
}
