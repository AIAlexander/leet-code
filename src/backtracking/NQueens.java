package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wsh
 * @date 2020-11-17
 *
 * 回溯算法解决N皇后问题
 *
 */
public class NQueens {

    public static List<List<String>> nQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        //初始化棋盘
        char[][] chessBoard = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chessBoard[i][j] = '.';
            }
        }
        //回溯
        backtrack(0, chessBoard, result);
        return result;
    }

    public static void backtrack(int row, char[][] chessBoard, List<List<String>> result) {
        //结束条件，每行都有皇后表示结束
        if(row == chessBoard.length) {
            result.add(buildResult(chessBoard));
            return;
        }
        //获取棋盘的宽度
        int width = chessBoard[row].length;
        for (int i = 0; i < width; i++) {
            //排除不合法的位置
            if(!valid(row, i, chessBoard)) {
                continue;
            }
            //做选择
            chessBoard[row][i] = 'Q';
            //进入下一个决策树
            backtrack(row + 1, chessBoard, result);
            //撤销选择
            chessBoard[row][i] = '.';
        }
    }

    public static boolean valid(int row, int col, char[][] chessBoard) {
        //判断垂直方向位置是否合法
        for(int i = 0; i < chessBoard.length; i++) {
            if('Q' == chessBoard[i][col]) {
                return false;
            }
        }
        //判断左上是否合法
        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; j--, i--) {
            if('Q' == chessBoard[i][j]) {
                return false;
            }
        }
        //判断右上是否合法
        for(int i = row - 1, j = col + 1; i >= 0 && j < chessBoard[i].length; i--, j++) {
            if('Q' == chessBoard[i][j]) {
                return false;
            }
        }
        return true;
    }

    public static List<String> buildResult(char[][] chessBoard) {
        List<String> subResult = new ArrayList<>();
        for (int i = 0; i < chessBoard.length; i++) {
            String a = "";
            for (int j = 0; j < chessBoard[i].length; j++) {
                a = a + chessBoard[i][j];
            }
            subResult.add(a);
        }
        return subResult;
    }



    public static void main(String[] args) {

        List<List<String>> result = nQueens(4);
        for (List<String> list : result) {
            for (String s : list) {
                System.out.println(s);
            }
            System.out.println();
        }
    }

}
