package jianzhioffer.array;

public class ex4 {
    /*
        数组在排序数组中出现的次数

        统计一个数字在排序数组中出现的次数
     */

    /**
     * 自己的想法，但是要注意到所有情况
     * @param array
     * @param k
     * @return
     */
    public int GetNumberOfK(int [] array , int k) {
        int start=-1;//不能设为0，避免第一个数就是k
        int end =-1;
        for (int i=0;i<array.length;i++){
            if(array[i]==k){
                start = i;
                i=array.length;
            }
        }
        if(start==-1){//代表数组中没有k
            return 0;
        }
        for(int i=start;i<array.length;i++){
            if(array[i]>k){
                end=i;
                i=array.length;
            }
        }
        if(end==-1){//代表一直到数组最后都是k
            end=array.length;
        }
        int result = end - start;
        return result;
    }
}
