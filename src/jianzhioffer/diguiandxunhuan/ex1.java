package jianzhioffer.diguiandxunhuan;

public class ex1 {
    /*
     *  斐波那契数列
     *
     * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
     * n<=39
     *
     * 递归法
     * @param n
     * @return
     */
    public int Fibonacci(int n) {
        if(n>39){
            return 1;
        }
        if(n==0){
            return 0;
        }
        else if(n==1){
            return 1;
        }
        else{
            return Fibonacci(n-1)+Fibonacci(n-2);
        }

    }

    /**
     * 循环法
     * @param target
     * @return
     */
    public int Fibonacci1(int target) {

        if(target==0){
            return 0;
        }
        if(target==1){
            return 1;
        }

        int f1=0;
        int f2=1;
        int result=0;
        for(int i=1;i<target;i++){
            result=f1+f2;
            f1=f2;
            f2=result;
        }
        return result;

    }




}
