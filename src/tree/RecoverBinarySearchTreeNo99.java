package tree;

import entity.TreeNode;

import java.util.Stack;

/**
 * @author wsh
 * @date 2021-03-04
 *
 * 纠正二叉树的规律
 * 中序遍历得到的是正确的顺序表明是一颗二叉树
 * 因此只要把不符合规律的数字换一个位置即可
 * 比如：【4，2，3，1】，只需换4和1就行
 * 规律：第一个节点就是前一个节点大于后一个节点，取前一个节点并缓存下来
 *      第二个节点就是前一个节点大于后一个节点，取后一个节点并缓存下来，
 *      将两个值互换
 *      因此在处理的时候，需要每次记录上一个节点，比较上一个节点与当前节点的大小，是第一次就缓存上一个节点，不是第一次就缓存当前节点
 *
 */
public class RecoverBinarySearchTreeNo99 {
    public static void recoverTree(TreeNode root) {
        //结果集
        Stack<TreeNode> res = new Stack<>();
        //辅助工具
        Stack<TreeNode> s = new Stack<>();
        TreeNode firstNode = null;
        TreeNode secondNode = null;
        TreeNode pre = new TreeNode(Integer.MIN_VALUE);
        TreeNode p = root;
        while(p != null || !s.isEmpty()) {
            while (p != null) {
                s.add(p);
                p = p.left;
            }
            p = s.pop();
            //第一个有问题的点，前一个节点大于后一个节点，取前一个节点并缓存下来
            if (firstNode == null && pre.val > p.val) firstNode = pre;
            //第二个有问题的点，前一个节点大于后一个节点，取当前节点并缓存下来
            if (firstNode != null && pre.val > p.val) secondNode = p;
            //每次出栈的时候更新上一个节点
            pre = p;
            res.add(p);
            p = p.right;
        }
        //交换数值
        int tmp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = tmp;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(2);

        t1.left = t2;
        t2.right = t3;

        recoverTree(t1);

        System.out.println(t1.val);
    }
}
