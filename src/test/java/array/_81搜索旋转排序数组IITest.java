package array;

import array._81搜索旋转排序数组II;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class _81搜索旋转排序数组IITest {
    @Test
    void searchTest() {
        _81搜索旋转排序数组II solution = new _81搜索旋转排序数组II();
        assertTrue(solution.search(new int[]{2, 5, 6, 0, 0, 1, 2}, 0));
        assertFalse(solution.search(new int[]{2, 5, 6, 0, 0, 1, 2}, 3));
    }

}
