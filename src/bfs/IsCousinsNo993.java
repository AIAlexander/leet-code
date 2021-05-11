package bfs;

import entity.TreeNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author wsh
 * @date 2021-04-21
 */
public class IsCousinsNo993 {

    public boolean isCousins(TreeNode root, int x, int y) {
        int xParent = 0;
        int xDepth = 0;
        int yParent = 0;
        int yDepth = 0;

        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> s = new HashSet<>();
        //初始化
        q.add(root);
        s.add(root);
        int depth = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if(cur.left != null && !s.contains(cur.left)) {
                    if(cur.left.val == x) {
                        xParent = cur.val;
                        xDepth = depth;
                    }
                    if(cur.left.val == y) {
                        yParent = cur.val;
                        yDepth = depth;
                    }
                    q.add(cur.left);
                    s.add(cur.left);
                }

                if(cur.right != null && !s.contains(cur.right)) {
                    if(cur.right.val == x) {
                        xParent = cur.val;
                        xDepth = depth;
                    }
                    if(cur.right.val == y) {
                        yParent = cur.val;
                        yDepth = depth;
                    }
                    q.add(cur.right);
                    s.add(cur.right);
                }
            }
            depth++;
        }

        if(xParent == 0 || yParent == 0) {
            return false;
        }

        if(xDepth == yDepth && xParent != yParent) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        IsCousinsNo993 s = new IsCousinsNo993();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        System.out.println(s.isCousins(t1, 1, 2));
    }
}
