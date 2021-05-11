package tree;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author wsh
 * @date 2021-03-03
 *
 *  树的中序遍历 左 根 右
 *  *
 *  *                1
 *  *              /  \
 *  *             2    5
 *  *            / \  / \
 *  *           3  4 6   7
 *  *             / \
 *  *            9   8
 *  329481657
 */
public class InorderTraversal {

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

        List<TreeNode> result = postOrderTraversal(t1);
        result.forEach(r -> {
            System.out.print(r.val);
        });

        System.out.println("------------------------");
        postOrder(t1);
    }

    public static List<TreeNode> postOrderTraversal(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();

        while (root != null || !s.isEmpty()) {
            while (root != null) {
                s.push(root);
                root = root.left;
            }

            TreeNode t = s.pop();
            result.add(t);
            root = t.right;
        }

        return result;
    }

    public static void postOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        postOrder(root.left);
        System.out.print(root.val);
        postOrder(root.right);
    }
}
