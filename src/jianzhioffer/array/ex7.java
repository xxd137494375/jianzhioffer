package jianzhioffer.array;

public class ex7 {
    /*
        数组中出现次数超过一半的数字

        数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
        例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数
        组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
     */

    /**
     * 自己想的
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution(int[] array) {
        int result = 0;
        int len = array.length;
        int index = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (array[j] == array[i]) {
                    index++;
                    if (index > len / 2) {
                        return array[i];
                    }
                }
            }
            index = 0;
        }
        return result;
    }

}
