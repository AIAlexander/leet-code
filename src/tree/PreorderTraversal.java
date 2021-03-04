package tree;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author wsh
 * @date 2021-03-03
 *
 * 树的前序遍历 根 左 右
 *
 * *                1
 *  *              /  \
 *  *             2    5
 *  *            / \  / \
 *  *           3  4 6   7
 *  *             / \
 *  *            9   8
 */
public class PreorderTraversal {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(5);
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(4);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(9);
        TreeNode t9 = new TreeNode(8);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t5.left = t8;
        t5.right = t9;
        t3.left = t6;
        t3.right = t7;

        List<TreeNode> result = preOrderTraversal(t1);
        result.forEach(r -> {
            System.out.print(r.val);
        });
    }

    public static List<TreeNode> preOrderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<TreeNode> result = new ArrayList<>();

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                result.add(root);
                root = root.left;
            }

            TreeNode t = stack.pop();
            root = t.right;
        }

        return result;
    }


}
