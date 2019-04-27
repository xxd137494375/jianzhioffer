package jianzhioffer.array;

import java.util.ArrayList;

/**
 * @Author ：xingxiangdong
 * @Date :2019/4/2614:25
 */
public class ex9 {
    /*
        顺时针打印矩阵

        输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
        ，例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
        1  2  3  4
        5  6  7  8
        9  10 11 12
        13 14 15 16
        则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
     */

    /**
     * 自己想的暴力循环不过和正确答案差不多，用递归
     *
     * @param matrix
     * @return
     */
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        if (matrix == null) {
            return null;
        }
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        for (int col = 0; col < colLen; col++) {
            result.add(matrix[0][col]);
        }
        for (int row = 1; row < rowLen; row++) {
            result.add(matrix[row][colLen - 1]);
        }
        for (int col = colLen - 2; rowLen > 1 && col >= 0; col--) {//注意条件，避免重复
            result.add(matrix[rowLen - 1][col]);

        }
        for (int row = rowLen - 2; colLen > 1 && row > 0; row--) {
            result.add(matrix[row][0]);
        }
        if (rowLen > 2 && colLen > 2) {
            int[][] a = new int[rowLen - 2][colLen - 2];
            for (int i = 0; i < rowLen - 2; i++) {
                for (int j = 0; j < colLen - 2; j++) {
                    a[i][j] = matrix[i + 1][j + 1];
                }
            }
            ArrayList<Integer> list = printMatrix(a);
            result.addAll(list);
        }
        return result;
    }


    /**
     * 递归换循环
     *
     * @param matrix
     * @return
     */
    public ArrayList<Integer> printMatrix1(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        int row = matrix.length;
        int col = matrix[0].length;
        // 输入的二维数组非法，返回空的数组
        if (row == 0 || col == 0)  return result;

        // 定义四个关键变量，表示左上和右下的打印范围
        int left = 0, top = 0, right = col - 1, bottom = row - 1;
        while (left <= right && top <= bottom)
        {
            // left to right
            for (int i = left; i <= right; ++i) result.add(matrix[top][i]);
            // top to bottom
            for (int i = top + 1; i <= bottom; ++i)  result.add(matrix[i][right]);
            // right to left
            if (top != bottom)//多于1行
                for (int i = right - 1; i >= left; --i)  result.add(matrix[bottom][i]);
            // bottom to top
            if (left != right)//多于1列
                for (int i = bottom - 1; i > top; --i)  result.add(matrix[i][left]);
            left++;
            top++;
            right--;
            bottom--;
        }
        return result;
    }


    public static void main(String[] args) {
        int[][] a = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
        ex9 e = new ex9();
        System.out.println(e.printMatrix1(a));
    }
}
