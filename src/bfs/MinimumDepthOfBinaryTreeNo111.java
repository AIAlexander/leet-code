package bfs;

import entity.TreeNode;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author wsh
 * @date 2020-11-17
 *
 * 用BFS求解二叉树的最小高度
 *
 */
public class MinimumDepthOfBinaryTreeNo111 {

    public static int minDepth(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        q.add(root);
        visited.add(root);
        //遍历到root，树的高度是1
        int depth = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            //从第一个点向四周扩散
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                visited.add(cur);
                //表示已经到达叶子节点
                if(cur.left == null && cur.right == null) {
                    return depth;
                }
                //遍历相邻的节点
                if(cur.left != null && !visited.contains(cur.left)) {
                    visited.add(cur.left);
                    q.add(cur.left);
                }
                if(cur.right != null && !visited.contains(cur.right)) {
                    visited.add(cur.right);
                    q.add(cur.right);
                }
            }
            depth++;
        }
        return depth;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.left.left = new TreeNode(10);
        root.left.left.left = new TreeNode(13);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(minDepth(root));
    }
}
