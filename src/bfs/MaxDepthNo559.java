package bfs;

import entity.Node;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author wsh
 * @date 2021-04-21
 */
public class MaxDepthNo559 {

    public int maxDepth(Node root) {
        if(root == null) {
            return 0;
        }
        if(root.children == null || root.children.size() == 0) {
            return 1;
        }
        Queue<Node> q = new LinkedList<>();
        Set<Node> s = new HashSet<>();
        //初始化
        q.add(root);
        s.add(root);
        int depth = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                Node cur = q.poll();
                for (Node child : cur.children) {
                    if(child != null && !s.contains(child)) {
                        q.add(child);
                        s.add(child);
                    }
                }
            }
            depth++;
        }
        return depth;
    }


    public static void main(String[] args) {


    }

}
