package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _94二叉树的中序遍历 {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        stack.push(root);

        TreeNode p = root.left;
        while (!stack.isEmpty() || p != null) {
            if (p == null) {
                p = stack.pop();
                res.add(p.val);
                p = p.right;
            } else {
                stack.push(p);
                p = p.left;
            }
        }
        return res;
    }
}
