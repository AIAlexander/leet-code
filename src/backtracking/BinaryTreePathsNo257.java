package backtracking;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wsh
 * @date 2021-03-24
 */
public class BinaryTreePathsNo257 {


    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        List<List<Integer>> subResult = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();
        track.add(root.val);
        backtrack(root, track, subResult);
        subResult.forEach(s -> {
            System.out.println(s);
        });
        return result;
    }

    private void backtrack(TreeNode root, LinkedList<Integer> track, List<List<Integer>> result) {
        if(root.left == null && root.right == null) {
            result.add(new LinkedList<>(track));
            return;
        }

        //选择的列表为 root.left 和 root.right
        while(root.left != null) {
            if(track.contains(root.left.val)) {
                break;
            }
            track.add(root.left.val);
            backtrack(root.left, track, result);
            track.removeLast();
        }

        while (root.right != null) {
            if(track.contains(root.right.val)) {
                break;
            }
            track.add(root.right.val);
            backtrack(root.right, track, result);
            track.removeLast();
        }

    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(5);


        t1.left = t2;
        t1.right = t3;
        t2.right = t4;

        BinaryTreePathsNo257 s = new BinaryTreePathsNo257();
        s.binaryTreePaths(t1);
    }
}
