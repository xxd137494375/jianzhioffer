package jianzhioffer.array;

public class ex3 {
    /**
     *
     * 二维数组中的查找
     *
     * 在一个二维数组中（每个一维数组的长度相同
     * ），每一行都按照从左到右递增的顺序排序，
     * 每一列都按照从上到下递增的顺序排序。请完
     * 成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     */

    /**
     * 找一个位置是只有两种结果哦的
     * @param target
     * @param array
     * @return
     */
    public boolean Find(int target, int [][] array) {
        int len = array[0].length;
        if(len==0){
            return false;
        }
        int row=0;
        int col = len - 1;
        for (;row < len && col >= 0 ;){
            if(target == array[row][col]){
                return true;
            }
            else if(target < array[row][col]){
                col--;
            }
            else{
                row++;
            }
        }
        return false;
    }
}
