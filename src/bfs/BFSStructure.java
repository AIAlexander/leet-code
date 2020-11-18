package bfs;

import java.util.Queue;

/**
 * @author wsh
 * @date 2020-11-17
 */
public class BFSStructure {

//    public int BFS(Node start, Node target) {
//        //队列是解决BFS的核心
//        Queue<Node> q;
//        //记录已经走过的点
//        Set<Node> visited;
//        //初始点初始化
//        q.add(start);
//        visited.add(start);
//        //记录步数
//        int step = 0;
//
//        while(q.size() > 0) {
//            //从队列中取出节点向四周扩散
//            for(int i = 0; i < q.size(); i++) {
//                Node cur = q.poll();
//                //这里判断是不是到达终点
//                if(cur is target) {
//                    return step;
//                }
//                //将cur的相邻节点加入队列
//                for(Node x : cur.adj()) {
//                    if(x not in visited) {
//                        q.add(x);
//                        visited.add(x);
//                    }
//                }
//            }
//            //更新步数
//            step++;
//        }
//    }
}
