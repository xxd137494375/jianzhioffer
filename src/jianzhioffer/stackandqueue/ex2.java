package jianzhioffer.stackandqueue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;

public class ex2 {
    /**
     * 滑动窗口的最大值：
     * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
     * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么
     * 一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对
     * 数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}，
     * {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}，
     * {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
     */

    /**
     * 自己想的
     * @param num
     * @param size
     * @return
     */
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int start=0;
        int end=start+size-1;
        int len=num.length;
        int max=0;
        if(len==0||size==0){
            return list;    //注意特殊情况 len=0和size=0的时候，尤其是size=0 要充分考虑入参的特殊情况
        }
        while(end<=len-1){
            max=num[start];
            for(int i=start;i<=end;i++){
                if(num[i]>max){
                    max=num[i];
                }
            }
            list.add(max);
            start++;
            end++;
        }
        return list;
    }





    /**
     *
     * 思路：滑动窗口应当是队列，但为了得到滑动窗口的最大值，队列序可以从两端删除元素，因此使用双端队列。
     *  *     原则：
     *  *     对新来的元素k，将其与双端队列中的元素相比较
     *  *     1）前面比k小的，直接移出队列（因为不再可能成为后面滑动窗口的最大值了!）,
     *  *     2）前面比k大的X，比较两者下标，判断X是否已不在窗口之内，不在了，直接移出队列
     *  *     队列的第一个元素是滑动窗口中的最大值
     * @param num
     * @param size
     * @return
     */

    public ArrayList<Integer> maxInWindows2(int [] num, int size)
    {
        ArrayList<Integer> ret = new ArrayList<>();
        if (num == null) {
            return ret;
        }
        if (num.length < size || size < 1) {
            return ret;
        }

        LinkedList<Integer> indexDeque = new LinkedList<>();
        for (int i = 0; i < size - 1; i++) {
            while (!indexDeque.isEmpty() && num[i] > num[indexDeque.getLast()]) {
                indexDeque.removeLast();
            }
            indexDeque.addLast(i);   //把前size-1个元素最大的序号放到第一个位置
        }

        for (int i = size - 1; i < num.length; i++) {
            while (!indexDeque.isEmpty() && num[i] > num[indexDeque.getLast()]) {//对新来的元素k，将其与双端队列中的元素相比较
                indexDeque.removeLast();//前面比k小的，直接移出队列（因为不再可能成为后面滑动窗口的最大值了!）  这一步是为了把以后都不可能成为最大值的移除
            }
            indexDeque.addLast(i);
            if (i - indexDeque.getFirst() + 1 > size) {  //前面比k大的X，比较两者下标，判断X是否已不在窗口之内，不在了，直接移出队列
                indexDeque.removeFirst();
            }
            ret.add(num[indexDeque.getFirst()]);//队列的第一个元素是滑动窗口中的最大值
        }
        return ret;
    }
}
