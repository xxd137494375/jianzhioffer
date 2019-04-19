package jianzhioffer.daimawanzhengxing;

public class ex1 {
    /*
        数值的整数次方
        给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
     */

    /**
     * 自己暴力实现
     * @param base
     * @param exponent
     * @return
     */
    public double Power(double base, int exponent) {
        double result = 1;
        if(exponent>=0){
            for(int i=0;i<exponent;i++){
                result=result*base;
            }
        }
        else{
            for(int i=0;i>exponent;i--){
                result=result*base;
            }
            result=1/result;
        }
        return result;
    }


    /**
     * 传统公式求解时间复杂度O(n)
     * @param base
     * @param exponent
     * @return
     */
    public double Power1(double base, int exponent) {
        double  result=1;
        for(int i=0;i<Math.abs(exponent);i++){
            result*=base;
        }
        if(exponent<0){
            result=1/result;
        }
        return result;
    }

    /**
     * 快速幂解法
     * 递归：n为偶数，a^n=a^n/2*a^n/2;n为奇数，a^n=（a^（n-1）/2）*（a^（n-1/2））*a
     * 时间复杂度O（logn）
     * @param base
     * @param exponent
     * @return
     */

    public double Power2(double base, int exponent) {
        int n=Math.abs(exponent);
        /*上面一句可以改成下面

        if(exponent==0 && base != 0)
            return 1;
        if(exponent==1)
            return base;
        if(base == 0 && exponent <= 0){
            throw new RuntimeException();
        }
        if(base ==0 && exponent>0){
            return 0;
        }
                  int n= exponent;
                if(exponent<0){
                    n = -exponent;
                }
        */
        if(n==0)
            return 1;
        if(n==1)
            return base;
        double  result=Power2(base,n>>1);//左移1位就是/2并且效率更快
        result*=result;
        if((n&1)==1) //n为奇数时 要乘以自身
            result*=base;
        if(exponent<0)
            result=1/result;
        return result;
    }

}
