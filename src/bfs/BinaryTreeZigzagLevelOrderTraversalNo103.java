package bfs;

import entity.TreeNode;

import java.util.*;

/**
 * @author wsh
 * @date 2021-03-04
 */
public class BinaryTreeZigzagLevelOrderTraversalNo103 {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        Queue<TreeNode> q = new LinkedList<>();
        //记录已访问过的节点
        Set<TreeNode> visited = new HashSet<>();
        //初始化
        q.add(root);
        //数组结果倒序标志位
        int reverseFlag = 0;

        //BFS
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> subResult = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                visited.add(node);
                subResult.add(node.val);

                //遍历叶子节点
                if(node.left != null && !visited.contains(node.left)) {
                    visited.add(node.left);
                    q.add(node.left);
                }

                if(node.right != null && !visited.contains(node.right)) {
                    visited.add(node.right);
                    q.add(node.right);
                }
            }
            //每遍历一层就倒序一次
            if(reverseFlag % 2 == 1) {
                Collections.reverse(subResult);
            }
            result.add(subResult);
            reverseFlag++;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(20);
        TreeNode t4 = new TreeNode(15);
        TreeNode t5 = new TreeNode(7);

        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        t3.right = t5;

        System.out.println(zigzagLevelOrder(t1));
    }
}
