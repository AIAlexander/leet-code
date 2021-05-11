package bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wsh
 * @date 2021-04-21
 */
public class NumIslandsNo200 {

    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                //找到陆地，就通过BFS走
                if(grid[i][j] == '1') {
                    bfs(grid, i, j);
                    count++;
                }

            }
        }
        return count;
    }

    public void bfs(char[][] grid, int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                int[] cur = q.poll();
                int i = cur[0];
                int j = cur[1];
                //如果当前的节点是陆地
                if(grid[i][j] == '1') {
                    //就向下走，不能超过边界
                    if(i + 1 < grid.length) {
                        q.add(new int[]{i + 1, j});
                    }
                    //向上走
                    if(i > 0) {
                        q.add(new int[]{i - 1, j});
                    }
                    //向左走
                    if(j > 0) {
                        q.add(new int[]{i, j - 1});
                    }
                    //向右走
                    if(j + 1 < grid[0].length) {
                        q.add(new int[]{i, j + 1});
                    }
                    //将当前走过的地方变成0，防止重复计数
                    grid[i][j] = '0';
                }
            }
        }
    }
    public static void main(String[] args) {
        NumIslandsNo200 s = new NumIslandsNo200();
        char[][] grid = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        System.out.println(s.numIslands(grid));
    }
}
