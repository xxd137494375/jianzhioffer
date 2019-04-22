package jianzhioffer.array;

public class ex6 {
    /*
        调正数组顺序使奇数位于偶数前面

        输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
        使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后
        半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
     */
    public void reOrderArray(int[] array) {
        int len = array.length;
        int[] a = new int[len];
        int index = 0;
        for (int i = 0; i < len; i++) {
            if (array[i] % 2 == 1) {
                a[index] = array[i];
                index++;
            }
        }
        for (int i = 0; i < len; i++) {
            if (array[i] % 2 == 0) {
                a[index] = array[i];
                index++;
            }
        }
        for (int i = 0; i < len; i++) {
            array[i] = a[i];
        }
    }

    /**
     * 大神： 排序的就会想到排序算法
     * @param array
     */
    public void reOrderArray1(int[] array) {
        boolean flag=true;
        for (int i = 0; i < array.length&&flag; i++) {
            flag=false;
            for (int j = array.length - 1; j > i; j--) {
                if (array[j] % 2 == 1 && array[j - 1] % 2 == 0) //前偶后奇交换
                {   flag=true;
                    int temp = array[j];
                    array[j]=array[j-1];
                    array[j-1]=temp;
                }
            }
        }
    }
}
