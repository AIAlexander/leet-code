package bfs;

import entity.TreeNode;
import sun.jvm.hotspot.debugger.Page;

import java.util.*;

/**
 * @author wsh
 * @date 2021-03-04
 */
public class BinaryTreeLevelOrderTraversalIINo107 {
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        if(root == null) {
            return result;
        }

        //初始化
        q.add(root);
        visited.add(root);

        //BFS
        while (!q.isEmpty()) {
            List<Integer> subResult = new ArrayList<>();
            int size = q.size();
            for(int i = 0; i < size; i++) {
                //获取q里的第一个元素
                TreeNode t = q.poll();
                visited.add(t);
                subResult.add(t.val);

                //遍历叶子节点
                if(t.left != null && !visited.contains(t.left)) {
                    visited.add(t.left);
                    q.add(t.left);
                }

                if(t.right != null && !visited.contains(t.right)) {
                    visited.add(t.right);
                    q.add(t.right);
                }
            }
            result.add(subResult);
        }
        Collections.reverse(result);
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

        System.out.println(levelOrderBottom(t1));
    }
}
