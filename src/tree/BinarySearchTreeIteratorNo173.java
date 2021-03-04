package tree;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author wsh
 * @date 2021-03-03
 *
 * 二叉树迭代器
 */
public class BinarySearchTreeIteratorNo173 {

    private List<Integer> result = new ArrayList<>();
    private Integer index = 0;

    public BinarySearchTreeIteratorNo173(TreeNode root) {
        //二叉树可以通过中序遍历得到正确的顺序
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            TreeNode cur = stack.pop();
            result.add(cur.val);
            root = cur.right;
        }
    }

    public int next() {
        if(index >= result.size()) {
            return 0;
        }
        return result.get(index++);
    }

    public boolean hasNext() {
        if(index >= result.size()) {
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
//        TreeNode t2 = new TreeNode(3);
//        TreeNode t3 = new TreeNode(15);
//        TreeNode t4 = new TreeNode(9);
//        TreeNode t5 = new TreeNode(20);
//
//
//        t1.left = t2;
//        t1.right = t3;
//        t3.left = t4;
//        t3.right = t5;

        BinarySearchTreeIteratorNo173 b = new BinarySearchTreeIteratorNo173(t1);
        System.out.println(b.next());
        System.out.println(b.next());
        System.out.println(b.hasNext());
        System.out.println(b.next());
        System.out.println(b.next());
        System.out.println(b.next());
        System.out.println(b.hasNext());
    }


}
