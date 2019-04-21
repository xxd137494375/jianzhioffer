package jianzhioffer.siwei;

import java.util.ArrayList;

public class ex3 {
    /*
        和为S的两个数字

        输入一个递增排序的数组和一个数字S，在数组中查找两个数，使
        得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
     */

    /**
     * 自己想的
     * @param array
     * @param sum
     * @return
     */
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        int len = array.length;
        ArrayList<Integer> list = new ArrayList<>();
        if (len == 0) {
            return list;
        }
        int i = 0;
        int j = 0;
        for (; i < len; i++) {
            for (j = i; j < len; j++) {
                if (array[i] + array[j] == sum && list.isEmpty()) {
                    list.add(array[i]);
                    list.add(array[j]);
                    list.add(array[i] * array[j]);
                }
                if (array[i] + array[j] == sum && list.size() == 3 && array[i] * array[j] < list.get(2)) {
                    list.add(array[i]);
                    list.add(array[j]);
                    list.add(array[i] * array[j]);
                }
            }
        }
        if (list.isEmpty()) {
            return list;
        }
        list.remove(2);
        return list;
    }


    /**
     * 假设：若b>a,且存在，
     * a + b = s;
     *  设m>0
     * (a - m ) + (b + m) = s
     * 则：(a - m )(b + m)=ab - (b-a)m - m*m < ab；说明外层的乘积更小
     * 也就是说依然是左右夹逼法！！！只需要2个指针
     * 1.left开头，right指向结尾
     * 2.如果和小于sum，说明太小了，left右移寻找更大的数
     * 3.如果和大于sum，说明太大了，right左移寻找更小的数
     * 4.和相等，把left和right的数返回
     * @param array
     * @param sum
     * @return
     */
    public ArrayList<Integer> FindNumbersWithSum1(int[] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        if (array == null || array.length == 0)
            return list;
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int total = array[left] + array[right];
            if (total == sum) {
                list.add(array[left]);
                list.add(array[right]);
                return list;
            } else if (total > sum) {
                //大于sum，说明太大了，right左移寻找更小的数
                --right;
            } else {
                //2.如果和小于sum，说明太小了，left右移寻找更大的数
                ++left;
            }
        }
        return list;
    }
}
