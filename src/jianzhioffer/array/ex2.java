package jianzhioffer.array;

public class ex2 {
    /*
     * 构建乘积数组
     *
     * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
     */
    /**
     *
     * @param A
     * @return
     */

    public int[] multiply(int[] A) {
        if(A==null||A.length==0)
            return A;
        int[] left = new int[A.length];//记录除了自己，左边的乘积
        int[] right = new int[A.length];//记录除了自己，右边的乘积
        right[A.length-1] = 1;//构建右边的乘积
        for(int i = A.length-2;i>=0;i--){
            right[i] = right[i+1]*A[i+1];
        }
        left[0] = 1;//构建左边的乘积
        for(int i = 1;i<A.length;i++){
            left[i] = left[i-1]*A[i-1];
        }
        //计算乘积数组
        int[] B = new int[A.length];
        for(int i = 0;i<A.length;i++){
            B[i] = left[i]*right[i];
        }
        return B;
    }
}
