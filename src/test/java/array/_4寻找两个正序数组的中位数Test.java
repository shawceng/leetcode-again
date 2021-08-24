package array;

import array._4寻找两个正序数组的中位数;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class _4寻找两个正序数组的中位数Test {
    @Test
    void test() {
        _4寻找两个正序数组的中位数 solution = new _4寻找两个正序数组的中位数();
        Assertions.assertEquals(solution.findKth(new int[]{}, new int[]{1}, 0, 1, 1), 1);
        Assertions.assertEquals(solution.findKth(new int[]{1, 2}, new int[]{1, 1}, 2, 2, 1), 1);
        Assertions.assertEquals(solution.findKth(new int[]{1, 2}, new int[]{1, 1}, 2, 2, 2), 1);
        Assertions.assertEquals(solution.findKth(new int[]{1, 2}, new int[]{1, 1}, 2, 2, 3), 1);
        Assertions.assertEquals(solution.findKth(new int[]{1, 2, 3}, new int[]{3, 5}, 3, 2, 3), 3);
        Assertions.assertEquals(solution.findKth(new int[]{1, 2, 3}, new int[]{3, 5}, 3, 2, 5), 5);
    }
}
