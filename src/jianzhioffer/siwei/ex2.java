package jianzhioffer.siwei;

public class ex2 {
    /*
     * 求1+2+3+……+n
     *
     * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
     */

    /**
     *     利用短路与很巧妙
     *     &&前面为假后面不再执行，||前面为真后面不再执行
     */
    public int Sum_Solution(int n) {

        int ans = n;
        boolean t=(ans!=0) && ((ans += Sum_Solution(n - 1))!=0);
        return ans;
    }

    public int  Sum_Solution1(int n) {

        int sum = n;
        boolean ans = (n>0)&&((sum+=Sum_Solution1(n-1))>0);
        //boolean flag=(n==0)||((n+=Sum_Solution(n-1))>-1);
        return sum;
    }

    public static void main(String[] args) {
        ex2 e = new ex2();
        System.out.println(e.Sum_Solution1(3));
    }
}
