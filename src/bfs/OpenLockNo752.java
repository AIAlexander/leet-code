package bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author wsh
 * @date 2020-11-18
 *
 * 使用BFS来开锁，一共4个转盘
 *
 */
public class OpenLockNo752 {

    public static int openLock(String[] deadends, String target) {
        Queue<String> q =  new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Set<String> dead = new HashSet<>();
        //把死亡数字放到visited中
        for (String deadend : deadends) {
            dead.add(deadend);
        }
        //初始化
        int time = 0;
        q.add("0000");
        if(dead.contains("0000")) {
            return -1;
        }
        visited.add("0000");
        while (!q.isEmpty()) {
            //从第一个点开始扩散
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                //如果找到了就返回次数
                if(cur.equals(target)) {
                    return time;
                }
                //如果遍历到已有的内容或者是死亡数字就继续寻找
                if(dead.contains(cur)) {
                    continue;
                }

                //寻找临近的密码,密码有四个轮盘, j表示转动第几个轮盘
                for (int j = 0; j < 4; j++) {
                    //向上转
                    String upPass = up(cur, j);
                    if(!visited.contains(upPass)) {
                        visited.add(upPass);
                        q.add(upPass);
                    }
                    //向下转
                    String downPass = down(cur, j);
                    if(!visited.contains(downPass)) {
                        visited.add(downPass);
                        q.add(downPass);
                    }
                }
            }
            time++;
        }
        return -1;
    }

    public static String up(String cur, int j) {
        char[] curChar = cur.toCharArray();
        if(curChar[j] == '0') {
            curChar[j] = '9';
        }else {
            int num = Integer.parseInt(String.valueOf(curChar[j])) - 1;
            curChar[j] = Character.forDigit(num, 10);
        }
        return String.valueOf(curChar);
    }

    public static String down(String cur, int j) {
        char[] curChar = cur.toCharArray();
        if(curChar[j] == '9') {
            curChar[j] = '0';
        }else {
            int num = Integer.parseInt(String.valueOf(curChar[j])) + 1;
            curChar[j] = Character.forDigit(num, 10);
        }
        return String.valueOf(curChar);
    }

    public static void main(String[] args) {
        String[] deadends = new String[]{"0201","0101","0102","1212","2002"};
        String target = "0202";
        System.out.println(openLock(deadends, target));
    }
}
