package tree;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author wsh
 * @date 2021-03-04
 */
public class ValidateBinarySearchTreeNo98 {
    public static boolean isValidBST(TreeNode root) {
        Stack<TreeNode> res = new Stack<>();
        Stack<TreeNode> s = new Stack<>();
        while (root != null || !s.isEmpty()) {
            while (root != null) {
                s.add(root);
                root = root.left;
            }
            TreeNode t = s.pop();
            if(res.size() > 0 && t.val < res.peek().val) {
                return false;
            }
            res.add(t);
            root = t.right;
        }

        return true;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(3);
//        TreeNode t4 = new TreeNode(3);
//        TreeNode t5 = new TreeNode(6);

        t1.left = t2;
        t1.right = t3;
//        t3.left = t4;
//        t3.right = t5;

        System.out.println(isValidBST(t1));
    }
}
