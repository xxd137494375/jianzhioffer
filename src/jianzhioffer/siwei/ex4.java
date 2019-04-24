package jianzhioffer.siwei;

import java.util.ArrayList;

public class ex4 {
    /*
        和为S的连续序列

        小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,
        他马上就写出了正确答案是100。但是他并不满足于此,他在想究
        竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久
        ,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现
        在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!

        输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
     */

    /**
     * 自己想的，一次成功
     * @param sum
     * @return
     */
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (sum<=0){
            return result;
        }
        int count;
        int i,j;
        for(i=1;i<sum;i++){
            count=i;
            ArrayList<Integer> list = new ArrayList<>();
            list.add(i);
            for (j=i+1;j<sum;j++){
                count+=j;
                list.add(j);
                if(count==sum){
                    result.add(list);
                    break;
                }
                if(count>sum){
                    break;
                }
            }
        }
        return result;
    }


    /**
     * 太好了
     *
     * 在答案区找到一个答案，说的很好，叫做双指针技术，就是相当于有一个窗口，窗口的左
     * 右两边就是两个指针，我们根据窗口内值之和来确定窗口的位置和宽度。非常牛逼的思路
     * ，虽然双指针或者所谓的滑动窗口技巧还是蛮常见的，但是这一题还真想不到这个思路。
     * @param sum
     * @return
     */
    public ArrayList<ArrayList<Integer> > FindContinuousSequence1(int sum) {
        //存放结果
        ArrayList<ArrayList<Integer> > result = new ArrayList<>();
        //两个起点，相当于动态窗口的两边，根据其窗口内的值的和来确定窗口的位置和大小
        int plow = 1,phigh = 2;
        while(phigh > plow){
            //由于是连续的，差为1的一个序列，那么求和公式是(a0+an)*n/2
            int cur = (phigh + plow) * (phigh - plow + 1) / 2;
            //相等，那么就将窗口范围的所有数添加进结果集
            if(cur == sum){
                ArrayList<Integer> list = new ArrayList<>();
                for(int i=plow;i<=phigh;i++){
                    list.add(i);
                }
                result.add(list);
                plow++;
                //如果当前窗口内的值之和小于sum，那么右边窗口右移一下
            }else if(cur < sum){
                phigh++;
            }else{
                //如果当前窗口内的值之和大于sum，那么左边窗口右移一下
                plow++;
            }
        }
        return result;
    }
}

