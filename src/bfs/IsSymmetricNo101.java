package bfs;

import entity.TreeNode;

import java.util.*;

/**
 * @author wsh
 * @date 2021-04-21
 */
public class IsSymmetricNo101 {

    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> set = new HashSet<>();
        queue.add(root);
        set.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> res = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode t = queue.poll();
                TreeNode tl = t.left;
                TreeNode tr = t.right;
                res.add(tl);
                res.add(tr);
                if(tl != null && !set.contains(tl)) {
                    queue.add(tl);
                    set.add(tl);
                }
                if(tr != null && !set.contains(tr)) {
                    queue.add(tr);
                    set.add(tr);
                }
            }
            for(int i = 0, j = res.size() - 1; j - i >= 1; i++, j--) {
                if(res.get(i) == null && res.get(j) == null) {
                    continue;
                }
                if(res.get(i) != null && res.get(j) == null) {
                    return false;
                }
                if(res.get(i) == null && res.get(j) != null) {
                    return false;
                }
                if(Integer.compare(res.get(i).val, res.get(j).val) != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsSymmetricNo101 s = new IsSymmetricNo101();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);

        root.right.right = new TreeNode(3);
        root.right.left = new TreeNode(5);

        System.out.println(s.isSymmetric(root));
    }
}
